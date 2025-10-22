package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.entity.Entity;

public class FreezingOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen((int) (entity.getTicksFrozen() + 4));
	}
}
