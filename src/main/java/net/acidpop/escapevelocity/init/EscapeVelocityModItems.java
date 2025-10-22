
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.acidpop.escapevelocity.item.VariantChangerItem;
import net.acidpop.escapevelocity.item.SulfurDustItem;
import net.acidpop.escapevelocity.item.SteelIngotItem;
import net.acidpop.escapevelocity.item.SpeakerItem;
import net.acidpop.escapevelocity.item.SolararrayUpscaledItem;
import net.acidpop.escapevelocity.item.SolararrayMultiblockItem;
import net.acidpop.escapevelocity.item.SolararrayItem;
import net.acidpop.escapevelocity.item.SolarCellItem;
import net.acidpop.escapevelocity.item.SiliconItem;
import net.acidpop.escapevelocity.item.SiliconDustItem;
import net.acidpop.escapevelocity.item.SiliconCompoundItem;
import net.acidpop.escapevelocity.item.RubberSheetItem;
import net.acidpop.escapevelocity.item.RocketSheetItem;
import net.acidpop.escapevelocity.item.ReinforcedFabricItem;
import net.acidpop.escapevelocity.item.ReinforcedCompositeSheetItem;
import net.acidpop.escapevelocity.item.RawNickelItem;
import net.acidpop.escapevelocity.item.RawAluminiumItem;
import net.acidpop.escapevelocity.item.QuartzDustItem;
import net.acidpop.escapevelocity.item.OxygenTankItem;
import net.acidpop.escapevelocity.item.OxygenContainerItem;
import net.acidpop.escapevelocity.item.OilRefineryUpscaledItem;
import net.acidpop.escapevelocity.item.OilRefineryMultiblockItem;
import net.acidpop.escapevelocity.item.OilRefineryItem;
import net.acidpop.escapevelocity.item.NickelIngotItem;
import net.acidpop.escapevelocity.item.NaphthaItem;
import net.acidpop.escapevelocity.item.LunarSuitItem;
import net.acidpop.escapevelocity.item.LunarStrapOnBoosterItem;
import net.acidpop.escapevelocity.item.LunarRocketItem;
import net.acidpop.escapevelocity.item.LunarRegolithDustItem;
import net.acidpop.escapevelocity.item.LunarLanderItemItem;
import net.acidpop.escapevelocity.item.LunarCockpitItem;
import net.acidpop.escapevelocity.item.LunarBoosterItem;
import net.acidpop.escapevelocity.item.LiquidOxygenItem;
import net.acidpop.escapevelocity.item.KeroseneItem;
import net.acidpop.escapevelocity.item.HydrogenContainerItem;
import net.acidpop.escapevelocity.item.HelpyToolyItem;
import net.acidpop.escapevelocity.item.HelmetVisorItem;
import net.acidpop.escapevelocity.item.GlassFiberItem;
import net.acidpop.escapevelocity.item.GasContainerItem;
import net.acidpop.escapevelocity.item.EnvironmentalAudioModuleItem;
import net.acidpop.escapevelocity.item.ElectrolyzerUpscaledItem;
import net.acidpop.escapevelocity.item.ElectrolyzerMultiblockItem;
import net.acidpop.escapevelocity.item.ElectrolyzerItem;
import net.acidpop.escapevelocity.item.CrudeOilItem;
import net.acidpop.escapevelocity.item.CircuitBoardItem;
import net.acidpop.escapevelocity.item.BetaCompositeItem;
import net.acidpop.escapevelocity.item.BetaClothItem;
import net.acidpop.escapevelocity.item.AluminiumIngotItem;
import net.acidpop.escapevelocity.item.AdvancedAlloyMeshItem;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EscapeVelocityMod.MODID);
	public static final RegistryObject<Item> HABITAT_SEALER = block(EscapeVelocityModBlocks.HABITAT_SEALER);
	public static final RegistryObject<Item> REINFORCED_GLASS = block(EscapeVelocityModBlocks.REINFORCED_GLASS);
	public static final RegistryObject<Item> LUNAR_REGOLITH = block(EscapeVelocityModBlocks.LUNAR_REGOLITH);
	public static final RegistryObject<Item> LUNAR_BASALT = block(EscapeVelocityModBlocks.LUNAR_BASALT);
	public static final RegistryObject<Item> LUNAR_REGOLITH_DUST = REGISTRY.register("lunar_regolith_dust", () -> new LunarRegolithDustItem());
	public static final RegistryObject<Item> FLUID_PIPE = block(EscapeVelocityModBlocks.FLUID_PIPE);
	public static final RegistryObject<Item> CABLE = block(EscapeVelocityModBlocks.CABLE);
	public static final RegistryObject<Item> REGOLITH_COLLECTOR_SPAWN_EGG = REGISTRY.register("regolith_collector_spawn_egg", () -> new ForgeSpawnEggItem(EscapeVelocityModEntities.REGOLITH_COLLECTOR, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> HELPY_TOOLY = REGISTRY.register("helpy_tooly", () -> new HelpyToolyItem());
	public static final RegistryObject<Item> STEEL_FRAME = block(EscapeVelocityModBlocks.STEEL_FRAME);
	public static final RegistryObject<Item> SOLAR_PANEL = block(EscapeVelocityModBlocks.SOLAR_PANEL);
	public static final RegistryObject<Item> STEEL_BLOCK = block(EscapeVelocityModBlocks.STEEL_BLOCK);
	public static final RegistryObject<Item> POWER_NODE = block(EscapeVelocityModBlocks.POWER_NODE);
	public static final RegistryObject<Item> VARIANT_CHANGER = REGISTRY.register("variant_changer", () -> new VariantChangerItem());
	public static final RegistryObject<Item> STEEL_INGOT = REGISTRY.register("steel_ingot", () -> new SteelIngotItem());
	public static final RegistryObject<Item> LUNAR_SUIT_HELMET = REGISTRY.register("lunar_suit_helmet", () -> new LunarSuitItem.Helmet());
	public static final RegistryObject<Item> LUNAR_SUIT_CHESTPLATE = REGISTRY.register("lunar_suit_chestplate", () -> new LunarSuitItem.Chestplate());
	public static final RegistryObject<Item> LUNAR_SUIT_LEGGINGS = REGISTRY.register("lunar_suit_leggings", () -> new LunarSuitItem.Leggings());
	public static final RegistryObject<Item> LUNAR_SUIT_BOOTS = REGISTRY.register("lunar_suit_boots", () -> new LunarSuitItem.Boots());
	public static final RegistryObject<Item> RUBBER_SHEET = REGISTRY.register("rubber_sheet", () -> new RubberSheetItem());
	public static final RegistryObject<Item> CRUDE_OIL_BUCKET = REGISTRY.register("crude_oil_bucket", () -> new CrudeOilItem());
	public static final RegistryObject<Item> KEROSENE_BUCKET = REGISTRY.register("kerosene_bucket", () -> new KeroseneItem());
	public static final RegistryObject<Item> NAPHTHA_BUCKET = REGISTRY.register("naphtha_bucket", () -> new NaphthaItem());
	public static final RegistryObject<Item> LIQUID_OXYGEN_BUCKET = REGISTRY.register("liquid_oxygen_bucket", () -> new LiquidOxygenItem());
	public static final RegistryObject<Item> SULFUR_DUST = REGISTRY.register("sulfur_dust", () -> new SulfurDustItem());
	public static final RegistryObject<Item> SOLARARRAY = REGISTRY.register("solararray", () -> new SolararrayItem());
	public static final RegistryObject<Item> SOLARARRAY_UPSCALED = REGISTRY.register("solararray_upscaled", () -> new SolararrayUpscaledItem());
	public static final RegistryObject<Item> SOLARARRAY_MULTIBLOCK = REGISTRY.register("solararray_multiblock", () -> new SolararrayMultiblockItem());
	public static final RegistryObject<Item> FLUID_TANK = block(EscapeVelocityModBlocks.FLUID_TANK);
	public static final RegistryObject<Item> NICKEL_FRAME = block(EscapeVelocityModBlocks.NICKEL_FRAME);
	public static final RegistryObject<Item> NICKEL_ORE = block(EscapeVelocityModBlocks.NICKEL_ORE);
	public static final RegistryObject<Item> RAW_NICKEL = REGISTRY.register("raw_nickel", () -> new RawNickelItem());
	public static final RegistryObject<Item> NICKEL_INGOT = REGISTRY.register("nickel_ingot", () -> new NickelIngotItem());
	public static final RegistryObject<Item> ELECTROLYZER = REGISTRY.register("electrolyzer", () -> new ElectrolyzerItem());
	public static final RegistryObject<Item> REFRACTORY_MIX = block(EscapeVelocityModBlocks.REFRACTORY_MIX);
	public static final RegistryObject<Item> REFRACTORY_BRICK = block(EscapeVelocityModBlocks.REFRACTORY_BRICK);
	public static final RegistryObject<Item> INDUSTRIAL_FURNACE = block(EscapeVelocityModBlocks.INDUSTRIAL_FURNACE);
	public static final RegistryObject<Item> ELECTROLYZER_UPSCALED = REGISTRY.register("electrolyzer_upscaled", () -> new ElectrolyzerUpscaledItem());
	public static final RegistryObject<Item> ELECTROLYZER_MULTIBLOCK = REGISTRY.register("electrolyzer_multiblock", () -> new ElectrolyzerMultiblockItem());
	public static final RegistryObject<Item> GAS_CONTAINER = REGISTRY.register("gas_container", () -> new GasContainerItem());
	public static final RegistryObject<Item> HYDROGEN_CONTAINER = REGISTRY.register("hydrogen_container", () -> new HydrogenContainerItem());
	public static final RegistryObject<Item> OXYGEN_CONTAINER = REGISTRY.register("oxygen_container", () -> new OxygenContainerItem());
	public static final RegistryObject<Item> GLASS_FIBER = REGISTRY.register("glass_fiber", () -> new GlassFiberItem());
	public static final RegistryObject<Item> REINFORCED_FABRIC = REGISTRY.register("reinforced_fabric", () -> new ReinforcedFabricItem());
	public static final RegistryObject<Item> BETA_COMPOSITE = REGISTRY.register("beta_composite", () -> new BetaCompositeItem());
	public static final RegistryObject<Item> BETA_CLOTH = REGISTRY.register("beta_cloth", () -> new BetaClothItem());
	public static final RegistryObject<Item> ALUMINIUM_ORE = block(EscapeVelocityModBlocks.ALUMINIUM_ORE);
	public static final RegistryObject<Item> RAW_ALUMINIUM = REGISTRY.register("raw_aluminium", () -> new RawAluminiumItem());
	public static final RegistryObject<Item> ALUMINIUM_INGOT = REGISTRY.register("aluminium_ingot", () -> new AluminiumIngotItem());
	public static final RegistryObject<Item> HELMET_VISOR = REGISTRY.register("helmet_visor", () -> new HelmetVisorItem());
	public static final RegistryObject<Item> SOLAR_CELL = REGISTRY.register("solar_cell", () -> new SolarCellItem());
	public static final RegistryObject<Item> QUARTZ_DUST = REGISTRY.register("quartz_dust", () -> new QuartzDustItem());
	public static final RegistryObject<Item> SILICON_DUST = REGISTRY.register("silicon_dust", () -> new SiliconDustItem());
	public static final RegistryObject<Item> SILICON_COMPOUND = REGISTRY.register("silicon_compound", () -> new SiliconCompoundItem());
	public static final RegistryObject<Item> SILICON = REGISTRY.register("silicon", () -> new SiliconItem());
	public static final RegistryObject<Item> OXYGEN_TANK = REGISTRY.register("oxygen_tank", () -> new OxygenTankItem());
	public static final RegistryObject<Item> CIRCUIT_BOARD = REGISTRY.register("circuit_board", () -> new CircuitBoardItem());
	public static final RegistryObject<Item> SPEAKER = REGISTRY.register("speaker", () -> new SpeakerItem());
	public static final RegistryObject<Item> ENVIRONMENTAL_AUDIO_MODULE = REGISTRY.register("environmental_audio_module", () -> new EnvironmentalAudioModuleItem());
	public static final RegistryObject<Item> OIL_REFINERY = REGISTRY.register("oil_refinery", () -> new OilRefineryItem());
	public static final RegistryObject<Item> OIL_REFINERY_UPSCALED = REGISTRY.register("oil_refinery_upscaled", () -> new OilRefineryUpscaledItem());
	public static final RegistryObject<Item> OIL_REFINERY_MULTIBLOCK = REGISTRY.register("oil_refinery_multiblock", () -> new OilRefineryMultiblockItem());
	public static final RegistryObject<Item> LUNAR_COCKPIT = REGISTRY.register("lunar_cockpit", () -> new LunarCockpitItem());
	public static final RegistryObject<Item> LUNAR_BOOSTER = REGISTRY.register("lunar_booster", () -> new LunarBoosterItem());
	public static final RegistryObject<Item> LUNAR_STRAP_ON_BOOSTER = REGISTRY.register("lunar_strap_on_booster", () -> new LunarStrapOnBoosterItem());
	public static final RegistryObject<Item> LUNAR_ROCKET = REGISTRY.register("lunar_rocket", () -> new LunarRocketItem());
	public static final RegistryObject<Item> ROCKET_BUILDER = block(EscapeVelocityModBlocks.ROCKET_BUILDER);
	public static final RegistryObject<Item> LUNAR_LANDER_ITEM = REGISTRY.register("lunar_lander_item", () -> new LunarLanderItemItem());
	public static final RegistryObject<Item> REINFORCED_COMPOSITE_SHEET = REGISTRY.register("reinforced_composite_sheet", () -> new ReinforcedCompositeSheetItem());
	public static final RegistryObject<Item> ADVANCED_ALLOY_MESH = REGISTRY.register("advanced_alloy_mesh", () -> new AdvancedAlloyMeshItem());
	public static final RegistryObject<Item> ROCKET_SHEET = REGISTRY.register("rocket_sheet", () -> new RocketSheetItem());
	public static final RegistryObject<Item> SEALED_CABLE = block(EscapeVelocityModBlocks.SEALED_CABLE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
