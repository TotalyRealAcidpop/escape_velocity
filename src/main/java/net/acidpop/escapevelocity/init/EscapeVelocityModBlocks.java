
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.acidpop.escapevelocity.block.SteelFrameBlock;
import net.acidpop.escapevelocity.block.SteelBlockBlock;
import net.acidpop.escapevelocity.block.SolarPanelBlock;
import net.acidpop.escapevelocity.block.SealedCableBlock;
import net.acidpop.escapevelocity.block.RocketBuilderBlock;
import net.acidpop.escapevelocity.block.ReinforcedGlassBlock;
import net.acidpop.escapevelocity.block.RefractoryMixBlock;
import net.acidpop.escapevelocity.block.RefractoryBrickBlock;
import net.acidpop.escapevelocity.block.PowerNodeBlock;
import net.acidpop.escapevelocity.block.OxygenBlock;
import net.acidpop.escapevelocity.block.NickelOreBlock;
import net.acidpop.escapevelocity.block.NickelFrameBlock;
import net.acidpop.escapevelocity.block.NaphthaBlock;
import net.acidpop.escapevelocity.block.LunarRegolithBlock;
import net.acidpop.escapevelocity.block.LunarBasaltBlock;
import net.acidpop.escapevelocity.block.LiquidOxygenBlock;
import net.acidpop.escapevelocity.block.KeroseneBlock;
import net.acidpop.escapevelocity.block.IndustrialFurnaceBlock;
import net.acidpop.escapevelocity.block.HydrogenBlock;
import net.acidpop.escapevelocity.block.HabitatSealerBlock;
import net.acidpop.escapevelocity.block.FluidTankBlock;
import net.acidpop.escapevelocity.block.FluidPipeBlock;
import net.acidpop.escapevelocity.block.CrudeOilBlock;
import net.acidpop.escapevelocity.block.CableBlock;
import net.acidpop.escapevelocity.block.AluminiumOreBlock;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EscapeVelocityMod.MODID);
	public static final RegistryObject<Block> HABITAT_SEALER = REGISTRY.register("habitat_sealer", () -> new HabitatSealerBlock());
	public static final RegistryObject<Block> REINFORCED_GLASS = REGISTRY.register("reinforced_glass", () -> new ReinforcedGlassBlock());
	public static final RegistryObject<Block> LUNAR_REGOLITH = REGISTRY.register("lunar_regolith", () -> new LunarRegolithBlock());
	public static final RegistryObject<Block> LUNAR_BASALT = REGISTRY.register("lunar_basalt", () -> new LunarBasaltBlock());
	public static final RegistryObject<Block> FLUID_PIPE = REGISTRY.register("fluid_pipe", () -> new FluidPipeBlock());
	public static final RegistryObject<Block> CABLE = REGISTRY.register("cable", () -> new CableBlock());
	public static final RegistryObject<Block> STEEL_FRAME = REGISTRY.register("steel_frame", () -> new SteelFrameBlock());
	public static final RegistryObject<Block> SOLAR_PANEL = REGISTRY.register("solar_panel", () -> new SolarPanelBlock());
	public static final RegistryObject<Block> STEEL_BLOCK = REGISTRY.register("steel_block", () -> new SteelBlockBlock());
	public static final RegistryObject<Block> POWER_NODE = REGISTRY.register("power_node", () -> new PowerNodeBlock());
	public static final RegistryObject<Block> CRUDE_OIL = REGISTRY.register("crude_oil", () -> new CrudeOilBlock());
	public static final RegistryObject<Block> KEROSENE = REGISTRY.register("kerosene", () -> new KeroseneBlock());
	public static final RegistryObject<Block> NAPHTHA = REGISTRY.register("naphtha", () -> new NaphthaBlock());
	public static final RegistryObject<Block> LIQUID_OXYGEN = REGISTRY.register("liquid_oxygen", () -> new LiquidOxygenBlock());
	public static final RegistryObject<Block> FLUID_TANK = REGISTRY.register("fluid_tank", () -> new FluidTankBlock());
	public static final RegistryObject<Block> NICKEL_FRAME = REGISTRY.register("nickel_frame", () -> new NickelFrameBlock());
	public static final RegistryObject<Block> NICKEL_ORE = REGISTRY.register("nickel_ore", () -> new NickelOreBlock());
	public static final RegistryObject<Block> REFRACTORY_MIX = REGISTRY.register("refractory_mix", () -> new RefractoryMixBlock());
	public static final RegistryObject<Block> REFRACTORY_BRICK = REGISTRY.register("refractory_brick", () -> new RefractoryBrickBlock());
	public static final RegistryObject<Block> INDUSTRIAL_FURNACE = REGISTRY.register("industrial_furnace", () -> new IndustrialFurnaceBlock());
	public static final RegistryObject<Block> HYDROGEN = REGISTRY.register("hydrogen", () -> new HydrogenBlock());
	public static final RegistryObject<Block> OXYGEN = REGISTRY.register("oxygen", () -> new OxygenBlock());
	public static final RegistryObject<Block> ALUMINIUM_ORE = REGISTRY.register("aluminium_ore", () -> new AluminiumOreBlock());
	public static final RegistryObject<Block> ROCKET_BUILDER = REGISTRY.register("rocket_builder", () -> new RocketBuilderBlock());
	public static final RegistryObject<Block> SEALED_CABLE = REGISTRY.register("sealed_cable", () -> new SealedCableBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
