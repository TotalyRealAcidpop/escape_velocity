package net.acidpop.escapevelocity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.acidpop.escapevelocity.world.inventory.LunaRocketGUIMenu;
import net.acidpop.escapevelocity.procedures.GetRocketLOXLevelProcedure;
import net.acidpop.escapevelocity.procedures.GetRocketKeroseneLevelProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LunaRocketGUIScreen extends AbstractContainerScreen<LunaRocketGUIMenu> {
	private final static HashMap<String, Object> guistate = LunaRocketGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LunaRocketGUIScreen(LunaRocketGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 262;
	}

	private static final ResourceLocation texture = new ResourceLocation("escape_velocity:textures/screens/luna_rocket_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 17 && mouseX < leftPos + 41 && mouseY > topPos + 129 && mouseY < topPos + 153)
			guiGraphics.renderTooltip(font, Component.literal(GetRocketKeroseneLevelProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 17 && mouseX < leftPos + 41 && mouseY > topPos + 107 && mouseY < topPos + 131)
			guiGraphics.renderTooltip(font, Component.literal(GetRocketKeroseneLevelProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 17 && mouseX < leftPos + 41 && mouseY > topPos + 85 && mouseY < topPos + 109)
			guiGraphics.renderTooltip(font, Component.literal(GetRocketKeroseneLevelProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 107 && mouseY < topPos + 131)
			guiGraphics.renderTooltip(font, Component.literal(GetRocketLOXLevelProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 129 && mouseY < topPos + 153)
			guiGraphics.renderTooltip(font, Component.literal(GetRocketLOXLevelProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 134 && mouseX < leftPos + 158 && mouseY > topPos + 85 && mouseY < topPos + 109)
			guiGraphics.renderTooltip(font, Component.literal(GetRocketLOXLevelProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/rocket_ui.png"), this.leftPos + 58, this.topPos + 20, 0, 0, 61, 150, 61, 150);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_tank_overlay3.png"), this.leftPos + 10, this.topPos + 80, 0, 0, 38, 78, 38, 78);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_tank_overlay3.png"), this.leftPos + 127, this.topPos + 80, 0, 0, 38, 78, 38, 78);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 21, this.topPos + 48, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 138, this.topPos + 48, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.luna_rocket_gui.label_lunar_rocket"), 57, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.luna_rocket_gui.label_kerosene"), 7, 19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.luna_rocket_gui.label_liquid_oxygen"), 133, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.luna_rocket_gui.label_oxygen"), 131, 22, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
