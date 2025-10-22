
package net.acidpop.escapevelocity.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.acidpop.escapevelocity.procedures.SuffocationOnEffectActiveTickProcedure;

public class SuffocationMobEffect extends MobEffect {
	public SuffocationMobEffect() {
		super(MobEffectCategory.HARMFUL, -3342337);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SuffocationOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
