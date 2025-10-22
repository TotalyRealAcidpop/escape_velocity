package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;

public class IsElectrolyzerPNProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1) == 1) {
			if (EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				if (((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip5
						? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip5)
						: -1) == 2
						|| ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip7
								? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip7)
								: -1) == 3) {
					return true;
				}
			}
		}
		return false;
	}
}
