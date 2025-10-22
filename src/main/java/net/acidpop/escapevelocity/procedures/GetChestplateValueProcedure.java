package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.acidpop.escapevelocity.init.EscapeVelocityModItems;

public class GetChestplateValueProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (EscapeVelocityModItems.LUNAR_SUIT_CHESTPLATE.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()) {
			return 34 * ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("oxygen") / 20000);
		}
		return 0;
	}
}
