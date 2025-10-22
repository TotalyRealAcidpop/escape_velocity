
package net.acidpop.escapevelocity.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;
import net.acidpop.escapevelocity.init.EscapeVelocityModFluidTypes;
import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;

public abstract class HydrogenFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> EscapeVelocityModFluidTypes.HYDROGEN_TYPE.get(), () -> EscapeVelocityModFluids.HYDROGEN.get(),
			() -> EscapeVelocityModFluids.FLOWING_HYDROGEN.get()).explosionResistance(100f).block(() -> (LiquidBlock) EscapeVelocityModBlocks.HYDROGEN.get());

	private HydrogenFluid() {
		super(PROPERTIES);
	}

	public static class Source extends HydrogenFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends HydrogenFluid {
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
