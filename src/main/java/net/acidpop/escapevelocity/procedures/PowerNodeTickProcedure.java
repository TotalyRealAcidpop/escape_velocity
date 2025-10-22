package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.acidpop.escapevelocity.init.EscapeVelocityModFluids;
import net.acidpop.escapevelocity.init.EscapeVelocityModBlocks;

import java.util.concurrent.atomic.AtomicInteger;

public class PowerNodeTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double Connections = 0;
		double North = 0;
		double South = 0;
		double East = 0;
		double West = 0;
		double Down = 0;
		double Up = 0;
		if ((blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 2) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 3, z))) {
				if (world.dayTime() > 0 && world.dayTime() < 12000) {
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = new Object() {
							public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
								AtomicInteger _retval = new AtomicInteger(0);
								BlockEntity _ent = level.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
								return _retval.get();
							}
						}.receiveEnergySimulate(world, BlockPos.containing(x, y, z), 100);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
					if (new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x, y, z), 100) > 0) {
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "sound") == 0) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("escape_velocity:generator")), SoundSource.BLOCKS, (float) 0.5, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("escape_velocity:generator")), SoundSource.BLOCKS, (float) 0.5, 1, false);
								}
							}
						}
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "sound") < 39) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("sound", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "sound") + 1));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("sound", 0);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
				}
			}
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, BlockPos.containing(x, y, z)) > 0) {
				Connections = 0;
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x + 1, y, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x + 1, y, z))) {
					Connections = Connections + 1;
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x - 1, y, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x - 1, y, z))) {
					Connections = Connections + 1;
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y, z + 1)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y, z + 1))) {
					Connections = Connections + 1;
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y, z - 1)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y, z - 1))) {
					Connections = Connections + 1;
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y + 1, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y + 1, z))) {
					Connections = Connections + 1;
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y - 1, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y - 1, z))) {
					Connections = Connections + 1;
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x + 1, y, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x + 1, y, z))) {
					East = new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x + 1, y, z), (int) (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Connections));
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = (int) East;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + 1, y, z));
						int _amount = (int) East;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.WEST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x - 1, y, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x - 1, y, z))) {
					West = new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x - 1, y, z), (int) (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Connections));
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = (int) West;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x - 1, y, z));
						int _amount = (int) West;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.EAST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y, z - 1)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y, z - 1))) {
					North = new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x, y, z - 1), (int) (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Connections));
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = (int) North;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z - 1));
						int _amount = (int) North;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y, z + 1)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y, z + 1))) {
					South = new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x, y, z + 1), (int) (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Connections));
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = (int) South;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z + 1));
						int _amount = (int) South;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y + 1, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y + 1, z))) {
					Up = new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x, y + 1, z), (int) (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Connections));
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = (int) Up;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
						int _amount = (int) Up;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
				if (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, BlockPos.containing(x, y - 1, z)) != new Object() {
					public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, BlockPos.containing(x, y - 1, z))) {
					Down = new Object() {
						public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
							return _retval.get();
						}
					}.receiveEnergySimulate(world, BlockPos.containing(x, y - 1, z), (int) (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) / Connections));
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						int _amount = (int) Down;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
						int _amount = (int) Down;
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, Direction.UP).ifPresent(capability -> capability.receiveEnergy(_amount, false));
					}
				}
			}
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip64 ? blockstate.getValue(_getip64) : -1) == 1) {
			if (EscapeVelocityModBlocks.FLUID_TANK.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				if (new Object() {
					public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
						return _retval.get();
					}
				}.getFluidTankLevel(world, BlockPos.containing(x, y + 1, z), 1) >= 3) {
					if (new Object() {
						public int getEnergyStored(LevelAccessor level, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = level.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 80) {
						if (((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip70
								? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip70)
								: -1) == 2) {
							if (new Object() {
								public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = level.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
									return _retval.get();
								}
							}.getFluidTankLevel(world, BlockPos.containing(x + 1, y, z), 1) <= new Object() {
								public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = level.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
									return _retval.get();
								}
							}.getFluidTankCapacity(world, BlockPos.containing(x + 1, y, z), 1) - 2) {
								if (new Object() {
									public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = level.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
										return _retval.get();
									}
								}.getFluidTankLevel(world, BlockPos.containing(x - 1, y, z), 1) <= new Object() {
									public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = level.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
										return _retval.get();
									}
								}.getFluidTankCapacity(world, BlockPos.containing(x - 1, y, z), 1) - 1) {
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
										int _amount = 3;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
									}
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + 1, y, z));
										int _amount = 2;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> capability.fill(new FluidStack(EscapeVelocityModFluids.HYDROGEN.get(), _amount), IFluidHandler.FluidAction.EXECUTE));
									}
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x - 1, y, z));
										int _amount = 1;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> capability.fill(new FluidStack(EscapeVelocityModFluids.OXYGEN.get(), _amount), IFluidHandler.FluidAction.EXECUTE));
									}
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
										int _amount = 80;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
									}
									if (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "sound") == 0) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("escape_velocity:generator")), SoundSource.BLOCKS, (float) 0.5, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("escape_velocity:generator")), SoundSource.BLOCKS, (float) 0.5, 1, false);
											}
										}
									}
									if (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "sound") < 39) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putDouble("sound", (new Object() {
													public double getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getDouble(tag);
														return -1;
													}
												}.getValue(world, BlockPos.containing(x, y, z), "sound") + 1));
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putDouble("sound", 0);
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									}
								}
							}
						} else if (((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("variant") instanceof IntegerProperty _getip86
								? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip86)
								: -1) == 3) {
							if (new Object() {
								public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = level.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
									return _retval.get();
								}
							}.getFluidTankLevel(world, BlockPos.containing(x, y, z + 1), 1) <= new Object() {
								public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = level.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
									return _retval.get();
								}
							}.getFluidTankCapacity(world, BlockPos.containing(x, y, z + 1), 1) - 2) {
								if (new Object() {
									public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = level.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
										return _retval.get();
									}
								}.getFluidTankLevel(world, BlockPos.containing(x, y, z - 1), 1) <= new Object() {
									public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = level.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
										return _retval.get();
									}
								}.getFluidTankCapacity(world, BlockPos.containing(x, y, z - 1), 1) - 1) {
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
										int _amount = 3;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
									}
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z + 1));
										int _amount = 2;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> capability.fill(new FluidStack(EscapeVelocityModFluids.HYDROGEN.get(), _amount), IFluidHandler.FluidAction.EXECUTE));
									}
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z - 1));
										int _amount = 1;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.FLUID_HANDLER, null).ifPresent(capability -> capability.fill(new FluidStack(EscapeVelocityModFluids.OXYGEN.get(), _amount), IFluidHandler.FluidAction.EXECUTE));
									}
									{
										BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
										int _amount = 80;
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
									}
									if (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "sound") == 0) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("escape_velocity:generator")), SoundSource.BLOCKS, (float) 0.5, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("escape_velocity:generator")), SoundSource.BLOCKS, (float) 0.5, 1, false);
											}
										}
									}
									if (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "sound") < 39) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putDouble("sound", (new Object() {
													public double getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getDouble(tag);
														return -1;
													}
												}.getValue(world, BlockPos.containing(x, y, z), "sound") + 1));
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									} else {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putDouble("sound", 0);
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
