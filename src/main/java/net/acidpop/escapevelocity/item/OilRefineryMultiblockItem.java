
package net.acidpop.escapevelocity.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.acidpop.escapevelocity.procedures.ItemInInventoryTickProcedure;

public class OilRefineryMultiblockItem extends Item {
	public OilRefineryMultiblockItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ItemInInventoryTickProcedure.execute(entity, itemstack);
	}
}
