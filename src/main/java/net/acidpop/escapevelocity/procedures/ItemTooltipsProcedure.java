package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.acidpop.escapevelocity.init.EscapeVelocityModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemTooltipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (EscapeVelocityModItems.LUNAR_SUIT_CHESTPLATE.get() == itemstack.getItem()) {
			tooltip.add(Component.literal(("Oxygen: " + Math.round(itemstack.getOrCreateTag().getDouble("oxygen")) + "/20000")));
		}
		if (EscapeVelocityModItems.OXYGEN_CONTAINER.get() == itemstack.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Hold right click while holding item to increase oxygen"));
				tooltip.add(Component.literal("in space suit chestplate while wearing it"));
			} else {
				tooltip.add(Component.literal("Hold shift for info"));
			}
		}
		if (EscapeVelocityModItems.ENVIRONMENTAL_AUDIO_MODULE.get() == itemstack.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Uses an algorithim to predict what sounds are being made"));
				tooltip.add(Component.literal("allowing you to hear in space"));
			} else {
				tooltip.add(Component.literal("Hold shift for info"));
			}
		}
	}
}
