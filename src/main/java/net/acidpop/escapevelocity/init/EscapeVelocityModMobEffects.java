
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.acidpop.escapevelocity.potion.TurbulenceMobEffect;
import net.acidpop.escapevelocity.potion.SuffocationMobEffect;
import net.acidpop.escapevelocity.potion.RadiationMobEffect;
import net.acidpop.escapevelocity.potion.PressurisedMobEffect;
import net.acidpop.escapevelocity.potion.FreezingMobEffect;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EscapeVelocityMod.MODID);
	public static final RegistryObject<MobEffect> FREEZING = REGISTRY.register("freezing", () -> new FreezingMobEffect());
	public static final RegistryObject<MobEffect> RADIATION = REGISTRY.register("radiation", () -> new RadiationMobEffect());
	public static final RegistryObject<MobEffect> SUFFOCATION = REGISTRY.register("suffocation", () -> new SuffocationMobEffect());
	public static final RegistryObject<MobEffect> TURBULENCE = REGISTRY.register("turbulence", () -> new TurbulenceMobEffect());
	public static final RegistryObject<MobEffect> PRESSURISED = REGISTRY.register("pressurised", () -> new PressurisedMobEffect());
}
