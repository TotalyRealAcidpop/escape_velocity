
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

public abstract class LiquidOxygenFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> EscapeVelocityModFluidTypes.LIQUID_OXYGEN_TYPE.get(), () -> EscapeVelocityModFluids.LIQUID_OXYGEN.get(),
			() -> EscapeVelocityModFluids.FLOWING_LIQUID_OXYGEN.get()).explosionResistance(100f).bucket(() -> EscapeVelocityModItems.LIQUID_OXYGEN_BUCKET.get()).block(() -> (LiquidBlock) EscapeVelocityModBlocks.LIQUID_OXYGEN.get());

	private LiquidOxygenFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LiquidOxygenFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidOxygenFluid {
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
