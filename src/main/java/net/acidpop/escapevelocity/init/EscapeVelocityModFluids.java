
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.acidpop.escapevelocity.fluid.OxygenFluid;
import net.acidpop.escapevelocity.fluid.NaphthaFluid;
import net.acidpop.escapevelocity.fluid.LiquidOxygenFluid;
import net.acidpop.escapevelocity.fluid.KeroseneFluid;
import net.acidpop.escapevelocity.fluid.HydrogenFluid;
import net.acidpop.escapevelocity.fluid.CrudeOilFluid;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, EscapeVelocityMod.MODID);
	public static final RegistryObject<FlowingFluid> CRUDE_OIL = REGISTRY.register("crude_oil", () -> new CrudeOilFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_CRUDE_OIL = REGISTRY.register("flowing_crude_oil", () -> new CrudeOilFluid.Flowing());
	public static final RegistryObject<FlowingFluid> KEROSENE = REGISTRY.register("kerosene", () -> new KeroseneFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_KEROSENE = REGISTRY.register("flowing_kerosene", () -> new KeroseneFluid.Flowing());
	public static final RegistryObject<FlowingFluid> NAPHTHA = REGISTRY.register("naphtha", () -> new NaphthaFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_NAPHTHA = REGISTRY.register("flowing_naphtha", () -> new NaphthaFluid.Flowing());
	public static final RegistryObject<FlowingFluid> LIQUID_OXYGEN = REGISTRY.register("liquid_oxygen", () -> new LiquidOxygenFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_OXYGEN = REGISTRY.register("flowing_liquid_oxygen", () -> new LiquidOxygenFluid.Flowing());
	public static final RegistryObject<FlowingFluid> HYDROGEN = REGISTRY.register("hydrogen", () -> new HydrogenFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN = REGISTRY.register("flowing_hydrogen", () -> new HydrogenFluid.Flowing());
	public static final RegistryObject<FlowingFluid> OXYGEN = REGISTRY.register("oxygen", () -> new OxygenFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_OXYGEN = REGISTRY.register("flowing_oxygen", () -> new OxygenFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(CRUDE_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CRUDE_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(KEROSENE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_KEROSENE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(NAPHTHA.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_NAPHTHA.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LIQUID_OXYGEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_OXYGEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(HYDROGEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_HYDROGEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(OXYGEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_OXYGEN.get(), RenderType.translucent());
		}
	}
}
