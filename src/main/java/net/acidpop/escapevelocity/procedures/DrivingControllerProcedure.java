package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

import net.acidpop.escapevelocity.init.EscapeVelocityModParticleTypes;
import net.acidpop.escapevelocity.entity.RegolithCollectorEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DrivingControllerProcedure {
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
		if (!world.isClientSide()) {
			if (entity.isPassenger()) {
				if ((entity.getVehicle()) instanceof RegolithCollectorEntity) {
					(entity.getVehicle()).setDeltaMovement(new Vec3((Math.sin((entity.getVehicle()).getYRot() * (Math.PI / 180)) * (-1) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration")),
							((entity.getVehicle()).getDeltaMovement().y() - 0.5), (Math.cos((entity.getVehicle()).getYRot() * (Math.PI / 180)) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration"))));
					if (new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyUp.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyUp.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue()) {
						(entity.getVehicle()).getPersistentData().putDouble("acceleration", (Math.min(1, Math.max((entity.getVehicle()).getPersistentData().getDouble("acceleration") + 0.1, -1))));
					}
					if (new Object() {
						public boolean getValue() {
							boolean retBool = Minecraft.getInstance().options.keyDown.isDown();
							if (retBool) {
								if (Minecraft.getInstance().options.keyDown.getKeyModifier().toString().equals("SHIFT")) {
									retBool = Screen.hasShiftDown();
								} else if (Minecraft.getInstance().options.keyDown.getKeyModifier().toString().equals("CONTROL")) {
									retBool = Screen.hasControlDown();
								} else if (Minecraft.getInstance().options.keyDown.getKeyModifier().toString().equals("ALT")) {
									retBool = Screen.hasAltDown();
								}
							}
							return retBool;
						}
					}.getValue()) {
						(entity.getVehicle()).getPersistentData().putDouble("acceleration", (Math.min(1, Math.max((entity.getVehicle()).getPersistentData().getDouble("acceleration") - 0.1, -1))));
					}
					if ((entity.getVehicle()).getPersistentData().getDouble("acceleration") != 0) {
						if (world.getBlockFloorHeight(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ())) > 0) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (EscapeVelocityModParticleTypes.REGOLITH_COLLECTOR_TRAIL.get()),
										(Math.sin((entity.getVehicle()).getYRot() * (Math.PI / 180)) * (-1) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration") * (-10) + (entity.getVehicle()).getX()),
										((entity.getVehicle()).getY()), (Math.cos((entity.getVehicle()).getYRot() * (Math.PI / 180)) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration") * (-10) + (entity.getVehicle()).getZ()),
										5, 0.5, 0, 0.5, 0);
						}
						if (world.getBlockFloorHeight(
								BlockPos.containing(Math.sin((entity.getVehicle()).getYRot() * (Math.PI / 180)) * (-1) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration") * 5 + (entity.getVehicle()).getX(),
										(entity.getVehicle()).getY(), Math.cos((entity.getVehicle()).getYRot() * (Math.PI / 180)) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration") * 5 + (entity.getVehicle()).getZ())) > 0) {
							if (!(world.getBlockFloorHeight(BlockPos.containing(
									Math.sin((entity.getVehicle()).getYRot() * (Math.PI / 180)) * (-1) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration") * 5 + (entity.getVehicle()).getX(), (entity.getVehicle()).getY() + 1,
									Math.cos((entity.getVehicle()).getYRot() * (Math.PI / 180)) * 0.35 * (entity.getVehicle()).getPersistentData().getDouble("acceleration") * 5 + (entity.getVehicle()).getZ())) > 0)) {
								(entity.getVehicle()).setDeltaMovement(new Vec3(((entity.getVehicle()).getDeltaMovement().x()), ((entity.getVehicle()).getDeltaMovement().y() + 1), ((entity.getVehicle()).getDeltaMovement().z())));
							}
						}
						if ((entity.getVehicle()).getPersistentData().getDouble("acceleration") > 0) {
							if (new Object() {
								public boolean getValue() {
									boolean retBool = Minecraft.getInstance().options.keyLeft.isDown();
									if (retBool) {
										if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("SHIFT")) {
											retBool = Screen.hasShiftDown();
										} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("CONTROL")) {
											retBool = Screen.hasControlDown();
										} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("ALT")) {
											retBool = Screen.hasAltDown();
										}
									}
									return retBool;
								}
							}.getValue()) {
								{
									Entity _ent = (entity.getVehicle());
									_ent.setYRot((float) ((entity.getVehicle()).getYRot() - 2));
									_ent.setXRot(0);
									_ent.setYBodyRot(_ent.getYRot());
									_ent.setYHeadRot(_ent.getYRot());
									_ent.yRotO = _ent.getYRot();
									_ent.xRotO = _ent.getXRot();
									if (_ent instanceof LivingEntity _entity) {
										_entity.yBodyRotO = _entity.getYRot();
										_entity.yHeadRotO = _entity.getYRot();
									}
								}
							} else if (new Object() {
								public boolean getValue() {
									boolean retBool = Minecraft.getInstance().options.keyRight.isDown();
									if (retBool) {
										if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("SHIFT")) {
											retBool = Screen.hasShiftDown();
										} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("CONTROL")) {
											retBool = Screen.hasControlDown();
										} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("ALT")) {
											retBool = Screen.hasAltDown();
										}
									}
									return retBool;
								}
							}.getValue()) {
								{
									Entity _ent = (entity.getVehicle());
									_ent.setYRot((float) ((entity.getVehicle()).getYRot() + 2));
									_ent.setXRot(0);
									_ent.setYBodyRot(_ent.getYRot());
									_ent.setYHeadRot(_ent.getYRot());
									_ent.yRotO = _ent.getYRot();
									_ent.xRotO = _ent.getXRot();
									if (_ent instanceof LivingEntity _entity) {
										_entity.yBodyRotO = _entity.getYRot();
										_entity.yHeadRotO = _entity.getYRot();
									}
								}
							}
						}
						if ((entity.getVehicle()).getPersistentData().getDouble("acceleration") < 0) {
							if (new Object() {
								public boolean getValue() {
									boolean retBool = Minecraft.getInstance().options.keyLeft.isDown();
									if (retBool) {
										if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("SHIFT")) {
											retBool = Screen.hasShiftDown();
										} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("CONTROL")) {
											retBool = Screen.hasControlDown();
										} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("ALT")) {
											retBool = Screen.hasAltDown();
										}
									}
									return retBool;
								}
							}.getValue()) {
								{
									Entity _ent = (entity.getVehicle());
									_ent.setYRot((float) ((entity.getVehicle()).getYRot() + 2));
									_ent.setXRot(0);
									_ent.setYBodyRot(_ent.getYRot());
									_ent.setYHeadRot(_ent.getYRot());
									_ent.yRotO = _ent.getYRot();
									_ent.xRotO = _ent.getXRot();
									if (_ent instanceof LivingEntity _entity) {
										_entity.yBodyRotO = _entity.getYRot();
										_entity.yHeadRotO = _entity.getYRot();
									}
								}
							} else if (new Object() {
								public boolean getValue() {
									boolean retBool = Minecraft.getInstance().options.keyRight.isDown();
									if (retBool) {
										if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("SHIFT")) {
											retBool = Screen.hasShiftDown();
										} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("CONTROL")) {
											retBool = Screen.hasControlDown();
										} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("ALT")) {
											retBool = Screen.hasAltDown();
										}
									}
									return retBool;
								}
							}.getValue()) {
								{
									Entity _ent = (entity.getVehicle());
									_ent.setYRot((float) ((entity.getVehicle()).getYRot() - 2));
									_ent.setXRot(0);
									_ent.setYBodyRot(_ent.getYRot());
									_ent.setYHeadRot(_ent.getYRot());
									_ent.yRotO = _ent.getYRot();
									_ent.xRotO = _ent.getXRot();
									if (_ent instanceof LivingEntity _entity) {
										_entity.yBodyRotO = _entity.getYRot();
										_entity.yHeadRotO = _entity.getYRot();
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
