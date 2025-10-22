package net.acidpop.escapevelocity;

import net.acidpop.escapevelocity.init.EscapeVelocityModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Client-side sound muffler (no debug).
 *
 * Behaviour:
 * - Only active in the Moon dimension and when the player does NOT have the PRESSURISED effect.
 * - Only applies when the player is in Survival or Adventure (does nothing in Creative or Spectator).
 * - Cancels distant sounds (> MAX_DISTANCE).
 * - For nearer sounds, tries to modify the original sound instance's volume/pitch in-place;
 *   if that fails it attempts to clone/construct a muffled instance and play it instead.
 */
@EventBusSubscriber(modid = "escape_velocity", bus = Bus.FORGE, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class SoundMufflingHandler {

    private static final double MAX_DISTANCE = 5.0D;
    private static final ResourceLocation MOON_DIMENSION = new ResourceLocation("escape_velocity", "moon");

    // Muffle strength (tweak to taste)
    private static final float MUFFLE_VOLUME_FACTOR = 0.02f;
    private static final float MUFFLE_PITCH_FACTOR = 0.5f;

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        try {
            if (event == null) return;

            Minecraft mc = Minecraft.getInstance();
            if (mc == null || mc.player == null || mc.level == null) return;

            // Only run on moon
            ResourceLocation currentDim = mc.level.dimension().location();
            if (!MOON_DIMENSION.equals(currentDim)) return;

            // If player is pressurised, leave sounds normal
            try {
                if (mc.player.hasEffect(EscapeVelocityModMobEffects.PRESSURISED.get())) return;
            } catch (Throwable ignored) { }

            // Only apply if player is in Survival or Adventure
            try {
                // isCreative() and isSpectator() are common Player helpers; if either is true, skip muffling
                if (mc.player.isCreative() || mc.player.isSpectator()) return;
            } catch (Throwable ignored) {
                // If these helpers are missing for some reason, be conservative and skip muffling
                return;
            }

            // Reflection: obtain original sound instance
            Object original = safeInvoke(event, "getSound");
            if (original == null) return;

            // Skip relative/non-positional sounds (UI, music, etc.)
            Boolean isRel = safeInvokeBoolean(original, "isRelative");
            if (Boolean.TRUE.equals(isRel)) return;

            // Get position
            Double sx = safeGetDouble(original, "getX", "x", "getPosX", "posX", "getXPos");
            Double sy = safeGetDouble(original, "getY", "y", "getPosY", "posY", "getYPos");
            Double sz = safeGetDouble(original, "getZ", "z", "getPosZ", "posZ", "getZPos");
            if (sx == null || sy == null || sz == null) return;

            double dx = sx - mc.player.getX();
            double dy = sy - mc.player.getY();
            double dz = sz - mc.player.getZ();
            double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);

            // If too far away -> cancel
            if (dist > MAX_DISTANCE) {
                safeInvokeWithArg(event, "setSound", new Class<?>[]{Object.class}, new Object[]{null});
                return;
            }

            // Nearer sounds -> try to muffle
            Float origV = safeGetFloat(original, "getVolume", "volume");
            Float origP = safeGetFloat(original, "getPitch", "pitch");
            if (origV == null) origV = 1.0f;
            if (origP == null) origP = 1.0f;

            float newV = origV * MUFFLE_VOLUME_FACTOR;
            float newP = origP * MUFFLE_PITCH_FACTOR;

            // Attempt in-place modification
            boolean modified = attemptModifyOriginalSound(original, newV, newP);
            if (modified) {
                // Modified in-place successfully; let the modified instance play.
                return;
            }

            // Fallback: try to clone/construct a muffled instance and play it
            Object locationOrEvent = null;
            for (String name : new String[]{"getLocation","getSound","getEventLocation","getName"}) {
                Object v = safeInvoke(original, name);
                if (v != null) { locationOrEvent = v; break; }
            }

            Object sourceObj = safeInvoke(original, "getSource");
            if (sourceObj == null) sourceObj = SoundSource.PLAYERS;

            Object muffled = tryConstructPositionedSound(locationOrEvent, sourceObj, newV, newP, sx, sy, sz);
            if (muffled != null) {
                safeInvokeWithArg(event, "setSound", new Class<?>[]{Object.class}, new Object[]{null});
                playViaSoundManager(mc, muffled);
            }
        } catch (Throwable ignored) {
            // Fail silently to avoid crashing the client
        }
    }

    // Attempt to modify the original sound instance (volume/pitch fields or setters)
    private static boolean attemptModifyOriginalSound(Object originalSound, float newVolume, float newPitch) {
        if (originalSound == null) return false;

        // Try setter methods
        String[] setVolNames = new String[]{"setVolume","setVol","set_newVolume","a","setVolumeFloat"};
        String[] setPitchNames = new String[]{"setPitch","setP","set_newPitch","b","setPitchFloat"};
        try {
            for (String name : setVolNames) {
                Method m = findMethodByName(originalSound.getClass(), name, 1);
                if (m != null) {
                    m.setAccessible(true);
                    m.invoke(originalSound, newVolume);
                    break;
                }
            }
            for (String name : setPitchNames) {
                Method m = findMethodByName(originalSound.getClass(), name, 1);
                if (m != null) {
                    m.setAccessible(true);
                    m.invoke(originalSound, newPitch);
                    break;
                }
            }
        } catch (Throwable ignored) {}

        // Try fields
        try {
            Field[] fields = originalSound.getClass().getDeclaredFields();
            boolean vOk = false, pOk = false;
            for (Field f : fields) {
                String fname = f.getName().toLowerCase();
                if (!vOk && (fname.contains("volume") || fname.equals("vol") || fname.equals("v"))) {
                    try { f.setAccessible(true);
                        if (f.getType() == float.class) { f.setFloat(originalSound, newVolume); vOk=true; }
                        else if (f.getType() == double.class) { f.setDouble(originalSound, newVolume); vOk=true; }
                        else if (Number.class.isAssignableFrom(f.getType())) { f.set(originalSound, Float.valueOf(newVolume)); vOk=true; }
                    } catch (Throwable ignored) {}
                }
                if (!pOk && (fname.contains("pitch") || fname.equals("p"))) {
                    try { f.setAccessible(true);
                        if (f.getType() == float.class) { f.setFloat(originalSound, newPitch); pOk=true; }
                        else if (f.getType() == double.class) { f.setDouble(originalSound, newPitch); pOk=true; }
                        else if (Number.class.isAssignableFrom(f.getType())) { f.set(originalSound, Float.valueOf(newPitch)); pOk=true; }
                    } catch (Throwable ignored) {}
                }
                if (vOk && pOk) break;
            }
            if (vOk || pOk) return true;
        } catch (Throwable ignored) {}

        // Walk superclasses for fields
        Class<?> cls = originalSound.getClass();
        while (cls != null && cls != Object.class) {
            try {
                Field[] fields = cls.getDeclaredFields();
                boolean vOk = false, pOk = false;
                for (Field f : fields) {
                    String fname = f.getName().toLowerCase();
                    if (!vOk && (fname.contains("volume") || fname.equals("vol") || fname.equals("v"))) {
                        try { f.setAccessible(true); if (f.getType()==float.class){ f.setFloat(originalSound, newVolume); vOk=true; } }
                        catch (Throwable ignored) {}
                    }
                    if (!pOk && (fname.contains("pitch") || fname.equals("p"))) {
                        try { f.setAccessible(true); if (f.getType()==float.class){ f.setFloat(originalSound, newPitch); pOk=true; } }
                        catch (Throwable ignored) {}
                    }
                    if (vOk && pOk) break;
                }
                if (vOk || pOk) return true;
            } catch (Throwable ignored) {}
            cls = cls.getSuperclass();
        }

        return false;
    }

    // Try to construct a positioned-type sound instance by probing common class names & constructors.
    private static Object tryConstructPositionedSound(Object locationOrEvent, Object sourceObj, float vol, float pitch, double x, double y, double z) {
        String[] candidates = new String[] {
                "net.minecraft.client.sounds.PositionedSoundInstance",
                "net.minecraft.client.resources.sounds.PositionedSoundInstance",
                "net.minecraft.client.audio.PositionedSoundRecord",
                "net.minecraft.client.audio.PositionedSoundInstance"
        };

        for (String clsName : candidates) {
            try {
                Class<?> cls = Class.forName(clsName);
                for (Constructor<?> ctor : cls.getDeclaredConstructors()) {
                    ctor.setAccessible(true);
                    Class<?>[] params = ctor.getParameterTypes();
                    Object[] args = buildArgsForConstructor(params, locationOrEvent, sourceObj, vol, pitch, x, y, z);
                    if (args == null) continue;
                    try {
                        Object inst = ctor.newInstance(args);
                        if (inst != null) return inst;
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException ignored) {}
                }
            } catch (ClassNotFoundException ignored) { }
        }
        return null;
    }

    private static Object[] buildArgsForConstructor(Class<?>[] params, Object locationOrEvent, Object sourceObj, float vol, float pitch, double x, double y, double z) {
        Object[] args = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            Class<?> p = params[i];
            if (p.isAssignableFrom(boolean.class) || p == Boolean.class) args[i] = false;
            else if (p == int.class || p == Integer.class) args[i] = 0;
            else if (p == float.class || p == Float.class) {
                if (!contains(args, vol)) { args[i] = vol; continue; }
                if (!contains(args, pitch)) { args[i] = pitch; continue; }
                args[i] = vol;
            } else if (p == double.class || p == Double.class) {
                if (!contains(args, x)) { args[i] = x; continue; }
                if (!contains(args, y)) { args[i] = y; continue; }
                if (!contains(args, z)) { args[i] = z; continue; }
                args[i] = 0.0d;
            } else {
                if (locationOrEvent != null && p.isAssignableFrom(locationOrEvent.getClass())) args[i] = locationOrEvent;
                else if (p.isAssignableFrom(SoundSource.class) && sourceObj instanceof SoundSource) args[i] = sourceObj;
                else {
                    String simple = p.getSimpleName().toLowerCase();
                    if (simple.contains("sound") && locationOrEvent != null) args[i] = locationOrEvent;
                    else if (simple.contains("source")) args[i] = SoundSource.PLAYERS;
                    else if (simple.contains("double") || simple.contains("float") || simple.contains("int") || simple.contains("boolean")) args[i] = 0;
                    else return null;
                }
            }
        }
        return args;
    }

    private static boolean contains(Object[] arr, Object v) { for (Object o : arr) if (o != null && o.equals(v)) return true; return false; }

    // Reflection helpers
    private static Object safeInvoke(Object target, String methodName, Object... args) {
        if (target == null) return null;
        try {
            Class<?> cls = target.getClass();
            Method m = findMethodByName(cls, methodName, args.length);
            if (m == null) return null;
            m.setAccessible(true);
            return m.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) { return null; }
    }
    private static Boolean safeInvokeBoolean(Object target, String methodName) {
        Object r = safeInvoke(target, methodName);
        if (r instanceof Boolean) return (Boolean) r;
        return null;
    }
    private static Object safeInvokeWithArg(Object target, String methodName, Class<?>[] paramTypes, Object[] args) {
        if (target == null) return null;
        try {
            Method m = target.getClass().getMethod(methodName, paramTypes);
            m.setAccessible(true);
            return m.invoke(target, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Method fallback = findMethodByName(target.getClass(), methodName, args.length);
            if (fallback != null) {
                try { fallback.setAccessible(true); return fallback.invoke(target, args); }
                catch (Throwable ignored) {}
            }
            return null;
        }
    }
    private static Double safeGetDouble(Object target, String... candidateMethodOrFieldNames) {
        for (String name : candidateMethodOrFieldNames) {
            Object v = safeInvoke(target, name);
            if (v instanceof Number) return ((Number) v).doubleValue();
            try {
                Field f = target.getClass().getDeclaredField(name);
                f.setAccessible(true);
                Object fv = f.get(target);
                if (fv instanceof Number) return ((Number) fv).doubleValue();
            } catch (NoSuchFieldException | IllegalAccessException ignored) {}
        }
        return null;
    }
    private static Float safeGetFloat(Object target, String... candidateMethodOrFieldNames) {
        for (String name : candidateMethodOrFieldNames) {
            Object v = safeInvoke(target, name);
            if (v instanceof Number) return ((Number) v).floatValue();
            try {
                Field f = target.getClass().getDeclaredField(name);
                f.setAccessible(true);
                Object fv = f.get(target);
                if (fv instanceof Number) return ((Number) fv).floatValue();
            } catch (NoSuchFieldException | IllegalAccessException ignored) {}
        }
        return null;
    }
    private static Method findMethodByName(Class<?> cls, String name, int paramCount) {
        for (Method m : cls.getMethods()) if (m.getName().equals(name) && m.getParameterCount() == paramCount) return m;
        for (Method m : cls.getDeclaredMethods()) if (m.getName().equals(name) && m.getParameterCount() == paramCount) return m;
        return null;
    }
    private static Method findMethodByExactName(Class<?> cls, String name) {
        for (Method m : cls.getMethods()) if (m.getName().equals(name)) return m;
        for (Method m : cls.getDeclaredMethods()) if (m.getName().equals(name)) return m;
        return null;
    }

    // Try to play via sound manager; best-effort
    private static boolean playViaSoundManager(Minecraft mc, Object soundInstance) {
        try {
            Object soundManager = safeInvoke(mc, "getSoundManager");
            if (soundManager == null) return false;
            Method m = findMethodByName(soundManager.getClass(), "play", 1);
            if (m != null) { m.invoke(soundManager, soundInstance); return true; }
            Method m2 = findMethodByExactName(soundManager.getClass(), "playSound");
            if (m2 != null) { m2.invoke(soundManager, soundInstance); return true; }
            Method m3 = findMethodByName(soundManager.getClass(), "play", 2);
            if (m3 != null) { try { m3.invoke(soundManager, soundInstance, 0.0d); return true; } catch (IllegalArgumentException ignored) {} }
        } catch (Throwable ignored) {}
        return false;
    }
}
