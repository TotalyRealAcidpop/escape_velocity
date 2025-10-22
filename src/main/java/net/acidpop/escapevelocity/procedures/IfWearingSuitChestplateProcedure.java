package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.acidpop.escapevelocity.init.EscapeVelocityModItems;

public class IfWearingSuitChestplateProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (EscapeVelocityModItems.LUNAR_SUIT_CHESTPLATE.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()) {
			return true;
		}
		return false;
	}
}
