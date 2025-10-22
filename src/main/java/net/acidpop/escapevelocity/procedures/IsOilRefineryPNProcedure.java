package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;

public class IsOilRefineryPNProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1) == 1) {
			if (EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock()
					&& ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip5
							? (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getValue(_getip5)
							: -1) == 4
					|| EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock()
							&& ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip9
									? (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getValue(_getip9)
									: -1) == 4
					|| EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock()
							&& ((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip13
									? (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getValue(_getip13)
									: -1) == 5
					|| EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock()
							&& ((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip17
									? (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getValue(_getip17)
									: -1) == 5) {
				return true;
			}
		}
		return false;
	}
}
