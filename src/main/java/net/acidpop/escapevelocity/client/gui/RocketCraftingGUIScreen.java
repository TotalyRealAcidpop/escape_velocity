package net.acidpop.escapevelocity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.acidpop.escapevelocity.world.inventory.RocketCraftingGUIMenu;
import net.acidpop.escapevelocity.network.RocketCraftingGUIButtonMessage;
import net.acidpop.escapevelocity.EscapeVelocityMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RocketCraftingGUIScreen extends AbstractContainerScreen<RocketCraftingGUIMenu> {
	private final static HashMap<String, Object> guistate = RocketCraftingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_build;

	public RocketCraftingGUIScreen(RocketCraftingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 241;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("escape_velocity:textures/screens/rocket_crafting_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/rocket_ui.png"), this.leftPos + 72, this.topPos + 5, 0, 0, 61, 150, 61, 150);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 149, this.topPos + 27, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 149, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 149, this.topPos + 63, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 149, this.topPos + 81, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 149, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 203, this.topPos + 27, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 203, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 203, this.topPos + 63, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 203, this.topPos + 81, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 203, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.rocket_crafting_gui.label_kerosene"), 136, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.rocket_crafting_gui.label_lox"), 198, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.rocket_crafting_gui.label_oxygen"), 195, 15, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.rocket_crafting_gui.label_rocketbuilder"), 5, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_build = Button.builder(Component.translatable("gui.escape_velocity.rocket_crafting_gui.button_build"), e -> {
			if (true) {
				EscapeVelocityMod.PACKET_HANDLER.sendToServer(new RocketCraftingGUIButtonMessage(0, x, y, z));
				RocketCraftingGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 10, this.topPos + 91, 51, 20).build();
		guistate.put("button:button_build", button_build);
		this.addRenderableWidget(button_build);
	}
}
