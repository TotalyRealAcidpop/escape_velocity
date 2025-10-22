package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.acidpop.escapevelocity.init.EscapeVelocityModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HeartProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EscapeVelocityModMobEffects.RADIATION.get())) {
			if (world.isClientSide()) {
				Minecraft.getInstance().getTextureManager().bindForSetup(new ResourceLocation("escape_velocity:textures/screens/radiation_icons.png"));
				Minecraft.getInstance().getTextureManager().register(new ResourceLocation("minecraft:textures/gui/icons.png"),
						Minecraft.getInstance().getTextureManager().getTexture(new ResourceLocation("escape_velocity:textures/screens/radiation_icons.png")));
			}
		} else if (true) {
			if (world.isClientSide()) {
				Minecraft.getInstance().getTextureManager().release(new ResourceLocation("minecraft:textures/gui/icons.png"));
			}
		}
	}
}
