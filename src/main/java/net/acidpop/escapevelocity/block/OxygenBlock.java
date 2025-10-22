
package net.acidpop.escapevelocity.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.acidpop.escapevelocity.procedures.GasAddedProcedure;
import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;

public class OxygenBlock extends LiquidBlock {
	public OxygenBlock() {
		super(() -> EscapeVelocityModFluids.OXYGEN.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		GasAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
