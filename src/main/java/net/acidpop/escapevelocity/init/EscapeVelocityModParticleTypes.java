
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, EscapeVelocityMod.MODID);
	public static final RegistryObject<SimpleParticleType> REGOLITH_COLLECTOR_TRAIL = REGISTRY.register("regolith_collector_trail", () -> new SimpleParticleType(false));
}
