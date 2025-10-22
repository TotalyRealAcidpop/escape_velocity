package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.entity.Entity;

public class VehicleOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("acceleration") > 0) {
			entity.getPersistentData().putDouble("acceleration", (Math.min(1, Math.max(entity.getPersistentData().getDouble("acceleration") - 0.05, 0))));
		} else if (entity.getPersistentData().getDouble("acceleration") < 0) {
			entity.getPersistentData().putDouble("acceleration", (Math.min(0, Math.max(entity.getPersistentData().getDouble("acceleration") + 0.05, -1))));
		}
	}
}
