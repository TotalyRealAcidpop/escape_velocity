package net.acidpop.escapevelocity.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.0.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelluna_rocket<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("escape_velocity", "modelluna_rocket"), "main");
	public final ModelPart bone;
	public final ModelPart bone13;
	public final ModelPart bone15;
	public final ModelPart bone8;
	public final ModelPart bone9;
	public final ModelPart bone2;
	public final ModelPart bone7;
	public final ModelPart bone5;
	public final ModelPart bone6;
	public final ModelPart bone3;
	public final ModelPart bone4;

	public Modelluna_rocket(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone13 = root.getChild("bone13");
		this.bone15 = root.getChild("bone15");
		this.bone8 = this.bone15.getChild("bone8");
		this.bone9 = this.bone15.getChild("bone9");
		this.bone2 = root.getChild("bone2");
		this.bone7 = root.getChild("bone7");
		this.bone5 = root.getChild("bone5");
		this.bone6 = root.getChild("bone6");
		this.bone3 = root.getChild("bone3");
		this.bone4 = root.getChild("bone4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(150, 325).addBox(-29.0F, -93.0F, -12.0F, 58.0F, 84.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(0, 183).addBox(-12.0F, -93.0F, -29.0F, 24.0F, 84.0F, 58.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(164, 183).addBox(-12.0F, -93.0F, -29.0F, 24.0F, 84.0F, 58.0F, new CubeDeformation(0.0F)).texOffs(314, 325).addBox(-29.0F, -93.0F, -12.0F, 58.0F, 84.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone13 = partdefinition.addOrReplaceChild("bone13",
				CubeListBuilder.create().texOffs(300, 0).addBox(-26.5F, -104.0F, -11.0F, 53.0F, 130.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(150, 0).addBox(-11.0F, -103.97F, -26.5F, 22.0F, 130.0F, 53.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -96.0F, 0.0F));
		PartDefinition cube_r2 = bone13.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -44.48F, -26.5F, 22.0F, 130.0F, 53.0F, new CubeDeformation(0.0F)).texOffs(0, 325).addBox(-26.5F, -44.46F, -11.0F, 53.0F, 130.0F, 22.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -59.5F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone15 = partdefinition.addOrReplaceChild("bone15",
				CubeListBuilder.create().texOffs(478, 368).addBox(-11.0F, -100.01F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(314, 433).addBox(-16.5F, -87.01F, -16.5F, 33.0F, 5.0F, 33.0F, new CubeDeformation(0.0F))
						.texOffs(492, 258).addBox(-4.0F, -90.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(358, 499).addBox(14.0F, -82.0F, 14.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(338, 499)
						.addBox(13.0F, -78.0F, 13.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(338, 499).mirror().addBox(-18.0F, -78.0F, 13.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(358, 499).mirror()
						.addBox(-17.0F, -82.0F, 14.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(338, 499).mirror().addBox(-18.0F, -78.0F, -18.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(358, 499)
						.mirror().addBox(-17.0F, -82.0F, -17.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(358, 499).addBox(14.0F, -82.0F, -17.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(338, 499)
						.addBox(13.0F, -78.0F, -18.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -117.925F, 0.0F));
		PartDefinition cube_r3 = bone15.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(492, 193).addBox(-7.0F, 1.5F, -3.5F, 14.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -101.0F, -14.75F, -1.2217F, 0.0F, 0.0F));
		PartDefinition cube_r4 = bone15.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(300, 163).addBox(-3.985F, -8.0F, -1.0F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.025F, -90.0F, 3.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r5 = bone15.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(478, 368).addBox(-11.0F, -60.51F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r6 = bone15.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(478, 340).addBox(-11.0F, -60.5F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r7 = bone15.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(478, 368).addBox(-11.0F, -60.51F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		PartDefinition cube_r8 = bone15.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(478, 340).addBox(-11.0F, -60.5F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
		PartDefinition cube_r9 = bone15.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(478, 368).addBox(-11.0F, -60.51F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r10 = bone15.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(478, 340).addBox(-11.0F, -60.5F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
		PartDefinition cube_r11 = bone15.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(478, 340).addBox(-11.0F, -60.5F, 16.5F, 22.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -39.5F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone8 = bone15.addOrReplaceChild("bone8",
				CubeListBuilder.create().texOffs(492, 289).addBox(-6.5F, -308.02F, 12.5F, 13.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(492, 204).addBox(-15.5F, -308.02F, -6.5F, 3.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(492, 269)
						.addBox(-6.5F, -308.02F, -15.5F, 13.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(492, 204).addBox(12.5F, -308.02F, -6.5F, 3.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(328, 312)
						.addBox(-13.0F, -307.98F, -5.5F, 26.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(314, 471).addBox(-5.5F, -307.97F, -13.0F, 11.0F, 2.0F, 26.0F, new CubeDeformation(0.0F)).texOffs(492, 178)
						.addBox(-9.0F, -302.98F, 18.5F, 18.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(496, 491).addBox(-6.0F, -303.01F, 13.5F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(496, 491).mirror()
						.addBox(-6.0F, -303.01F, -18.5F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(492, 244).mirror().addBox(-18.5F, -303.01F, -6.0F, 5.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(492, 244).addBox(13.5F, -303.01F, -6.0F, 5.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 191.0F, 0.0F));
		PartDefinition cube_r12 = bone8.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(412, 498).mirror().addBox(15.5F, -253.0F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.5F, -50.0F, 0.0F, 0.0F, 0.4067F, 0.0F));
		PartDefinition cube_r13 = bone8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(412, 498).addBox(15.5F, -253.0F, -3.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -50.0F, 0.0F, 0.0F, -0.4067F, 0.0F));
		PartDefinition cube_r14 = bone8.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(496, 498).mirror().addBox(-22.5F, -253.0F, -2.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -50.0F, 0.0F, 0.0F, -0.4067F, 0.0F));
		PartDefinition cube_r15 = bone8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(496, 498).addBox(-22.5F, -253.0F, -3.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -50.0F, 0.0F, 0.0F, 0.4067F, 0.0F));
		PartDefinition cube_r16 = bone8.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(388, 498).mirror().addBox(-3.0F, -253.0F, -22.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.5F, 0.0F, -0.4067F, 0.0F));
		PartDefinition cube_r17 = bone8.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(388, 498).addBox(-2.0F, -253.0F, -22.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.5F, 0.0F, 0.4067F, 0.0F));
		PartDefinition cube_r18 = bone8.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(388, 498).mirror().addBox(-3.0F, -253.0F, 15.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -50.0F, -0.5F, 0.0F, 0.4067F, 0.0F));
		PartDefinition cube_r19 = bone8.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(388, 498).addBox(-2.0F, -253.0F, 15.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, -0.5F, 0.0F, -0.4067F, 0.0F));
		PartDefinition cube_r20 = bone8.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(326, 499).addBox(-9.0F, -252.99F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(450, 146).addBox(-6.0F, -243.0F, 18.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(314, 499)
						.addBox(6.0F, -252.99F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(300, 152).addBox(-6.0F, -252.5F, 19.5F, 12.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(478, 424)
						.addBox(-6.0F, -252.5F, 12.5F, 12.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r21 = bone8.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(326, 499).addBox(-9.0F, -252.99F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(450, 146)
				.addBox(-6.0F, -243.0F, 18.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(314, 499).addBox(6.0F, -252.99F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
		PartDefinition cube_r22 = bone8.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(326, 499).addBox(-9.0F, -252.99F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(450, 146)
				.addBox(-6.0F, -243.0F, 18.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(314, 499).addBox(6.0F, -252.99F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
		PartDefinition cube_r23 = bone8.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(300, 152).addBox(-6.0F, -252.0F, 19.5F, 12.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(478, 424).addBox(-6.0F, -252.0F, 12.5F, 12.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.5F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
		PartDefinition cube_r24 = bone8.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(300, 152).addBox(-6.0F, -252.0F, 19.5F, 12.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(478, 424).addBox(-6.0F, -252.0F, 12.5F, 12.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.5F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
		PartDefinition cube_r25 = bone8.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(478, 424).addBox(-6.0F, -252.0F, 12.5F, 12.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(300, 152).addBox(-6.0F, -252.0F, 19.5F, 12.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(326, 499)
						.addBox(-9.0F, -252.49F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(450, 146).addBox(-6.0F, -242.5F, 18.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(314, 499)
						.addBox(6.0F, -252.49F, 18.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 477).addBox(-5.5F, -257.5F, -13.0F, 11.0F, 2.0F, 26.0F, new CubeDeformation(0.0F)).texOffs(402, 312)
						.addBox(-13.0F, -257.49F, -5.5F, 26.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(492, 224).addBox(12.5F, -257.51F, -6.5F, 3.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(492, 279)
						.addBox(-6.5F, -257.51F, -15.5F, 13.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(492, 224).addBox(-15.5F, -257.51F, -6.5F, 3.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(492, 299)
						.addBox(-6.5F, -257.51F, 12.5F, 13.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.5F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r26 = bone8.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(492, 178).addBox(-9.0F, -252.98F, 18.5F, 18.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		PartDefinition cube_r27 = bone8.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(492, 178).addBox(-9.0F, -252.98F, 18.5F, 18.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r28 = bone8.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(492, 178).addBox(-9.0F, -252.98F, 18.5F, 18.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition bone9 = bone15.addOrReplaceChild("bone9",
				CubeListBuilder.create().texOffs(478, 396).addBox(-12.0F, 16.52F, -5.0F, 24.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(478, 312).addBox(-5.0F, 16.5F, -12.0F, 10.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -98.5F, 0.0F));
		PartDefinition cube_r29 = bone9.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(74, 477).addBox(-5.0F, 16.53F, -12.0F, 10.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(478, 410).addBox(-12.0F, 16.51F, -5.0F, 24.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(328, 152).mirror().addBox(-14.5F, -154.96F, -6.0F, 29.0F, 148.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(232, 433).mirror()
						.addBox(-6.0F, -154.98F, -14.5F, 12.0F, 148.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(388, 471).mirror().addBox(-4.0F, -163.0F, -9.5F, 8.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(492, 162).mirror().addBox(-9.5F, -163.0F, -4.0F, 19.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(43.0F, 36.0F, 0.0F));
		PartDefinition cube_r30 = bone2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(492, 146).mirror().addBox(-9.5F, 4.5F, -4.0F, 19.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(442, 491).mirror()
				.addBox(-4.0F, 4.5F, -9.5F, 8.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -167.5F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r31 = bone2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(150, 433).mirror().addBox(-6.0F, -155.0F, -14.5F, 12.0F, 148.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(410, 152).mirror()
				.addBox(-14.5F, -155.0F, -6.0F, 29.0F, 148.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(328, 152).addBox(-14.5F, -154.96F, -6.0F, 29.0F, 148.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(232, 433).addBox(-6.0F, -154.98F, -14.5F, 12.0F, 148.0F, 29.0F, new CubeDeformation(0.0F))
						.texOffs(388, 471).addBox(-4.0F, -163.0F, -9.5F, 8.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(492, 162).addBox(-9.5F, -163.0F, -4.0F, 19.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-43.0F, 36.0F, 0.0F));
		PartDefinition cube_r32 = bone7.addOrReplaceChild("cube_r32",
				CubeListBuilder.create().texOffs(492, 146).addBox(-9.5F, 4.5F, -4.0F, 19.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(442, 491).addBox(-4.0F, 4.5F, -9.5F, 8.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -167.5F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r33 = bone7.addOrReplaceChild("cube_r33",
				CubeListBuilder.create().texOffs(150, 433).addBox(-6.0F, -155.0F, -14.5F, 12.0F, 148.0F, 29.0F, new CubeDeformation(0.0F)).texOffs(410, 152).addBox(-14.5F, -155.0F, -6.0F, 29.0F, 148.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(450, 58).addBox(-12.0F, -13.48F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(450, 0).addBox(-5.0F, -13.5F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-14.0F, 8.5F, 14.0F));
		PartDefinition cube_r34 = bone5.addOrReplaceChild("cube_r34",
				CubeListBuilder.create().texOffs(446, 433).addBox(-5.0F, -13.47F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(450, 102).addBox(-12.0F, -13.49F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(450, 58).addBox(-12.0F, -13.48F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(450, 0).addBox(-5.0F, -13.5F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-14.0F, 8.5F, -14.0F));
		PartDefinition cube_r35 = bone6.addOrReplaceChild("cube_r35",
				CubeListBuilder.create().texOffs(446, 433).addBox(-5.0F, -13.47F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(450, 102).addBox(-12.0F, -13.49F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(450, 58).mirror().addBox(-12.0F, -13.48F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(450, 0).mirror()
				.addBox(-5.0F, -13.5F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 8.5F, 14.0F));
		PartDefinition cube_r36 = bone3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(446, 433).mirror().addBox(-5.0F, -13.47F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(450, 102).mirror()
				.addBox(-12.0F, -13.49F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(450, 58).mirror().addBox(-12.0F, -13.48F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(450, 0).mirror()
				.addBox(-5.0F, -13.5F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 8.5F, -14.0F));
		PartDefinition cube_r37 = bone4.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(446, 433).mirror().addBox(-5.0F, -13.47F, -12.0F, 10.0F, 34.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(450, 102).mirror()
				.addBox(-12.0F, -13.49F, -5.0F, 24.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
