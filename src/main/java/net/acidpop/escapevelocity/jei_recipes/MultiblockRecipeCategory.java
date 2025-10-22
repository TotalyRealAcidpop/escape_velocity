
package net.acidpop.escapevelocity.jei_recipes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.acidpop.escapevelocity.init.EscapeVelocityModJeiPlugin;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class MultiblockRecipeCategory implements IRecipeCategory<MultiblockRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("escape_velocity", "multiblock");
	public final static ResourceLocation TEXTURE = new ResourceLocation("escape_velocity", "textures/screens/multiblock_ui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public MultiblockRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 256, 123);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.BRICKS.asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<MultiblockRecipe> getRecipeType() {
		return EscapeVelocityModJeiPlugin.Multiblock_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Multiblock");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MultiblockRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 195, 130).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 65, 130).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 8).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 26).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 44).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 62).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 80).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 98).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 0, 1000).addItemStack(recipe.getResultItem(null));
	}
}
