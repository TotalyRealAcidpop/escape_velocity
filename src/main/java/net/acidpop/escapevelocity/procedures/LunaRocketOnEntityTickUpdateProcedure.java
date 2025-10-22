package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.acidpop.escapevelocity.init.EscapeVelocityModItems;

import java.util.concurrent.atomic.AtomicReference;

public class LunaRocketOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(0, entity)).getItem() == EscapeVelocityModItems.KEROSENE_BUCKET.get()) {
			if (entity.getPersistentData().getDouble("kerosene") < 20000) {
				entity.getPersistentData().putDouble("kerosene", (entity.getPersistentData().getDouble("kerosene") + 1000));
				{
					final int _slotid = 0;
					final ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
					_setstack.setCount(1);
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
							_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
					});
				}
				if (entity.getPersistentData().getDouble("kerosene") > 20000) {
					entity.getPersistentData().putDouble("kerosene", 20000);
				}
			}
		}
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack(1, entity)).getItem() == EscapeVelocityModItems.LIQUID_OXYGEN_BUCKET.get()) {
			if (entity.getPersistentData().getDouble("liquid_oxygen") < 37000) {
				entity.getPersistentData().putDouble("liquid_oxygen", (entity.getPersistentData().getDouble("kerosene") + 1000));
				{
					final int _slotid = 1;
					final ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
					_setstack.setCount(1);
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
							_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
					});
				}
				if (entity.getPersistentData().getDouble("liquid_oxygen") > 37000) {
					entity.getPersistentData().putDouble("liquid_oxygen", 37000);
				}
			}
		}
	}
}
