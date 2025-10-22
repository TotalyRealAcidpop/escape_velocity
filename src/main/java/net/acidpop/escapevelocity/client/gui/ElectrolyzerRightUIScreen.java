package net.acidpop.escapevelocity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.acidpop.escapevelocity.world.inventory.ElectrolyzerRightUIMenu;
import net.acidpop.escapevelocity.procedures.GasSpriteProcedureProcedure;
import net.acidpop.escapevelocity.procedures.FluidValueProcedureProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ElectrolyzerRightUIScreen extends AbstractContainerScreen<ElectrolyzerRightUIMenu> {
	private final static HashMap<String, Object> guistate = ElectrolyzerRightUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ElectrolyzerRightUIScreen(ElectrolyzerRightUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 204;
		this.imageHeight = 212;
	}

	private static final ResourceLocation texture = new ResourceLocation("escape_velocity:textures/screens/electrolyzer_right_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 26 && mouseY < topPos + 50)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 71 && mouseY < topPos + 95)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 49 && mouseY < topPos + 73)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/gas_container_icon.png"), this.leftPos + 181, this.topPos + 22, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/electrolyzer_image.png"), this.leftPos + 4, this.topPos + -4, 0, 0, 130, 124, 130, 124);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_tank_overlay2.png"), this.leftPos + 137, this.topPos + 21, 0, 0, 38, 78, 38, 78);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_oxygen.png"), this.leftPos + 142, this.topPos + 26, Mth.clamp((int) GasSpriteProcedureProcedure.execute(world, x, y, z) * 28, 0, 1904), 0, 28, 68, 1932, 68);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.electrolyzer_right_ui.label_oxygen_tank"), 126, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
