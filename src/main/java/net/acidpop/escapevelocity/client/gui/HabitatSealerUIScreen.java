package net.acidpop.escapevelocity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.acidpop.escapevelocity.world.inventory.HabitatSealerUIMenu;
import net.acidpop.escapevelocity.procedures.WaterSpriteProcedureProcedure;
import net.acidpop.escapevelocity.procedures.FluidValueProcedureProcedure;
import net.acidpop.escapevelocity.procedures.EnergyValueProcedureProcedure;
import net.acidpop.escapevelocity.procedures.EnergySpriteProcedureProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HabitatSealerUIScreen extends AbstractContainerScreen<HabitatSealerUIMenu> {
	private final static HashMap<String, Object> guistate = HabitatSealerUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public HabitatSealerUIScreen(HabitatSealerUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 184;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("escape_velocity:textures/screens/habitat_sealer_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 57 && mouseX < leftPos + 81 && mouseY > topPos + 48 && mouseY < topPos + 72)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 102 && mouseX < leftPos + 126 && mouseY > topPos + 48 && mouseY < topPos + 72)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 79 && mouseX < leftPos + 103 && mouseY > topPos + 48 && mouseY < topPos + 72)
			guiGraphics.renderTooltip(font, Component.literal(FluidValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 55 && mouseY < topPos + 79)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 124 && mouseY < topPos + 148)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 101 && mouseY < topPos + 125)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 78 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 32 && mouseY < topPos + 56)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_tank_overlay.png"), this.leftPos + 53, this.topPos + 42, 0, 0, 78, 38, 78, 38);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/bucket_icon.png"), this.leftPos + 156, this.topPos + 14, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/fluid_water.png"), this.leftPos + 58, this.topPos + 47, Mth.clamp((int) WaterSpriteProcedureProcedure.execute(world, x, y, z) * 68, 0, 1904), 0, 68, 28, 1972, 28);

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/energy_sprite.png"), this.leftPos + 181, this.topPos + 28, Mth.clamp((int) EnergySpriteProcedureProcedure.execute(world, x, y, z) * 32, 0, 480), 0, 32, 125, 512, 125);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.escape_velocity.habitat_sealer_ui.label_water_tank"), 56, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
