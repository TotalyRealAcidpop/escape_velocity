package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

import net.acidpop.escapevelocity.init.EscapeVelocityModItems;
import net.acidpop.escapevelocity.entity.RegolithCollectorEntity;
import net.acidpop.escapevelocity.entity.LunarLanderEntity;
import net.acidpop.escapevelocity.entity.LunaRocketEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PickupVehiclesProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
			if (entity instanceof LunaRocketEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EscapeVelocityModItems.LUNAR_ROCKET.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (entity instanceof LunarLanderEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EscapeVelocityModItems.LUNAR_LANDER_ITEM.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (entity instanceof RegolithCollectorEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EscapeVelocityModItems.REGOLITH_COLLECTOR_SPAWN_EGG.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
