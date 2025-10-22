package net.acidpop.escapevelocity.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.acidpop.escapevelocity.entity.LunaRocketEntity;

import java.util.Comparator;

public class GetRocketKeroseneLevelProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return Math.round(((Entity) world.getEntitiesOfClass(LunaRocketEntity.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPersistentData().getDouble("kerosene")) + "/" + 20000;
	}
}
