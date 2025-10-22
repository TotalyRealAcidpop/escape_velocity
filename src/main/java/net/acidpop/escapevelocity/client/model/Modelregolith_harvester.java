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

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelregolith_harvester<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("escape_velocity", "modelregolith_harvester"), "main");
	public final ModelPart LeftWheelFront;
	public final ModelPart RightWheelFront;
	public final ModelPart LeftWheelBack;
	public final ModelPart Scrub;
	public final ModelPart Scrub2;
	public final ModelPart RightWheelBack;
	public final ModelPart LeftWheelMiddle;
	public final ModelPart RightWheelMiddle;
	public final ModelPart bb_main;

	public Modelregolith_harvester(ModelPart root) {
		this.LeftWheelFront = root.getChild("LeftWheelFront");
		this.RightWheelFront = root.getChild("RightWheelFront");
		this.LeftWheelBack = root.getChild("LeftWheelBack");
		this.Scrub = root.getChild("Scrub");
		this.Scrub2 = root.getChild("Scrub2");
		this.RightWheelBack = root.getChild("RightWheelBack");
		this.LeftWheelMiddle = root.getChild("LeftWheelMiddle");
		this.RightWheelMiddle = root.getChild("RightWheelMiddle");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition LeftWheelFront = partdefinition.addOrReplaceChild("LeftWheelFront",
				CubeListBuilder.create().texOffs(34, 369).addBox(-4.5F, -9.9971F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)).texOffs(54, 341).addBox(-3.0F, -7.0471F, -7.0F, 6.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(15.0F, 14.2471F, -6.0F));
		PartDefinition hexadecagon_r1 = LeftWheelFront.addOrReplaceChild("hexadecagon_r1", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r2 = LeftWheelFront.addOrReplaceChild("hexadecagon_r2", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r3 = LeftWheelFront.addOrReplaceChild("hexadecagon_r3", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r4 = LeftWheelFront.addOrReplaceChild("hexadecagon_r4", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r5 = LeftWheelFront.addOrReplaceChild("hexadecagon_r5", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r6 = LeftWheelFront.addOrReplaceChild("hexadecagon_r6", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r7 = LeftWheelFront.addOrReplaceChild("hexadecagon_r7", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r8 = LeftWheelFront.addOrReplaceChild("hexadecagon_r8", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -3.1416F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r9 = LeftWheelFront.addOrReplaceChild("hexadecagon_r9", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r10 = LeftWheelFront.addOrReplaceChild("hexadecagon_r10", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r11 = LeftWheelFront.addOrReplaceChild("hexadecagon_r11", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r12 = LeftWheelFront.addOrReplaceChild("hexadecagon_r12", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r13 = LeftWheelFront.addOrReplaceChild("hexadecagon_r13", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r14 = LeftWheelFront.addOrReplaceChild("hexadecagon_r14", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r15 = LeftWheelFront.addOrReplaceChild("hexadecagon_r15", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition RightWheelFront = partdefinition.addOrReplaceChild("RightWheelFront",
				CubeListBuilder.create().texOffs(34, 369).addBox(-4.5F, -9.9971F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)).texOffs(54, 341).addBox(-3.0F, -7.0471F, -7.0F, 6.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, 14.2471F, -6.0F));
		PartDefinition hexadecagon_r16 = RightWheelFront.addOrReplaceChild("hexadecagon_r16", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r17 = RightWheelFront.addOrReplaceChild("hexadecagon_r17", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r18 = RightWheelFront.addOrReplaceChild("hexadecagon_r18", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r19 = RightWheelFront.addOrReplaceChild("hexadecagon_r19", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r20 = RightWheelFront.addOrReplaceChild("hexadecagon_r20", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r21 = RightWheelFront.addOrReplaceChild("hexadecagon_r21", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r22 = RightWheelFront.addOrReplaceChild("hexadecagon_r22", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r23 = RightWheelFront.addOrReplaceChild("hexadecagon_r23", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -3.1416F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r24 = RightWheelFront.addOrReplaceChild("hexadecagon_r24", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r25 = RightWheelFront.addOrReplaceChild("hexadecagon_r25", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r26 = RightWheelFront.addOrReplaceChild("hexadecagon_r26", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r27 = RightWheelFront.addOrReplaceChild("hexadecagon_r27", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r28 = RightWheelFront.addOrReplaceChild("hexadecagon_r28", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r29 = RightWheelFront.addOrReplaceChild("hexadecagon_r29", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r30 = RightWheelFront.addOrReplaceChild("hexadecagon_r30", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition LeftWheelBack = partdefinition.addOrReplaceChild("LeftWheelBack",
				CubeListBuilder.create().texOffs(34, 369).addBox(-4.5F, -9.9971F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)).texOffs(54, 341).addBox(-3.0F, -7.0471F, -7.0F, 6.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(15.0F, 14.2471F, 44.0F));
		PartDefinition hexadecagon_r31 = LeftWheelBack.addOrReplaceChild("hexadecagon_r31", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r32 = LeftWheelBack.addOrReplaceChild("hexadecagon_r32", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r33 = LeftWheelBack.addOrReplaceChild("hexadecagon_r33", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r34 = LeftWheelBack.addOrReplaceChild("hexadecagon_r34", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r35 = LeftWheelBack.addOrReplaceChild("hexadecagon_r35", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r36 = LeftWheelBack.addOrReplaceChild("hexadecagon_r36", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r37 = LeftWheelBack.addOrReplaceChild("hexadecagon_r37", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r38 = LeftWheelBack.addOrReplaceChild("hexadecagon_r38", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r39 = LeftWheelBack.addOrReplaceChild("hexadecagon_r39", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r40 = LeftWheelBack.addOrReplaceChild("hexadecagon_r40", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r41 = LeftWheelBack.addOrReplaceChild("hexadecagon_r41", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r42 = LeftWheelBack.addOrReplaceChild("hexadecagon_r42", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r43 = LeftWheelBack.addOrReplaceChild("hexadecagon_r43", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r44 = LeftWheelBack.addOrReplaceChild("hexadecagon_r44", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r45 = LeftWheelBack.addOrReplaceChild("hexadecagon_r45", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition Scrub = partdefinition.addOrReplaceChild("Scrub",
				CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -5.2411F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)).texOffs(362, 371).addBox(-5.0F, -1.2381F, -0.9946F, 10.0F, 5.0F, 1.9891F, new CubeDeformation(0.0F))
						.texOffs(124, 360).addBox(-0.9946F, -1.2381F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 341).addBox(-6.9946F, -5.2381F, -7.0F, 13.9891F, 8.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 18.9881F, 36.0F));
		PartDefinition hexadecagon_r46 = Scrub.addOrReplaceChild("hexadecagon_r46",
				CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(286, 308).addBox(7.0F, -6.5029F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition hexadecagon_r47 = Scrub.addOrReplaceChild(
				"hexadecagon_r47", CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(362, 371)
						.addBox(-5.0F, -2.5F, -0.9946F, 10.0F, 5.0F, 1.9891F, new CubeDeformation(0.0F)).texOffs(94, 341).addBox(7.0F, -6.4929F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition hexadecagon_r48 = Scrub.addOrReplaceChild(
				"hexadecagon_r48", CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(362, 371)
						.addBox(-5.0F, -2.5F, -0.9946F, 10.0F, 5.0F, 1.9891F, new CubeDeformation(0.0F)).texOffs(94, 341).addBox(7.0F, -6.4929F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition hexadecagon_r49 = Scrub.addOrReplaceChild("hexadecagon_r49",
				CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(286, 308).addBox(7.0F, -6.5029F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition hexadecagon_r50 = Scrub.addOrReplaceChild("hexadecagon_r50", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -6.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, -1.1781F, 0.0F));
		PartDefinition hexadecagon_r51 = Scrub.addOrReplaceChild("hexadecagon_r51", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -2.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition hexadecagon_r52 = Scrub.addOrReplaceChild("hexadecagon_r52", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, -2.3562F, 0.0F));
		PartDefinition hexadecagon_r53 = Scrub.addOrReplaceChild("hexadecagon_r53", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -2.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, -1.9635F, 0.0F));
		PartDefinition hexadecagon_r54 = Scrub.addOrReplaceChild("hexadecagon_r54", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -2.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, -2.7489F, 0.0F));
		PartDefinition hexadecagon_r55 = Scrub.addOrReplaceChild("hexadecagon_r55", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition hexadecagon_r56 = Scrub.addOrReplaceChild("hexadecagon_r56", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -2.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, 2.7489F, 0.0F));
		PartDefinition hexadecagon_r57 = Scrub.addOrReplaceChild("hexadecagon_r57", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 2.3562F, 0.0F));
		PartDefinition hexadecagon_r58 = Scrub.addOrReplaceChild("hexadecagon_r58", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.49F, -1.9891F, 3.5F, 9.23F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 1.9635F, 0.0F));
		PartDefinition hexadecagon_r59 = Scrub.addOrReplaceChild("hexadecagon_r59", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -2.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition hexadecagon_r60 = Scrub.addOrReplaceChild("hexadecagon_r60", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -6.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 1.1781F, 0.0F));
		PartDefinition Scrub2 = partdefinition.addOrReplaceChild("Scrub2",
				CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -5.2411F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)).texOffs(362, 371).addBox(-5.0F, -1.2381F, -0.9946F, 10.0F, 5.0F, 1.9891F, new CubeDeformation(0.0F))
						.texOffs(124, 360).addBox(-0.9946F, -1.2381F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 341).addBox(-6.9946F, -5.2381F, -7.0F, 13.9891F, 8.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 18.9881F, 13.0F));
		PartDefinition hexadecagon_r61 = Scrub2.addOrReplaceChild("hexadecagon_r61",
				CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(286, 308).addBox(7.0F, -6.5029F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition hexadecagon_r62 = Scrub2.addOrReplaceChild(
				"hexadecagon_r62", CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(362, 371)
						.addBox(-5.0F, -2.5F, -0.9946F, 10.0F, 5.0F, 1.9891F, new CubeDeformation(0.0F)).texOffs(94, 341).addBox(7.0F, -6.4929F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition hexadecagon_r63 = Scrub2.addOrReplaceChild(
				"hexadecagon_r63", CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(362, 371)
						.addBox(-5.0F, -2.5F, -0.9946F, 10.0F, 5.0F, 1.9891F, new CubeDeformation(0.0F)).texOffs(94, 341).addBox(7.0F, -6.4929F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition hexadecagon_r64 = Scrub2.addOrReplaceChild("hexadecagon_r64",
				CubeListBuilder.create().texOffs(124, 360).addBox(-0.9946F, -2.5F, -5.0F, 1.9891F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(286, 308).addBox(7.0F, -6.5029F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2619F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition hexadecagon_r65 = Scrub2.addOrReplaceChild("hexadecagon_r65", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -6.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, -1.1781F, 0.0F));
		PartDefinition hexadecagon_r66 = Scrub2.addOrReplaceChild("hexadecagon_r66", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -2.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition hexadecagon_r67 = Scrub2.addOrReplaceChild("hexadecagon_r67", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, -2.3562F, 0.0F));
		PartDefinition hexadecagon_r68 = Scrub2.addOrReplaceChild("hexadecagon_r68", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -2.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, -1.9635F, 0.0F));
		PartDefinition hexadecagon_r69 = Scrub2.addOrReplaceChild("hexadecagon_r69", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -2.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, -2.7489F, 0.0F));
		PartDefinition hexadecagon_r70 = Scrub2.addOrReplaceChild("hexadecagon_r70", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition hexadecagon_r71 = Scrub2.addOrReplaceChild("hexadecagon_r71", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -2.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, 2.7489F, 0.0F));
		PartDefinition hexadecagon_r72 = Scrub2.addOrReplaceChild("hexadecagon_r72", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 2.3562F, 0.0F));
		PartDefinition hexadecagon_r73 = Scrub2.addOrReplaceChild("hexadecagon_r73", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -6.49F, -1.9891F, 3.5F, 9.23F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 1.9635F, 0.0F));
		PartDefinition hexadecagon_r74 = Scrub2.addOrReplaceChild("hexadecagon_r74", CubeListBuilder.create().texOffs(286, 308).addBox(7.0F, -2.5F, -1.9891F, 3.0F, 9.75F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.7411F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition hexadecagon_r75 = Scrub2.addOrReplaceChild("hexadecagon_r75", CubeListBuilder.create().texOffs(94, 341).addBox(7.0F, -6.49F, -1.9891F, 3.5F, 8.98F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.2589F, 0.0F, 0.0F, 1.1781F, 0.0F));
		PartDefinition RightWheelBack = partdefinition.addOrReplaceChild("RightWheelBack",
				CubeListBuilder.create().texOffs(34, 369).addBox(-4.5F, -9.9971F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)).texOffs(54, 341).addBox(-3.0F, -7.0471F, -7.0F, 6.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, 14.2471F, 44.0F));
		PartDefinition hexadecagon_r76 = RightWheelBack.addOrReplaceChild("hexadecagon_r76", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r77 = RightWheelBack.addOrReplaceChild("hexadecagon_r77", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r78 = RightWheelBack.addOrReplaceChild("hexadecagon_r78", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r79 = RightWheelBack.addOrReplaceChild("hexadecagon_r79", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r80 = RightWheelBack.addOrReplaceChild("hexadecagon_r80", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r81 = RightWheelBack.addOrReplaceChild("hexadecagon_r81", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r82 = RightWheelBack.addOrReplaceChild("hexadecagon_r82", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r83 = RightWheelBack.addOrReplaceChild("hexadecagon_r83", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r84 = RightWheelBack.addOrReplaceChild("hexadecagon_r84", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r85 = RightWheelBack.addOrReplaceChild("hexadecagon_r85", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r86 = RightWheelBack.addOrReplaceChild("hexadecagon_r86", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r87 = RightWheelBack.addOrReplaceChild("hexadecagon_r87", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r88 = RightWheelBack.addOrReplaceChild("hexadecagon_r88", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r89 = RightWheelBack.addOrReplaceChild("hexadecagon_r89", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r90 = RightWheelBack.addOrReplaceChild("hexadecagon_r90", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition LeftWheelMiddle = partdefinition.addOrReplaceChild("LeftWheelMiddle",
				CubeListBuilder.create().texOffs(34, 369).addBox(-4.5F, -9.9971F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)).texOffs(54, 341).addBox(-3.0F, -7.0471F, -7.0F, 6.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(15.0F, 14.2471F, 23.0F));
		PartDefinition hexadecagon_r91 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r91", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r92 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r92", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r93 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r93", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r94 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r94", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r95 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r95", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r96 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r96", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r97 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r97", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r98 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r98", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r99 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r99", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r100 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r100", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r101 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r101", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r102 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r102", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r103 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r103", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r104 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r104", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r105 = LeftWheelMiddle.addOrReplaceChild("hexadecagon_r105", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition RightWheelMiddle = partdefinition.addOrReplaceChild("RightWheelMiddle",
				CubeListBuilder.create().texOffs(34, 369).addBox(-4.5F, -9.9971F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)).texOffs(54, 341).addBox(-3.0F, -7.0471F, -7.0F, 6.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-15.0F, 14.2471F, 23.0F));
		PartDefinition hexadecagon_r106 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r106", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r107 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r107", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r108 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r108", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r109 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r109", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r110 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r110", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r111 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r111", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r112 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r112", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, -2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r113 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r113", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r114 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r114", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 2.7489F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r115 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r115", CubeListBuilder.create().texOffs(34, 369).addBox(-2.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r116 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r116", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.9635F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r117 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r117", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r118 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r118", CubeListBuilder.create().texOffs(340, 371).addBox(-2.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0029F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r119 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r119", CubeListBuilder.create().texOffs(34, 369).addBox(-6.5F, -10.0F, -1.9891F, 9.0F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r120 = RightWheelMiddle.addOrReplaceChild("hexadecagon_r120", CubeListBuilder.create().texOffs(340, 371).addBox(-6.49F, -10.0F, -1.9891F, 8.98F, 3.0F, 3.9782F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.0029F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(150, 237).addBox(-14.0F, -37.0F, 9.0F, 28.0F, 22.0F, 49.0F, new CubeDeformation(0.0F)).texOffs(304, 237).addBox(-14.0F, -50.0F, 14.5F, 28.0F, 13.0F, 40.5F, new CubeDeformation(0.0F)).texOffs(150, 308)
						.addBox(-13.0F, -49.0F, -13.0F, 26.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(94, 357).addBox(-12.0F, -49.5F, 12.25F, 24.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(336, 10)
						.addBox(12.0F, -25.5F, -19.5F, 2.0F, 5.0F, 23.75F, new CubeDeformation(0.0F)).texOffs(336, 38).addBox(-14.0F, -25.5F, -19.5F, 2.0F, 5.0F, 23.75F, new CubeDeformation(0.0F)).texOffs(186, 0)
						.addBox(14.0F, -24.75F, -18.21F, 1.15F, 3.0F, 74.27F, new CubeDeformation(0.0F)).texOffs(0, 237).addBox(-15.15F, -24.75F, -18.21F, 1.15F, 3.0F, 74.27F, new CubeDeformation(0.0F)).texOffs(326, 162)
						.addBox(12.0F, -49.5F, -12.75F, 2.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(326, 191).addBox(-14.0F, -49.5F, -12.75F, 2.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(326, 103)
						.addBox(-20.51F, -13.0F, -21.0F, 41.02F, 4.6F, 5.0F, new CubeDeformation(0.0F)).texOffs(146, 363).addBox(9.99F, -19.6F, 7.4F, 10.5F, 5.2F, 2.1F, new CubeDeformation(0.0F)).texOffs(326, 121)
						.addBox(-20.5F, -8.4F, -21.0F, 41.0F, 2.025F, 3.0F, new CubeDeformation(0.0F)).texOffs(204, 362).addBox(9.99F, -10.7F, 4.975F, 10.5F, 1.3F, 7.05F, new CubeDeformation(0.0F)).texOffs(212, 370)
						.addBox(9.99F, -14.4F, 33.0F, 10.52F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 371).addBox(9.99F, -17.25F, 32.25F, 10.52F, 2.85F, 2.5F, new CubeDeformation(0.0F)).texOffs(316, 371)
						.addBox(-20.51F, -17.25F, 32.25F, 10.52F, 2.85F, 2.5F, new CubeDeformation(0.0F)).texOffs(234, 370).addBox(-20.51F, -14.4F, 33.0F, 10.52F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(170, 363)
						.addBox(-20.49F, -19.6F, 7.4F, 10.5F, 5.2F, 2.1F, new CubeDeformation(0.0F)).texOffs(0, 363).addBox(-20.49F, -10.7F, 4.975F, 10.5F, 1.3F, 7.05F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-10.0F, -15.375F, -18.0F, 20.0F, 6.0F, 73.7F, new CubeDeformation(0.0F)).texOffs(304, 290).addBox(-14.02F, -21.0F, -18.0F, 28.04F, 5.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(80, 369)
						.addBox(-13.24F, -38.5F, -16.7F, 0.0F, 13.0F, 5.55F, new CubeDeformation(0.0F)).texOffs(298, 308).addBox(-13.24F, -46.5F, -14.2F, 0.0F, 8.0F, 3.05F, new CubeDeformation(0.0F)).texOffs(238, 362)
						.addBox(-13.24F, -31.5F, -18.7F, 0.0F, 6.0F, 2.05F, new CubeDeformation(0.0F)).texOffs(106, 314).addBox(-13.24F, -47.5F, -11.2F, 0.0F, 22.0F, 21.95F, new CubeDeformation(0.0F)).texOffs(238, 362)
						.addBox(13.24F, -31.5F, -18.7F, 0.0F, 6.0F, 2.05F, new CubeDeformation(0.0F)).texOffs(80, 369).addBox(13.24F, -38.5F, -16.7F, 0.0F, 13.0F, 5.55F, new CubeDeformation(0.0F)).texOffs(298, 308)
						.addBox(13.24F, -46.5F, -14.2F, 0.0F, 8.0F, 3.05F, new CubeDeformation(0.0F)).texOffs(106, 314).addBox(13.24F, -47.5F, -11.2F, 0.0F, 22.0F, 21.95F, new CubeDeformation(0.0F)).texOffs(326, 112)
						.addBox(-20.5F, -13.0F, 53.75F, 41.0F, 4.6F, 5.0F, new CubeDeformation(0.0F)).texOffs(326, 126).addBox(-20.5F, -8.4F, 55.75F, 41.0F, 2.025F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(326, 325).addBox(-2.74F, 0.0F, 0.0F, 40.98F, 2.85F, 1.45F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.75F, -8.4F, 53.75F, 0.7802F, 0.0F, 0.0F));
		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(326, 131).addBox(13.25F, 9.5F, -27.0F, 0.0F, 2.0F, 29.75F, new CubeDeformation(0.0F)).texOffs(326, 131).addBox(-13.25F, 9.5F, -27.0F, 0.0F, 2.0F, 29.75F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -49.0F, 1.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(204, 335).addBox(13.25F, 1.5F, -27.0F, 0.0F, 1.0F, 26.75F, new CubeDeformation(0.0F)).texOffs(204, 335).addBox(-13.25F, 1.5F, -27.0F, 0.0F, 1.0F, 26.75F, new CubeDeformation(0.0F)).texOffs(0, 314)
						.addBox(-13.0F, 0.0F, -27.0F, 26.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(148, 335).addBox(-13.99F, -0.5F, -27.0F, 2.0F, 2.0F, 26.75F, new CubeDeformation(0.0F)).texOffs(326, 328)
						.addBox(11.99F, -0.5F, -27.0F, 2.0F, 2.0F, 26.75F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -49.0F, -13.0F, 1.2654F, 0.0F, 0.0F));
		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(24, 371).addBox(8.98F, -4.5F, -3.0F, 4.04F, 11.1F, 0.5F, new CubeDeformation(0.0F)).texOffs(24, 371).addBox(0.98F, -4.5F, -3.0F, 4.04F, 11.1F, 0.5F, new CubeDeformation(0.0F)).texOffs(316, 361)
						.addBox(-6.02F, -3.5F, -3.0F, 4.04F, 10.1F, 0.5F, new CubeDeformation(0.0F)).texOffs(326, 220).addBox(-8.02F, -5.5F, -2.5F, 30.04F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(316, 361)
						.addBox(15.98F, -3.5F, -3.0F, 4.04F, 10.1F, 0.5F, new CubeDeformation(0.0F)).texOffs(336, 66).addBox(-8.02F, -6.5F, -1.5F, 30.04F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -17.5F, -20.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(94, 352).addBox(8.98F, -0.2F, -0.5F, 4.04F, 3.7F, 0.5F, new CubeDeformation(0.0F)).texOffs(94, 352).addBox(0.98F, -0.2F, -0.5F, 4.04F, 3.7F, 0.5F, new CubeDeformation(0.0F)).texOffs(248, 77)
						.addBox(-6.02F, -0.2F, -0.5F, 4.04F, 2.7F, 0.5F, new CubeDeformation(0.0F)).texOffs(248, 77).addBox(15.98F, -0.2F, -0.5F, 4.04F, 2.7F, 0.5F, new CubeDeformation(0.0F)).texOffs(336, 0)
						.addBox(-8.04F, 0.0F, 0.0F, 30.08F, 5.5F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -11.25F, -23.55F, 0.48F, 0.0F, 0.0F));
		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(186, 77).addBox(-15.01F, -0.011F, 0.002F, 30.02F, 1.4F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.095F, -21.4297F, -0.8814F, 0.0F, 0.0F));
		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(326, 328).addBox(-14.0F, -0.5F, -27.0F, 2.0F, 2.0F, 26.75F, new CubeDeformation(0.0F)).texOffs(326, 328).addBox(12.0F, -0.5F, -27.0F, 2.0F, 2.0F, 26.75F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -49.0F, 13.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(286, 361).addBox(-2.53F, -7.0F, -5.0F, 10.52F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(256, 308).addBox(27.99F, -7.0F, -5.0F, 10.52F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-18.0F, -13.0F, 9.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(256, 361).addBox(-2.5F, -7.0F, 0.0F, 10.5F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(94, 360).addBox(28.0F, -7.0F, 0.0F, 10.5F, 9.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-18.0F, -13.0F, 8.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(190, 370).addBox(-2.5F, -7.0F, 4.0F, 10.5F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(146, 370).addBox(28.0F, -7.0F, 4.0F, 10.5F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-18.0F, -13.0F, 29.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(168, 370).addBox(-2.5F, -7.0F, -5.0F, 10.5F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 369).addBox(28.0F, -7.0F, -5.0F, 10.5F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-18.0F, -13.0F, 38.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(326, 90).addBox(-38.5F, -8.25F, -5.0F, 41.0F, 8.25F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(18.0F, -13.0F, 58.75F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r13 = bb_main.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(326, 356).addBox(-14.01F, 0.0F, -2.975F, 28.02F, 13.35F, 2.975F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -50.0F, 55.0F, 0.2269F, 0.0F, 0.0F));
		PartDefinition cube_r14 = bb_main.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(326, 322).addBox(-2.74F, 0.0F, -1.45F, 40.98F, 2.85F, 1.45F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.75F, -8.4F, -16.0F, -0.7802F, 0.0F, 0.0F));
		PartDefinition cube_r15 = bb_main.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(326, 77).addBox(-38.5F, -8.25F, 0.0F, 41.0F, 8.25F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(18.0F, -13.0F, -21.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r16 = bb_main.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(256, 78).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.75F, 1.0F, new CubeDeformation(0.0F)).texOffs(256, 77).addBox(25.0F, 0.0F, -1.0F, 2.0F, 0.75F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-13.0F, -49.5F, -12.75F, 0.637F, 0.0F, 0.0F));
		PartDefinition cube_r17 = bb_main.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(336, 71).addBox(-12.0F, -0.5F, -0.5F, 24.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.4F, -20.75F, 1.2654F, 0.0F, 0.0F));
		PartDefinition cube_r18 = bb_main.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(164, 158).addBox(0.0F, 0.0F, -23.0F, 7.0F, 5.0F, 74.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-21.0F, -21.0F, 4.8F, 0.0F, 0.0F, -0.5672F));
		PartDefinition cube_r19 = bb_main.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 158).addBox(0.0F, 0.0F, -36.51F, 8.0F, 5.0F, 74.27F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-21.0F, -21.0F, 18.3F, 0.0F, 0.0F, -0.1309F));
		PartDefinition cube_r20 = bb_main.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(164, 79).addBox(-7.0F, 0.0F, -23.0F, 7.0F, 5.0F, 74.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(21.0F, -21.0F, 4.8F, 0.0F, 0.0F, 0.5672F));
		PartDefinition cube_r21 = bb_main.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 79).addBox(-8.0F, 0.0F, -36.51F, 8.0F, 5.0F, 74.27F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(21.0F, -21.0F, 18.3F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r22 = bb_main.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(256, 322).addBox(-14.01F, -32.0F, -1.0F, 28.02F, 32.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -20.0F, 3.0F, -0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftWheelFront.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWheelFront.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWheelBack.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scrub.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Scrub2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWheelBack.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWheelMiddle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWheelMiddle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
