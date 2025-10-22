package net.acidpop.escapevelocity.procedures;

import net.acidpop.escapevelocity.D;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class RoomCheckProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        D.execute(world, x, y, z, entity);
    }
}
