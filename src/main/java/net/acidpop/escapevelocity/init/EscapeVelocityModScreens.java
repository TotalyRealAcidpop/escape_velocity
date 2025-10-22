
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.acidpop.escapevelocity.client.gui.PowerNodeUIScreen;
import net.acidpop.escapevelocity.client.gui.LunaRocketGUIScreen;
import net.acidpop.escapevelocity.client.gui.ElectrolyzerTopUIScreen;
import net.acidpop.escapevelocity.client.gui.ElectrolyzerRightUIScreen;
import net.acidpop.escapevelocity.client.gui.ElectrolyzerLeftUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EscapeVelocityModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EscapeVelocityModMenus.POWER_NODE_UI.get(), PowerNodeUIScreen::new);
			MenuScreens.register(EscapeVelocityModMenus.ELECTROLYZER_TOP_UI.get(), ElectrolyzerTopUIScreen::new);
			MenuScreens.register(EscapeVelocityModMenus.ELECTROLYZER_LEFT_UI.get(), ElectrolyzerLeftUIScreen::new);
			MenuScreens.register(EscapeVelocityModMenus.ELECTROLYZER_RIGHT_UI.get(), ElectrolyzerRightUIScreen::new);
			MenuScreens.register(EscapeVelocityModMenus.LUNA_ROCKET_GUI.get(), LunaRocketGUIScreen::new);
		});
	}
}
