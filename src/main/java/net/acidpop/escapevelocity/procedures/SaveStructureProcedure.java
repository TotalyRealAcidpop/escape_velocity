package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SaveStructureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		File file = new File("");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		double StartX = 0;
		double StartY = 0;
		double StartZ = 0;
		double CurrentX = 0;
		double CurrentY = 0;
		double CurrentZ = 0;
		double EndX = 0;
		double EndY = 0;
		double EndZ = 0;
		double Index = 0;
		com.google.gson.JsonArray ArrayValues = new com.google.gson.JsonArray();
		Index = 0;
		file = new File((Minecraft.getInstance().gameDirectory.getAbsolutePath() + "config/escapevelocity/multiblock/"), File.separator + (StringArgumentType.getString(arguments, "Name") + ".json"));
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if (new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX() < new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX()) {
			StartX = new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX();
			EndX = new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX();
		} else {
			StartX = new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX();
			EndX = new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX();
		}
		if (new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY() < new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY()) {
			StartY = new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY();
			EndY = new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY();
		} else {
			StartY = new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY();
			EndY = new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY();
		}
		if (new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ() < new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ()) {
			StartZ = new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ();
			EndZ = new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ();
		} else {
			StartZ = new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos2").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ();
			EndZ = new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "Pos1").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ();
		}
		CurrentX = StartX;
		for (int index0 = 0; index0 < (int) (EndX - StartX + 1); index0++) {
			CurrentY = StartY;
			for (int index1 = 0; index1 < (int) (EndY - StartY + 1); index1++) {
				CurrentZ = StartZ;
				for (int index2 = 0; index2 < (int) (EndZ - StartZ + 1); index2++) {
					if (!world.isEmptyBlock(BlockPos.containing(CurrentX, CurrentY, CurrentZ))) {
						ArrayValues.add((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock()).toString()));
						ArrayValues.add((CurrentX - StartX));
						ArrayValues.add((CurrentY - StartY));
						ArrayValues.add((CurrentZ - StartZ));
						ArrayValues.add(((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip31
								? (world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getValue(_getip31)
								: -1));
						JsonObject.add(("" + Index), ArrayValues);
						ArrayValues = new com.google.gson.JsonArray();
						Index = Index + 1;
					}
					CurrentZ = CurrentZ + 1;
				}
				CurrentY = CurrentY + 1;
			}
			CurrentX = CurrentX + 1;
		}
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(mainGSONBuilderVariable.toJson(JsonObject));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
