package net.acidpop.escapevelocity.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "escape_velocity", value = Dist.CLIENT)
public class CameraShakeHandler {
    private static final ResourceLocation TURBULENCE = new ResourceLocation("escape_velocity", "turbulence");
    private static final Random random = new Random();
    private static float time = 0f;

    @SubscribeEvent
    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        MobEffectInstance effect = player.getEffect(net.minecraftforge.registries.ForgeRegistries.MOB_EFFECTS.getValue(TURBULENCE));
        if (effect != null) {
            time += 0.1f; // speed of oscillation (lower = slower, smoother)

            // Read the distortion effects setting
            float distortionStrength = getDistortionStrength();

            // Debug: print the slider value
            //System.out.println("Distortion Effects slider value: " + distortionStrength);

            // Base strength multiplied by slider value
            float strength = 1.5f * distortionStrength;

            // Smooth sine-based shake with slight randomness
            float shakeX = (float)Math.sin(time * 2.1) * strength + (random.nextFloat() - 0.5f) * 0.2f;
            float shakeY = (float)Math.sin(time * 1.7) * strength + (random.nextFloat() - 0.5f) * 0.2f;
            float shakeZ = (float)Math.sin(time * 2.7) * strength * 0.5f;

            // Apply to camera
            event.setYaw(event.getYaw() + shakeX);
            event.setPitch(event.getPitch() + shakeY);
            event.setRoll(event.getRoll() + shakeZ);
        }
    }

    private static float getDistortionStrength() {
        File optionsFile = new File(Minecraft.getInstance().gameDirectory, "options.txt");
        if (!optionsFile.exists()) return 1.0f; // Default to full intensity

        try (FileReader reader = new FileReader(optionsFile)) {
            Properties properties = new Properties();
            properties.load(reader);

            String distortionValue = properties.getProperty("screenEffectScale", "1.0");
            return Math.max(0.0f, Math.min(1.0f, Float.parseFloat(distortionValue)));
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return 1.0f; // Default to full intensity on error
        }
    }
}
