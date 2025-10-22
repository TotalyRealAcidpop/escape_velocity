
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GlassFiberItem extends Item {
	public GlassFiberItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
