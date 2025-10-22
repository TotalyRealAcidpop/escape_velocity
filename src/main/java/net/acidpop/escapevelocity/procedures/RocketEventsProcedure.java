package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.util.ITeleporter;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

import net.acidpop.escapevelocity.init.EscapeVelocityModMobEffects;
import net.acidpop.escapevelocity.init.EscapeVelocityModItems;
import net.acidpop.escapevelocity.entity.LunarLanderEntity;
import net.acidpop.escapevelocity.entity.LunaRocketEntity;
import net.acidpop.escapevelocity.EscapeVelocityMod;

import javax.annotation.Nullable;

import java.util.function.Function;

@Mod.EventBusSubscriber
public class RocketEventsProcedure {
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
		double x = 0;
		double z = 0;
		if (entity.isPassenger()) {
			if ((entity.getVehicle()) instanceof LunaRocketEntity) {
				if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD
						|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
								new ResourceLocation("escape_velocity:moon"))) {
					if (new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyJump.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue()) {
						(entity.getVehicle()).getPersistentData().putBoolean("takeoff", true);
					}
				}
				if ((entity.getVehicle()).getPersistentData().getBoolean("takeoff") == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(EscapeVelocityModMobEffects.TURBULENCE.get(), 10, 20, false, false));
					if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1200, 20, false, false));
					if (entity.getY() >= 600) {
						(entity.getVehicle()).getPersistentData().putBoolean("takeoff", false);
						EscapeVelocityMod.queueServerWork(10, () -> {
							if (!(entity.getVehicle()).level().isClientSide())
								(entity.getVehicle()).discard();
							if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
								if (world instanceof ServerLevel _currentLevel) {
									Entity _entity = entity;
									ServerLevel _nextLevel = _currentLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("escape_velocity:moon")));
									if (_entity.canChangeDimensions() && _nextLevel != null && !_nextLevel.dimension().equals(_currentLevel.dimension())) {
										ITeleporter _iTeleporter = new ITeleporter() {
											@Override
											public Entity placeEntity(Entity currentEntity, ServerLevel currentLevel, ServerLevel nextLevel, float rotation, Function<Boolean, Entity> function) {
												if (currentEntity instanceof ServerPlayer serverPlayer) {
													serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0.0F));
													serverPlayer.teleportTo(nextLevel, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
													this.execute(nextLevel, serverPlayer);
													serverPlayer.connection.send(new ClientboundPlayerAbilitiesPacket(serverPlayer.getAbilities()));
													for (MobEffectInstance mobEffectInstance : serverPlayer.getActiveEffects())
														serverPlayer.connection.send(new ClientboundUpdateMobEffectPacket(serverPlayer.getId(), mobEffectInstance));
													serverPlayer.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
													return serverPlayer;
												} else {
													Entity nextEntity = currentEntity.getType().create(nextLevel);
													if (nextEntity == null) {
														return currentEntity;
													} else {
														nextEntity.restoreFrom(currentEntity);
														nextEntity.moveTo(currentEntity.getX(), currentEntity.getY(), currentEntity.getZ(), currentEntity.getYRot(), currentEntity.getXRot());
														this.execute(nextLevel, nextEntity);
														nextLevel.addDuringTeleport(nextEntity);
														return nextEntity;
													}
												}
											}

											@Override
											public boolean isVanilla() {
												return false;
											}

											public void execute(LevelAccessor world, Entity entityinstance) {
												{
													Entity _ent = entityinstance;
													_ent.teleportTo((entity.getX()), 600, (entity.getZ()));
													if (_ent instanceof ServerPlayer _serverPlayer)
														_serverPlayer.connection.teleport((entity.getX()), 600, (entity.getZ()), _ent.getYRot(), _ent.getXRot());
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new net.acidpop.escapevelocity.entity.LunarLanderEntity(net.acidpop.escapevelocity.init.EscapeVelocityModEntities.LUNAR_LANDER.get(), _level);
													entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													_level.addFreshEntity(entityToSpawn);
													// Make player immediately ride the lander
													entity.startRiding(entityToSpawn);
												}
											}
										};
										if (_entity instanceof ServerPlayer _serverPlayer) {
											_iTeleporter.placeEntity(_serverPlayer, _currentLevel, _nextLevel, 0.0F, null);
										} else {
											_entity.changeDimension(_nextLevel, _iTeleporter);
										}
									}
								}
							}
							if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
									new ResourceLocation("escape_velocity:moon"))) {
								if (world instanceof ServerLevel _currentLevel) {
									Entity _entity = entity;
									ServerLevel _nextLevel = _currentLevel.getServer().getLevel(Level.OVERWORLD);
									if (_entity.canChangeDimensions() && _nextLevel != null && !_nextLevel.dimension().equals(_currentLevel.dimension())) {
										ITeleporter _iTeleporter = new ITeleporter() {
											@Override
											public Entity placeEntity(Entity currentEntity, ServerLevel currentLevel, ServerLevel nextLevel, float rotation, Function<Boolean, Entity> function) {
												if (currentEntity instanceof ServerPlayer serverPlayer) {
													serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0.0F));
													serverPlayer.teleportTo(nextLevel, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
													this.execute(nextLevel, serverPlayer);
													serverPlayer.connection.send(new ClientboundPlayerAbilitiesPacket(serverPlayer.getAbilities()));
													for (MobEffectInstance mobEffectInstance : serverPlayer.getActiveEffects())
														serverPlayer.connection.send(new ClientboundUpdateMobEffectPacket(serverPlayer.getId(), mobEffectInstance));
													serverPlayer.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
													return serverPlayer;
												} else {
													Entity nextEntity = currentEntity.getType().create(nextLevel);
													if (nextEntity == null) {
														return currentEntity;
													} else {
														nextEntity.restoreFrom(currentEntity);
														nextEntity.moveTo(currentEntity.getX(), currentEntity.getY(), currentEntity.getZ(), currentEntity.getYRot(), currentEntity.getXRot());
														this.execute(nextLevel, nextEntity);
														nextLevel.addDuringTeleport(nextEntity);
														return nextEntity;
													}
												}
											}

											@Override
											public boolean isVanilla() {
												return false;
											}

											public void execute(LevelAccessor world, Entity entityinstance) {
												{
													Entity _ent = entityinstance;
													_ent.teleportTo((entity.getX()), 300, (entity.getZ()));
													if (_ent instanceof ServerPlayer _serverPlayer)
														_serverPlayer.connection.teleport((entity.getX()), 300, (entity.getZ()), _ent.getYRot(), _ent.getXRot());
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new net.acidpop.escapevelocity.entity.LunaRocketEntity(net.acidpop.escapevelocity.init.EscapeVelocityModEntities.LUNA_ROCKET.get(), _level);
													entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													_level.addFreshEntity(entityToSpawn);
													// Make player immediately ride the lander
													entity.startRiding(entityToSpawn);
												}
											}
										};
										if (_entity instanceof ServerPlayer _serverPlayer) {
											_iTeleporter.placeEntity(_serverPlayer, _currentLevel, _nextLevel, 0.0F, null);
										} else {
											_entity.changeDimension(_nextLevel, _iTeleporter);
										}
									}
								}
							}
						});
					}
				}
			}
			if ((entity.getVehicle()) instanceof LunarLanderEntity) {
				if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("escape_velocity:moon"))) {
					if (!new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyJump.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue() && new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keySprint.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue() || new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyJump.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue() && !new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keySprint.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue()) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Press Sprint + Jump to liftoff"), true);
					} else if (new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyJump.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyJump.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue() && new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keySprint.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keySprint.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue()) {
						(entity.getVehicle()).getPersistentData().putBoolean("takeoff", true);
					}
				}
				if ((entity.getVehicle()).getPersistentData().getBoolean("takeoff") == true) {
					if ((entity.getVehicle()) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1200, 20, false, false));
					if (entity.getY() >= 300) {
						(entity.getVehicle()).getPersistentData().putBoolean("takeoff", false);
						EscapeVelocityMod.queueServerWork(10, () -> {
							if (!(entity.getVehicle()).level().isClientSide())
								(entity.getVehicle()).discard();
							if (world instanceof ServerLevel _currentLevel) {
								Entity _entity = entity;
								ServerLevel _nextLevel = _currentLevel.getServer().getLevel(Level.OVERWORLD);
								if (_entity.canChangeDimensions() && _nextLevel != null && !_nextLevel.dimension().equals(_currentLevel.dimension())) {
									ITeleporter _iTeleporter = new ITeleporter() {
										@Override
										public Entity placeEntity(Entity currentEntity, ServerLevel currentLevel, ServerLevel nextLevel, float rotation, Function<Boolean, Entity> function) {
											if (currentEntity instanceof ServerPlayer serverPlayer) {
												serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0.0F));
												serverPlayer.teleportTo(nextLevel, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
												this.execute(nextLevel, serverPlayer);
												serverPlayer.connection.send(new ClientboundPlayerAbilitiesPacket(serverPlayer.getAbilities()));
												for (MobEffectInstance mobEffectInstance : serverPlayer.getActiveEffects())
													serverPlayer.connection.send(new ClientboundUpdateMobEffectPacket(serverPlayer.getId(), mobEffectInstance));
												serverPlayer.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
												return serverPlayer;
											} else {
												Entity nextEntity = currentEntity.getType().create(nextLevel);
												if (nextEntity == null) {
													return currentEntity;
												} else {
													nextEntity.restoreFrom(currentEntity);
													nextEntity.moveTo(currentEntity.getX(), currentEntity.getY(), currentEntity.getZ(), currentEntity.getYRot(), currentEntity.getXRot());
													this.execute(nextLevel, nextEntity);
													nextLevel.addDuringTeleport(nextEntity);
													return nextEntity;
												}
											}
										}

										@Override
										public boolean isVanilla() {
											return false;
										}

										public void execute(LevelAccessor world, Entity entityinstance) {
											{
												Entity _ent = entityinstance;
												_ent.teleportTo((entity.getX()), 1000, (entity.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entity.getX()), 1000, (entity.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = new net.acidpop.escapevelocity.entity.LunarLanderEntity(net.acidpop.escapevelocity.init.EscapeVelocityModEntities.LUNAR_LANDER.get(), _level);
												entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
												if (entityToSpawn instanceof Mob _mobToSpawn)
													_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
												_level.addFreshEntity(entityToSpawn);
												// Make player immediately ride the lander
												entity.startRiding(entityToSpawn);
											}
										}
									};
									if (_entity instanceof ServerPlayer _serverPlayer) {
										_iTeleporter.placeEntity(_serverPlayer, _currentLevel, _nextLevel, 0.0F, null);
									} else {
										_entity.changeDimension(_nextLevel, _iTeleporter);
									}
								}
							}
						});
					}
				}
				if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
					if (new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyShift.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyShift.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyShift.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyShift.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue()) {
						if (!(entity.getVehicle()).level().isClientSide())
							(entity.getVehicle()).discard();
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(EscapeVelocityModItems.LUNAR_COCKPIT.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(EscapeVelocityModItems.LUNAR_BOOSTER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(EscapeVelocityModItems.LUNAR_STRAP_ON_BOOSTER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(EscapeVelocityModItems.LUNAR_STRAP_ON_BOOSTER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
