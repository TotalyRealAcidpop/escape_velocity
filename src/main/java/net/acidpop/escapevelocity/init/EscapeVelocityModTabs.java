
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EscapeVelocityMod.MODID);
	public static final RegistryObject<CreativeModeTab> ESCAPE_VELOCITY = REGISTRY.register("escape_velocity",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.escape_velocity.escape_velocity")).icon(() -> new ItemStack(EscapeVelocityModBlocks.LUNAR_REGOLITH.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EscapeVelocityModItems.LUNAR_ROCKET.get());
				tabData.accept(EscapeVelocityModItems.SULFUR_DUST.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_REGOLITH_DUST.get());
				tabData.accept(EscapeVelocityModItems.QUARTZ_DUST.get());
				tabData.accept(EscapeVelocityModItems.SILICON_DUST.get());
				tabData.accept(EscapeVelocityModItems.SILICON_COMPOUND.get());
				tabData.accept(EscapeVelocityModItems.SILICON.get());
				tabData.accept(EscapeVelocityModItems.STEEL_INGOT.get());
				tabData.accept(EscapeVelocityModItems.NICKEL_INGOT.get());
				tabData.accept(EscapeVelocityModItems.ALUMINIUM_INGOT.get());
				tabData.accept(EscapeVelocityModItems.RAW_NICKEL.get());
				tabData.accept(EscapeVelocityModItems.RAW_ALUMINIUM.get());
				tabData.accept(EscapeVelocityModItems.RUBBER_SHEET.get());
				tabData.accept(EscapeVelocityModItems.GLASS_FIBER.get());
				tabData.accept(EscapeVelocityModItems.REINFORCED_FABRIC.get());
				tabData.accept(EscapeVelocityModItems.BETA_CLOTH.get());
				tabData.accept(EscapeVelocityModItems.BETA_COMPOSITE.get());
				tabData.accept(EscapeVelocityModItems.SOLAR_CELL.get());
				tabData.accept(EscapeVelocityModItems.CIRCUIT_BOARD.get());
				tabData.accept(EscapeVelocityModItems.REINFORCED_COMPOSITE_SHEET.get());
				tabData.accept(EscapeVelocityModItems.ADVANCED_ALLOY_MESH.get());
				tabData.accept(EscapeVelocityModItems.ROCKET_SHEET.get());
				tabData.accept(EscapeVelocityModItems.SPEAKER.get());
				tabData.accept(EscapeVelocityModItems.ENVIRONMENTAL_AUDIO_MODULE.get());
				tabData.accept(EscapeVelocityModItems.HELMET_VISOR.get());
				tabData.accept(EscapeVelocityModItems.OXYGEN_TANK.get());
				tabData.accept(EscapeVelocityModItems.GAS_CONTAINER.get());
				tabData.accept(EscapeVelocityModItems.HYDROGEN_CONTAINER.get());
				tabData.accept(EscapeVelocityModItems.OXYGEN_CONTAINER.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_SUIT_HELMET.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_SUIT_CHESTPLATE.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_SUIT_LEGGINGS.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_SUIT_BOOTS.get());
				tabData.accept(EscapeVelocityModBlocks.ROCKET_BUILDER.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.STEEL_FRAME.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.STEEL_BLOCK.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.POWER_NODE.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.NICKEL_FRAME.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.SOLAR_PANEL.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.FLUID_TANK.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.INDUSTRIAL_FURNACE.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.REINFORCED_GLASS.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.SEALED_CABLE.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.HABITAT_SEALER.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.CABLE.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.REFRACTORY_MIX.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.REFRACTORY_BRICK.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.NICKEL_ORE.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.ALUMINIUM_ORE.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.LUNAR_REGOLITH.get().asItem());
				tabData.accept(EscapeVelocityModBlocks.LUNAR_BASALT.get().asItem());
				tabData.accept(EscapeVelocityModItems.LUNAR_COCKPIT.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_BOOSTER.get());
				tabData.accept(EscapeVelocityModItems.LUNAR_STRAP_ON_BOOSTER.get());
				tabData.accept(EscapeVelocityModItems.SOLARARRAY.get());
				tabData.accept(EscapeVelocityModItems.ELECTROLYZER.get());
				tabData.accept(EscapeVelocityModItems.OIL_REFINERY.get());
				tabData.accept(EscapeVelocityModItems.CRUDE_OIL_BUCKET.get());
				tabData.accept(EscapeVelocityModItems.KEROSENE_BUCKET.get());
				tabData.accept(EscapeVelocityModItems.NAPHTHA_BUCKET.get());
				tabData.accept(EscapeVelocityModItems.LIQUID_OXYGEN_BUCKET.get());
				tabData.accept(EscapeVelocityModItems.REGOLITH_COLLECTOR_SPAWN_EGG.get());
			}).build());
}
