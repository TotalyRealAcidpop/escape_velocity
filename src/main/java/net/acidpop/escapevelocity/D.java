package net.acidpop.escapevelocity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class D {

    // Define your custom "sealed" block tag
    private static final TagKey<Block> SEALED_TAG = TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), new ResourceLocation("escape_velocity", "sealed"));

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (world == null) return;

        BlockPos startPos = BlockPos.containing(x, y, z);

        final int MAX_CELLS = 10000;   // safety limit
        final int MAX_DISTANCE = 200;  // cutoff for huge/unsealed spaces

        // --- Check start position ---
        if (isSolidOrSealed(world, startPos)) {
            if (entity != null) {
                entity.sendSystemMessage(Component.literal("Not in a room (blocked or outside)."));
            }
            return;
        }

        // BFS structures
        Deque<BlockPos> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        queue.add(startPos);
        visited.add(startPos.asLong());

        int cells = 0;
        boolean sealed = true;

        // BFS loop
        while (!queue.isEmpty()) {
            BlockPos current = queue.removeFirst();
            cells++;

            if (cells > MAX_CELLS) {
                sealed = false;
                break;
            }

            // Distance check (to avoid exploring infinite terrain)
            if (current.distManhattan(startPos) > MAX_DISTANCE) {
                sealed = false;
                break;
            }

            // Explore neighbors
            for (BlockPos neighbor : new BlockPos[]{
                    current.above(),
                    current.below(),
                    current.north(),
                    current.south(),
                    current.east(),
                    current.west()
            }) {
                long key = neighbor.asLong();
                if (visited.contains(key)) continue;
                visited.add(key);

                if (world.hasChunkAt(neighbor) && !isSolidOrSealed(world, neighbor)) {
                    queue.addLast(neighbor);
                }
            }
        }

        // --- Output results ---
        if (entity != null) {
            entity.sendSystemMessage(Component.literal(
                "Room check results: blocks=" + cells +
                " sealed=" + sealed
            ));
        }
    }

    // Helper method: treat solid blocks and "sealed" tagged blocks as walls
    private static boolean isSolidOrSealed(LevelAccessor world, BlockPos pos) {
        var state = world.getBlockState(pos);
        return state.isRedstoneConductor(world, pos) || state.is(SEALED_TAG);
    }
}
