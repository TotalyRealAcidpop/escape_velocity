
package net.acidpop.escapevelocity.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.acidpop.escapevelocity.init.EscapeVelocityModItems;
import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;
import net.acidpop.escapevelocity.init.EscapeVelocityModFluidTypes;
import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;

public abstract class KeroseneFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> EscapeVelocityModFluidTypes.KEROSENE_TYPE.get(), () -> EscapeVelocityModFluids.KEROSENE.get(),
			() -> EscapeVelocityModFluids.FLOWING_KEROSENE.get()).explosionResistance(100f).bucket(() -> EscapeVelocityModItems.KEROSENE_BUCKET.get()).block(() -> (LiquidBlock) EscapeVelocityModBlocks.KEROSENE.get());

	private KeroseneFluid() {
		super(PROPERTIES);
	}

	public static class Source extends KeroseneFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends KeroseneFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
