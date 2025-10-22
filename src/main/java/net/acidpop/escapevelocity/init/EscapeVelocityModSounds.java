
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EscapeVelocityMod.MODID);
	public static final RegistryObject<SoundEvent> GENERATOR = REGISTRY.register("generator", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("escape_velocity", "generator")));
}
