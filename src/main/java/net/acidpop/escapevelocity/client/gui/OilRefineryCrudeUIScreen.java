package net.acidpop.escapevelocity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.acidpop.escapevelocity.world.inventory.OilRefineryCrudeUIMenu;
import net.acidpop.escapevelocity.procedures.WaterSpriteProcedureProcedure;
import net.acidpop.escapevelocity.procedures.FluidValueProcedureProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class OilRefineryCrudeUIScreen extends AbstractContainerScreen<OilRefineryCrudeUIMenu> {
	private final static HashMap<String, Object> guistate = OilRefineryCrudeUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OilRefineryCrudeUIScreen(OilRefineryCrudeUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 184;
		this.imageHeight = 258;
	}

	private static final ResourceLocation texture = new ResourceLocation("escape_velocity:textures/screens/oil_refinery_crude_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 21 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 129 && mouseY > topPos + 21 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 81 && mouseX < leftPos + 105 && mouseY > topPos + 21 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_tank_overlay.png"), this.leftPos + 54, this.topPos + 14, 0, 0, 78, 38, 78, 38);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 156, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/electrolyzer_image.png"), this.leftPos + 27, this.topPos + 44, 0, 0, 130, 124, 130, 124);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_water.png"), this.leftPos + 59, this.topPos + 19, Mth.clamp((int) WaterSpriteProcedureProcedure.execute(world, x, y, z) * 68, 0, 1904), 0, 68, 28, 1972, 28);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.oil_refinery_crude_ui.label_water_tank"), 66, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
