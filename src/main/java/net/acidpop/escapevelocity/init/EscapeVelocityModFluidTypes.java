
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.acidpop.escapevelocity.fluid.types.OxygenFluidType;
import net.acidpop.escapevelocity.fluid.types.NaphthaFluidType;
import net.acidpop.escapevelocity.fluid.types.LiquidOxygenFluidType;
import net.acidpop.escapevelocity.fluid.types.KeroseneFluidType;
import net.acidpop.escapevelocity.fluid.types.HydrogenFluidType;
import net.acidpop.escapevelocity.fluid.types.CrudeOilFluidType;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, EscapeVelocityMod.MODID);
	public static final RegistryObject<FluidType> CRUDE_OIL_TYPE = REGISTRY.register("crude_oil", () -> new CrudeOilFluidType());
	public static final RegistryObject<FluidType> KEROSENE_TYPE = REGISTRY.register("kerosene", () -> new KeroseneFluidType());
	public static final RegistryObject<FluidType> NAPHTHA_TYPE = REGISTRY.register("naphtha", () -> new NaphthaFluidType());
	public static final RegistryObject<FluidType> LIQUID_OXYGEN_TYPE = REGISTRY.register("liquid_oxygen", () -> new LiquidOxygenFluidType());
	public static final RegistryObject<FluidType> HYDROGEN_TYPE = REGISTRY.register("hydrogen", () -> new HydrogenFluidType());
	public static final RegistryObject<FluidType> OXYGEN_TYPE = REGISTRY.register("oxygen", () -> new OxygenFluidType());
}
