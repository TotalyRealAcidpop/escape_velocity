package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.acidpop.escapevelocity.init.EscapeVelocityModMobEffects;
import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;
import net.acidpop.escapevelocity.entity.RegolithCollectorEntity;
import net.acidpop.escapevelocity.entity.LunarLanderEntity;
import net.acidpop.escapevelocity.entity.LunaRocketEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityEffectsProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EscapeVelocityModBlocks.LIQUID_OXYGEN.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if (entity.isAlive()) {
				if (entity instanceof LunaRocketEntity || entity instanceof LunarLanderEntity) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(EscapeVelocityModMobEffects.FREEZING.get(), 5, 0, false, false));
				}
			}
		}
		if (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("escape_velocity:moon")) == (entity.level().dimension())) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 0, false, false));
			if (!(entity instanceof LivingEntity _livEnt12 && _livEnt12.getMobType() == MobType.UNDEAD)) {
				if (!(entity instanceof LunaRocketEntity || entity instanceof RegolithCollectorEntity || entity instanceof LunarLanderEntity)) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity) || new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entity))) {
						if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(EscapeVelocityModMobEffects.PRESSURISED.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(EscapeVelocityModMobEffects.RADIATION.get(), 400, 0, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(EscapeVelocityModMobEffects.FREEZING.get(), 5, 0, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(EscapeVelocityModMobEffects.SUFFOCATION.get(), 5, 0, false, false));
						}
					}
				}
			}
		}
		if (entity.isPassenger()) {
			if ((entity.getVehicle()) instanceof LunarLanderEntity || (entity.getVehicle()) instanceof LunaRocketEntity) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(EscapeVelocityModMobEffects.PRESSURISED.get(), 5, 0, false, false));
			}
		}
	}
}
