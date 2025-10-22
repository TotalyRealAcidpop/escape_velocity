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

import net.acidpop.escapevelocity.world.inventory.ElectrolyzerTopUIMenu;
import net.acidpop.escapevelocity.world.inventory.ElectrolyzerRightUIMenu;
import net.acidpop.escapevelocity.world.inventory.ElectrolyzerLeftUIMenu;

import io.netty.buffer.Unpooled;

public class FluidTankOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 2
				|| (blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 3) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ElectrolyzerTopUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ElectrolyzerTopUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip6 ? blockstate.getValue(_getip6) : -1) == 1) {
			if (((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip8
					? (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getValue(_getip8)
					: -1) == 2
					|| ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip10
							? (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getValue(_getip10)
							: -1) == 3) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ElectrolyzerLeftUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ElectrolyzerLeftUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip13
					? (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getValue(_getip13)
					: -1) == 2
					|| ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip15
							? (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getValue(_getip15)
							: -1) == 3) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ElectrolyzerRightUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ElectrolyzerRightUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
