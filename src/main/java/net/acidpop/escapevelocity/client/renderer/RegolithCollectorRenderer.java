
package net.acidpop.escapevelocity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.acidpop.escapevelocity.entity.RegolithCollectorEntity;
import net.acidpop.escapevelocity.client.model.animations.regolith_harvesterAnimation;
import net.acidpop.escapevelocity.client.model.Modelregolith_harvester;

public class RegolithCollectorRenderer extends MobRenderer<RegolithCollectorEntity, Modelregolith_harvester<RegolithCollectorEntity>> {
	public RegolithCollectorRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelregolith_harvester.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RegolithCollectorEntity entity) {
		return new ResourceLocation("escape_velocity:textures/entities/regolith_harvester.png");
	}

	private static final class AnimatedModel extends Modelregolith_harvester<RegolithCollectorEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<RegolithCollectorEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(RegolithCollectorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animateWalk(regolith_harvesterAnimation.forwards, limbSwing, limbSwingAmount, 1f, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(RegolithCollectorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
