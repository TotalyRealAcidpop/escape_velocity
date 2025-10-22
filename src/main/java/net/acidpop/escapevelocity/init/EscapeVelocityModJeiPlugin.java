
package net.acidpop.escapevelocity.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.acidpop.escapevelocity.jei_recipes.MultiblockRecipeCategory;
import net.acidpop.escapevelocity.jei_recipes.MultiblockRecipe;
import net.acidpop.escapevelocity.jei_recipes.ElectrolyzerRecipeTypeRecipeCategory;
import net.acidpop.escapevelocity.jei_recipes.ElectrolyzerRecipeTypeRecipe;
import net.acidpop.escapevelocity.jei_recipes.ElectrolyzerRecipeType2RecipeCategory;
import net.acidpop.escapevelocity.jei_recipes.ElectrolyzerRecipeType2Recipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class EscapeVelocityModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<MultiblockRecipe> Multiblock_Type = new mezz.jei.api.recipe.RecipeType<>(MultiblockRecipeCategory.UID, MultiblockRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<ElectrolyzerRecipeTypeRecipe> ElectrolyzerRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(ElectrolyzerRecipeTypeRecipeCategory.UID, ElectrolyzerRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<ElectrolyzerRecipeType2Recipe> ElectrolyzerRecipeType2_Type = new mezz.jei.api.recipe.RecipeType<>(ElectrolyzerRecipeType2RecipeCategory.UID, ElectrolyzerRecipeType2Recipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("escape_velocity:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new MultiblockRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ElectrolyzerRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ElectrolyzerRecipeType2RecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<MultiblockRecipe> MultiblockRecipes = recipeManager.getAllRecipesFor(MultiblockRecipe.Type.INSTANCE);
		registration.addRecipes(Multiblock_Type, MultiblockRecipes);
		List<ElectrolyzerRecipeTypeRecipe> ElectrolyzerRecipeTypeRecipes = recipeManager.getAllRecipesFor(ElectrolyzerRecipeTypeRecipe.Type.INSTANCE);
		registration.addRecipes(ElectrolyzerRecipeType_Type, ElectrolyzerRecipeTypeRecipes);
		List<ElectrolyzerRecipeType2Recipe> ElectrolyzerRecipeType2Recipes = recipeManager.getAllRecipesFor(ElectrolyzerRecipeType2Recipe.Type.INSTANCE);
		registration.addRecipes(ElectrolyzerRecipeType2_Type, ElectrolyzerRecipeType2Recipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
	}
}
