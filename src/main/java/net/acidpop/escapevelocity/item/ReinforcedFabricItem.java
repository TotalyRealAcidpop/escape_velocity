
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ReinforcedFabricItem extends Item {
	public ReinforcedFabricItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
