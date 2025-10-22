
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.acidpop.escapevelocity.client.model.Modelregolith_harvester;
import net.acidpop.escapevelocity.client.model.Modellunar_suit;
import net.acidpop.escapevelocity.client.model.Modellunar_lander;
import net.acidpop.escapevelocity.client.model.Modelluna_rocket;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EscapeVelocityModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modellunar_lander.LAYER_LOCATION, Modellunar_lander::createBodyLayer);
		event.registerLayerDefinition(Modelregolith_harvester.LAYER_LOCATION, Modelregolith_harvester::createBodyLayer);
		event.registerLayerDefinition(Modellunar_suit.LAYER_LOCATION, Modellunar_suit::createBodyLayer);
		event.registerLayerDefinition(Modelluna_rocket.LAYER_LOCATION, Modelluna_rocket::createBodyLayer);
	}
}
