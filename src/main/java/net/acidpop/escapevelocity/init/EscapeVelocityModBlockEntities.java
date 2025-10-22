
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.acidpop.escapevelocity.block.entity.SealedCableBlockEntity;
import net.acidpop.escapevelocity.block.entity.RocketBuilderBlockEntity;
import net.acidpop.escapevelocity.block.entity.PowerNodeBlockEntity;
import net.acidpop.escapevelocity.block.entity.HabitatSealerBlockEntity;
import net.acidpop.escapevelocity.block.entity.FluidTankBlockEntity;
import net.acidpop.escapevelocity.block.entity.FluidPipeBlockEntity;
import net.acidpop.escapevelocity.block.entity.CableBlockEntity;
import net.acidpop.escapevelocity.EscapeVelocityMod;

public class EscapeVelocityModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EscapeVelocityMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> HABITAT_SEALER = register("habitat_sealer", EscapeVelocityModBlocks.HABITAT_SEALER, HabitatSealerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FLUID_PIPE = register("fluid_pipe", EscapeVelocityModBlocks.FLUID_PIPE, FluidPipeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE = register("cable", EscapeVelocityModBlocks.CABLE, CableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POWER_NODE = register("power_node", EscapeVelocityModBlocks.POWER_NODE, PowerNodeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FLUID_TANK = register("fluid_tank", EscapeVelocityModBlocks.FLUID_TANK, FluidTankBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ROCKET_BUILDER = register("rocket_builder", EscapeVelocityModBlocks.ROCKET_BUILDER, RocketBuilderBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SEALED_CABLE = register("sealed_cable", EscapeVelocityModBlocks.SEALED_CABLE, SealedCableBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
