
package net.acidpop.escapevelocity.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.acidpop.escapevelocity.procedures.FreezingOnEffectActiveTickProcedure;

public class FreezingMobEffect extends MobEffect {
	public FreezingMobEffect() {
		super(MobEffectCategory.HARMFUL, -6684673);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FreezingOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
