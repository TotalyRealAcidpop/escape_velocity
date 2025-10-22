package net.acidpop.escapevelocity.client.model.animations;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

// Save this class in your mod and generate all required imports
/**
 * Made with Blockbench 5.0.1 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class lunar_landerAnimation {
	public static final AnimationDefinition landing = AnimationDefinition.Builder.withLength(22.0417F)
			.addAnimation("Lander",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(5.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(6.5417F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(7.375F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Booster",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(9.5417F, KeyframeAnimations.degreeVec(0.0F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(16.0417F, KeyframeAnimations.degreeVec(0.0F, -17.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Booster", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(6.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -28.67F), AnimationChannel.Interpolations.LINEAR), new Keyframe(9.5417F, KeyframeAnimations.posVec(0.0F, 105.0F, -172.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(16.0417F, KeyframeAnimations.posVec(0.0F, 420.0F, -325.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(22.0417F, KeyframeAnimations.posVec(0.0F, 674.0F, -325.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Booster", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(15.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(22.0417F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(1.0F).looping()
			.addAnimation("Lander",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Booster", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.0F, KeyframeAnimations.scaleVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
			.build();
}
