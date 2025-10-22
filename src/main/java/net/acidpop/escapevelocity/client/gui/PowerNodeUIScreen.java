package net.acidpop.escapevelocity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.acidpop.escapevelocity.world.inventory.PowerNodeUIMenu;
import net.acidpop.escapevelocity.procedures.IsSolarArrayPNProcedure;
import net.acidpop.escapevelocity.procedures.IsOilRefineryPNProcedure;
import net.acidpop.escapevelocity.procedures.IsElectrolyzerPNProcedure;
import net.acidpop.escapevelocity.procedures.EnergyValueProcedureProcedure;
import net.acidpop.escapevelocity.procedures.EnergySpriteProcedureProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PowerNodeUIScreen extends AbstractContainerScreen<PowerNodeUIMenu> {
	private final static HashMap<String, Object> guistate = PowerNodeUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PowerNodeUIScreen(PowerNodeUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 184;
		this.imageHeight = 242;
	}

	private static final ResourceLocation texture = new ResourceLocation("escape_velocity:textures/screens/power_node_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 19 && mouseY < topPos + 43)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 43 && mouseY < topPos + 67)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 67 && mouseY < topPos + 91)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 91 && mouseY < topPos + 115)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 115 && mouseY < topPos + 139)
			guiGraphics.renderTooltip(font, Component.literal(EnergyValueProcedureProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (IsSolarArrayPNProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/solar_array_image.png"), this.leftPos + 5, this.topPos + 18, 0, 0, 130, 124, 130, 124);
		}
		if (IsElectrolyzerPNProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/electrolyzer_image.png"), this.leftPos + 5, this.topPos + 18, 0, 0, 130, 124, 130, 124);
		}
		if (IsOilRefineryPNProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/oil_refinery_image.png"), this.leftPos + 4, this.topPos + 18, 0, 0, 130, 124, 130, 124);
		}

		guiGraphics.blit(new ResourceLocation("escape_velocity:textures/screens/energy_sprite.png"), this.leftPos + 140, this.topPos + 16, Mth.clamp((int) EnergySpriteProcedureProcedure.execute(world, x, y, z) * 32, 0, 480), 0, 32, 125, 512, 125);

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
	}

	@Override
	public void init() {
		super.init();
	}
}
