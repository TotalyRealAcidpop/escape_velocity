
package net.acidpop.escapevelocity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;

public class NaphthaItem extends BucketItem {
	public NaphthaItem() {
		super(EscapeVelocityModFluids.NAPHTHA, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
