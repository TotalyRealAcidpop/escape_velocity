package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.acidpop.escapevelocity.EscapeVelocityMod;

public class MultiblockDetectionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, boolean destroy, String multiblock) {
		if (multiblock == null)
			return;
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		com.google.gson.JsonArray JsonArray = new com.google.gson.JsonArray();
		double Index = 0;
		double RelX = 0;
		double RelY = 0;
		double RelZ = 0;
		double CorrectBlocks = 0;
		double Index2 = 0;
		double Index3 = 0;
		double Index4 = 0;
		JsonObject = new Object() {
			public com.google.gson.JsonObject parse(String rawJson) {
				try {
					return new com.google.gson.Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
				} catch (Exception e) {
					EscapeVelocityMod.LOGGER.error(e);
					return new com.google.gson.Gson().fromJson("{}", com.google.gson.JsonObject.class);
				}
			}
		}.parse(multiblock);
		Index = 0;
		for (int index0 = 0; index0 < (int) JsonObject.size(); index0++) {
			if (CorrectBlocks < JsonObject.size()) {
				JsonArray = JsonObject.get(JsonObject.keySet().stream().toList().get(((int) Index))).getAsJsonArray();
				if ((ForgeRegistries.BLOCKS.getKey(blockstate.getBlock()).toString()).equals(JsonArray.get((int) 0).getAsString())) {
					RelX = JsonArray.get((int) 1).getAsDouble();
					RelY = JsonArray.get((int) 2).getAsDouble();
					RelZ = JsonArray.get((int) 3).getAsDouble();
					Index2 = 0;
					CorrectBlocks = 0;
					for (int index1 = 0; index1 < (int) JsonObject.size(); index1++) {
						JsonArray = JsonObject.get(JsonObject.keySet().stream().toList().get(((int) Index2))).getAsJsonArray();
						Index2 = Index2 + 1;
						if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation((JsonArray.get((int) 0).getAsString()).toLowerCase(java.util.Locale.ENGLISH))) == (world
								.getBlockState(BlockPos.containing(x + JsonArray.get((int) 1).getAsDouble() - RelX, y + JsonArray.get((int) 2).getAsDouble() - RelY, z + JsonArray.get((int) 3).getAsDouble() - RelZ))).getBlock()) {
							CorrectBlocks = CorrectBlocks + 1;
							if (CorrectBlocks == JsonObject.size()) {
								Index3 = 0;
								for (int index2 = 0; index2 < (int) JsonObject.size(); index2++) {
									JsonArray = JsonObject.get(JsonObject.keySet().stream().toList().get(((int) Index3))).getAsJsonArray();
									if (destroy == false) {
										{
											int _value = (int) (int) JsonArray.get((int) 4).getAsDouble();
											BlockPos _pos = BlockPos.containing(x + JsonArray.get((int) 1).getAsDouble() - RelX, y + JsonArray.get((int) 2).getAsDouble() - RelY, z + JsonArray.get((int) 3).getAsDouble() - RelZ);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
									} else {
										{
											int _value = 0;
											BlockPos _pos = BlockPos.containing(x + JsonArray.get((int) 1).getAsDouble() - RelX, y + JsonArray.get((int) 2).getAsDouble() - RelY, z + JsonArray.get((int) 3).getAsDouble() - RelZ);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
									}
									Index3 = Index3 + 1;
								}
							}
						} else {
							break;
						}
					}
				}
				Index = Index + 1;
			} else {
				break;
			}
		}
	}
}
