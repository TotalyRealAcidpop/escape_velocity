
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.acidpop.escapevelocity.world.inventory.PowerNodeUIMenu;
import net.acidpop.escapevelocity.world.inventory.LunaRocketGUIMenu;
import net.acidpop.escapevelocity.world.inventory.ElectrolyzerTopUIMenu;
import net.acidpop.escapevelocity.world.inventory.ElectrolyzerRightUIMenu;
import net.acidpop.escapevelocity.world.inventory.ElectrolyzerLeftUIMenu;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EscapeVelocityMod.MODID);
	public static final RegistryObject<MenuType<PowerNodeUIMenu>> POWER_NODE_UI = REGISTRY.register("power_node_ui", () -> IForgeMenuType.create(PowerNodeUIMenu::new));
	public static final RegistryObject<MenuType<ElectrolyzerTopUIMenu>> ELECTROLYZER_TOP_UI = REGISTRY.register("electrolyzer_top_ui", () -> IForgeMenuType.create(ElectrolyzerTopUIMenu::new));
	public static final RegistryObject<MenuType<ElectrolyzerLeftUIMenu>> ELECTROLYZER_LEFT_UI = REGISTRY.register("electrolyzer_left_ui", () -> IForgeMenuType.create(ElectrolyzerLeftUIMenu::new));
	public static final RegistryObject<MenuType<ElectrolyzerRightUIMenu>> ELECTROLYZER_RIGHT_UI = REGISTRY.register("electrolyzer_right_ui", () -> IForgeMenuType.create(ElectrolyzerRightUIMenu::new));
	public static final RegistryObject<MenuType<LunaRocketGUIMenu>> LUNA_ROCKET_GUI = REGISTRY.register("luna_rocket_gui", () -> IForgeMenuType.create(LunaRocketGUIMenu::new));
}
