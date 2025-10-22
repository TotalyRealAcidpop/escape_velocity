
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HydrogenContainerItem extends Item {
	public HydrogenContainerItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
