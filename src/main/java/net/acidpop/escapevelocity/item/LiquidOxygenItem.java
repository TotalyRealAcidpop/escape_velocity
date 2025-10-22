
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;

public class LiquidOxygenItem extends BucketItem {
	public LiquidOxygenItem() {
		super(EscapeVelocityModFluids.LIQUID_OXYGEN, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
