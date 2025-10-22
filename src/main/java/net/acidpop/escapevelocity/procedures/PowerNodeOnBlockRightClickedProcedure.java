package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.acidpop.escapevelocity.world.inventory.PowerNodeUIMenu;
import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;

import io.netty.buffer.Unpooled;

public class PowerNodeOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 2) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("PowerNodeUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new PowerNodeUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip4 ? blockstate.getValue(_getip4) : -1) == 1) {
			if (EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				if (((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip8
						? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip8)
						: -1) == 2
						|| ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip10
								? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip10)
								: -1) == 3) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("PowerNodeUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new PowerNodeUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
			if (EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock()
					&& ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip15
							? (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getValue(_getip15)
							: -1) == 4
					|| EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock()
							&& ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip19
									? (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getValue(_getip19)
									: -1) == 4
					|| EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock()
							&& ((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip23
									? (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getValue(_getip23)
									: -1) == 5
					|| EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock()
							&& ((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip27
									? (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getValue(_getip27)
									: -1) == 5) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("PowerNodeUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new PowerNodeUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
