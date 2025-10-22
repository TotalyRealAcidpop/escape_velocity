package net.acidpop.escapevelocity.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;

import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.FluidStack;
import net.minecraft.world.level.material.Fluids;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * MCreator-friendly procedure for the Habitat Sealer block tick.
 *
 * - Place this file in package net.acidpop.escapevelocity.procedures
 * - Replace any generated no-arg call in HabitatSealerBlock with:
 *     HabitatSealerTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
 *
 * Notes:
 * - The no-arg execute() is only a shim to avoid compile errors; edit the generated block to pass world/pos
 *   so the real logic runs.
 */
public class HabitatSealerTickProcedure {

    // treat blocks with this tag as sealed walls
    private static final net.minecraft.tags.TagKey<Block> SEALED_TAG = net.minecraft.tags.TagKey.create(
            ForgeRegistries.BLOCKS.getRegistryKey(),
            new net.minecraft.resources.ResourceLocation("escape_velocity", "sealed")
    );

    /**
     * No-arg shim (exists only so generated code that calls execute() will compile).
     * This cannot determine world/pos — edit your generated tick call to pass the world and pos so the real logic will run.
     */
    public static void execute() {
        // Helpful console message so you know to replace the generated call.
        System.out.println("[EscapeVelocity] HabitatSealerTickProcedure.execute() called with no arguments. "
                + "Edit HabitatSealerBlock to call execute(world, pos.getX(), pos.getY(), pos.getZ()) instead.");
    }

    /**
     * MCreator-style entrypoint that accepts a dependencies map (some generated procedures call this).
     * Expected keys: "world", "x", "y", "z"
     */
    @SuppressWarnings({"unchecked", "unused"})
    public static void execute(Map<String, Object> dependencies) {
        if (dependencies == null) return;
        Object worldObj = dependencies.get("world");
        Object xObj = dependencies.get("x");
        Object yObj = dependencies.get("y");
        Object zObj = dependencies.get("z");

        if (!(worldObj instanceof LevelAccessor)) return;

        LevelAccessor world = (LevelAccessor) worldObj;

        double x = 0;
        double y = 0;
        double z = 0;

        if (xObj instanceof Integer) x = (double) (int) xObj;
        else if (xObj instanceof Double) x = (Double) xObj;

        if (yObj instanceof Integer) y = (double) (int) yObj;
        else if (yObj instanceof Double) y = (Double) yObj;

        if (zObj instanceof Integer) z = (double) (int) zObj;
        else if (zObj instanceof Double) z = (Double) zObj;

        execute(world, x, y, z);
    }

    /**
     * The actual working entrypoint. Call this from your block tick:
     * HabitatSealerTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
     */
    public static void execute(LevelAccessor worldAccessor, double x, double y, double z) {
        if (worldAccessor == null) return;
        if (!(worldAccessor instanceof ServerLevel level)) return; // server-side only

        BlockPos startPos = BlockPos.containing(x, y, z);

        var be = level.getBlockEntity(startPos);
        if (be == null) return;

        final int REQUIRED_ENERGY = 100; // 100 FE
        // Consume 0.1 bucket per second (20 ticks) ≈ 2 mB per tick
		final double REQUIRED_BUCKETS_PER_SECOND = 0.1;
		final int REQUIRED_MB = (int) Math.round((REQUIRED_BUCKETS_PER_SECOND * 1000.0) / 100.0); // 0.1 * 1000 / 20 = 5 mB


        AtomicBoolean hasEnergy = new AtomicBoolean(false);
        AtomicBoolean hasFluid = new AtomicBoolean(false);

        // check energy
        LazyOptional<IEnergyStorage> energyCap = be.getCapability(ForgeCapabilities.ENERGY);
        energyCap.ifPresent(cap -> {
            try {
                if (cap.getEnergyStored() >= REQUIRED_ENERGY) hasEnergy.set(true);
            } catch (Throwable ignored) { }
        });

        // check fluid (water)
        LazyOptional<IFluidHandler> fluidCap = be.getCapability(ForgeCapabilities.FLUID_HANDLER);
        fluidCap.ifPresent(handler -> {
            try {
                // prefer integer-based simulate drain
                FluidStack sim = handler.drain(REQUIRED_MB, net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.SIMULATE);
                if (!sim.isEmpty() && sim.getAmount() >= REQUIRED_MB && sim.getFluid() == Fluids.WATER) {
                    hasFluid.set(true);
                } else {
                    // fallback: simulate by FluidStack
                    FluidStack sim2 = handler.drain(new FluidStack(Fluids.WATER, REQUIRED_MB), net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.SIMULATE);
                    if (!sim2.isEmpty() && sim2.getAmount() >= REQUIRED_MB) hasFluid.set(true);
                }
            } catch (Throwable ignored) { }
        });

        if (!hasEnergy.get() || !hasFluid.get()) {
            // not enough resources: do nothing
            return;
        }

        // BFS to determine sealed room
        final int MAX_CELLS = 10000;
        final int MAX_DISTANCE = 200;

        Deque<BlockPos> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        queue.add(startPos);
        visited.add(startPos.asLong());

        int cells = 0;
        boolean sealed = true;

        while (!queue.isEmpty()) {
            BlockPos current = queue.removeFirst();
            cells++;

            if (cells > MAX_CELLS) {
                sealed = false;
                break;
            }

            if (current.distManhattan(startPos) > MAX_DISTANCE) {
                sealed = false;
                break;
            }

            BlockPos[] neighbors = new BlockPos[]{
                    current.above(), current.below(), current.north(),
                    current.south(), current.east(), current.west()
            };

            for (BlockPos neighbor : neighbors) {
                long key = neighbor.asLong();
                if (visited.contains(key)) continue;
                visited.add(key);

                if (level.hasChunkAt(neighbor) && !isSolidOrSealed(level, neighbor)) {
                    queue.addLast(neighbor);
                }
            }
        }

        if (!sealed) return; // room not sealed or too big

        // consume energy
        energyCap.ifPresent(cap -> {
            try {
                cap.extractEnergy(REQUIRED_ENERGY, false);
            } catch (Throwable ignored) {}
        });

        // consume fluid (use integer mB value converted from buckets)
        fluidCap.ifPresent(handler -> {
            try {
                handler.drain(REQUIRED_MB, net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE);
            } catch (Throwable t1) {
                try {
                    handler.drain(new FluidStack(Fluids.WATER, REQUIRED_MB), net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE);
                } catch (Throwable ignored) {}
            }
        });

        // bounding box for entity query
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, maxZ = Integer.MIN_VALUE;

        for (long l : visited) {
            BlockPos p = BlockPos.of(l);
            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
            minZ = Math.min(minZ, p.getZ());
            maxX = Math.max(maxX, p.getX());
            maxY = Math.max(maxY, p.getY());
            maxZ = Math.max(maxZ, p.getZ());
        }

        AABB box = new AABB(minX, minY, minZ, maxX + 1.0, maxY + 1.0, maxZ + 1.0);

        for (LivingEntity ent : level.getEntitiesOfClass(LivingEntity.class, box)) {
            BlockPos entPos = ent.blockPosition();
            if (visited.contains(entPos.asLong())) {
                ent.addEffect(new MobEffectInstance(
                        net.acidpop.escapevelocity.init.EscapeVelocityModMobEffects.PRESSURISED.get(),
                        55, // duration in ticks
                        0,  // amplifier
                        false, // ambient
                        false   // showParticles
                ));
            }
        }
    }

    // treat solid blocks and "sealed" tagged blocks as walls
    private static boolean isSolidOrSealed(LevelAccessor world, BlockPos pos) {
        var state = world.getBlockState(pos);
        return state.isRedstoneConductor(world, pos) || state.is(SEALED_TAG);
    }
}
