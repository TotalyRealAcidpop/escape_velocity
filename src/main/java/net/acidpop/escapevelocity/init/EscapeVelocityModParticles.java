
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.acidpop.escapevelocity.client.particle.RegolithCollectorTrailParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EscapeVelocityModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(EscapeVelocityModParticleTypes.REGOLITH_COLLECTOR_TRAIL.get(), RegolithCollectorTrailParticle::provider);
	}
}
