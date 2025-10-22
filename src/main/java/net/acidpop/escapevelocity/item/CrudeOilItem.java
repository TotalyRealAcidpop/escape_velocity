
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;

public class CrudeOilItem extends BucketItem {
	public CrudeOilItem() {
		super(EscapeVelocityModFluids.CRUDE_OIL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
