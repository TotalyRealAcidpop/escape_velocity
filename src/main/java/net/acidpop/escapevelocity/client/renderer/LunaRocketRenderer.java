
package net.acidpop.escapevelocity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.acidpop.escapevelocity.entity.LunaRocketEntity;
import net.acidpop.escapevelocity.client.model.animations.luna_rocketAnimation;
import net.acidpop.escapevelocity.client.model.Modelluna_rocket;

public class LunaRocketRenderer extends MobRenderer<LunaRocketEntity, Modelluna_rocket<LunaRocketEntity>> {
	public LunaRocketRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelluna_rocket.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(LunaRocketEntity entity) {
		return new ResourceLocation("escape_velocity:textures/entities/luna_rocket.png");
	}

	private static final class AnimatedModel extends Modelluna_rocket<LunaRocketEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<LunaRocketEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(LunaRocketEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, luna_rocketAnimation.drop_strap_on_boosters, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(LunaRocketEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
