package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.entity.Entity;

public class LunaRocketDropBoostersProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() >= 400) {
			return true;
		}
		return false;
	}
}
