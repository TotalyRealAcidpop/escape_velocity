
package net.acidpop.escapevelocity.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.acidpop.escapevelocity.init.EscapeVelocityModJeiPlugin;
import net.acidpop.escapevelocity.init.EscapeVelocityModItems;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class ElectrolyzerRecipeType2RecipeCategory implements IRecipeCategory<ElectrolyzerRecipeType2Recipe> {
	public final static ResourceLocation UID = new ResourceLocation("escape_velocity", "electrolyzer_recipe_type_2");
	public final static ResourceLocation TEXTURE = new ResourceLocation("escape_velocity", "textures/screens/electrolyzer_recipe_type.png");
	private final IDrawable background;
	private final IDrawable icon;

	public ElectrolyzerRecipeType2RecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 129, 74);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(EscapeVelocityModItems.ELECTROLYZER.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<ElectrolyzerRecipeType2Recipe> getRecipeType() {
		return EscapeVelocityModJeiPlugin.ElectrolyzerRecipeType2_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Electrolyzer");
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
	public void setRecipe(IRecipeLayoutBuilder builder, ElectrolyzerRecipeType2Recipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 109, 5).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 14).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 49, 100).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 113, 44).addItemStack(recipe.getResultItem(null));
	}
}
