package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class WaterSpriteProcedureProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		return Math.round(28 * ((double) (new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, BlockPos.containing(x, y, z), 1)) / (double) (new Object() {
			public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
				return _retval.get();
			}
		}.getFluidTankCapacity(world, BlockPos.containing(x, y, z), 1))));
	}
}
