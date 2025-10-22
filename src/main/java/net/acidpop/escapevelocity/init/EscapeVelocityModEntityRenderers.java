
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.acidpop.escapevelocity.client.renderer.RegolithCollectorRenderer;
import net.acidpop.escapevelocity.client.renderer.LunarLanderRenderer;
import net.acidpop.escapevelocity.client.renderer.LunaRocketRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EscapeVelocityModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EscapeVelocityModEntities.REGOLITH_COLLECTOR.get(), RegolithCollectorRenderer::new);
		event.registerEntityRenderer(EscapeVelocityModEntities.LUNA_ROCKET.get(), LunaRocketRenderer::new);
		event.registerEntityRenderer(EscapeVelocityModEntities.LUNAR_LANDER.get(), LunarLanderRenderer::new);
	}
}
