package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.acidpop.escapevelocity.jei_recipes.MultiblockRecipe;
import net.acidpop.escapevelocity.jei_recipes.ElectrolyzerRecipeTypeRecipe;
import net.acidpop.escapevelocity.jei_recipes.ElectrolyzerRecipeType2Recipe;
import net.acidpop.escapevelocity.EscapeVelocityMod;

@Mod.EventBusSubscriber(modid = EscapeVelocityMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EscapeVelocityModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "escape_velocity");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("multiblock", () -> MultiblockRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("electrolyzer_recipe_type", () -> ElectrolyzerRecipeTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("electrolyzer_recipe_type_2", () -> ElectrolyzerRecipeType2Recipe.Serializer.INSTANCE);
		});
	}
}
