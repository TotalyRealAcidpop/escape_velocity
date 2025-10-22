
package net.acidpop.escapevelocity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.acidpop.escapevelocity.entity.LunarLanderEntity;
import net.acidpop.escapevelocity.client.model.animations.lunar_landerAnimation;
import net.acidpop.escapevelocity.client.model.Modellunar_lander;

public class LunarLanderRenderer extends MobRenderer<LunarLanderEntity, Modellunar_lander<LunarLanderEntity>> {
	public LunarLanderRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modellunar_lander.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(LunarLanderEntity entity) {
		return new ResourceLocation("escape_velocity:textures/entities/luna_rocket.png");
	}

	private static final class AnimatedModel extends Modellunar_lander<LunarLanderEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<LunarLanderEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(LunarLanderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, lunar_landerAnimation.landing, ageInTicks, 1f);
				this.animate(entity.animationState1, lunar_landerAnimation.idle, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(LunarLanderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
