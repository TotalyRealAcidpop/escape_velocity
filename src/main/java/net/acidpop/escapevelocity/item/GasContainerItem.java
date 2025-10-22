
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GasContainerItem extends Item {
	public GasContainerItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
