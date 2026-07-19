package com.juan.islands.entity.client;

import com.juan.islands.entity.custom.VexEvokerEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class VexEvokerModel extends EntityModel<VexEvokerEntity> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart rightItem;
	private final ModelPart leftArm;
	private final ModelPart leftWing;
	private final ModelPart rightWing;

	public VexEvokerModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelPart(this, 0, 10);
		body.addCuboid(-1.5F, -4.0F, -1.0F, 3.0F, 4.0F, 2.0F, 0.0F);
		body.setTextureOffset(0, 16).addCuboid(-1.5F, -3.0F, -1.0F, 3.0F, 5.0F, 2.0F, -0.2F);
		body.setPivot(0.0F, 24.0F, 0.0F);

		head = new ModelPart(this, 0, 0);
		head.addCuboid(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F);
		head.setPivot(0.0F, -4.0F, 0.0F);
		body.addChild(head);

		rightArm = new ModelPart(this, 23, 0);
		rightArm.addCuboid(-1.25F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, -0.1F);
		rightArm.setPivot(-1.75F, -3.75F, 0.0F);
		body.addChild(rightArm);

		rightItem = new ModelPart(this, 0, 0);
		rightItem.setPivot(-0.25F, 2.75F, 0.0F);
		rightArm.addChild(rightItem);

		leftArm = new ModelPart(this, 23, 6);
		leftArm.addCuboid(-0.75F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, -0.1F);
		leftArm.setPivot(1.75F, -3.75F, 0.0F);
		body.addChild(leftArm);

		leftWing = new ModelPart(this, 16, 22);
		leftWing.mirror = true;
		leftWing.addCuboid(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F);
		leftWing.mirror = false;
		leftWing.setPivot(0.5F, -3.0F, 1.0F);
		body.addChild(leftWing);

		rightWing = new ModelPart(this, 16, 22);
		rightWing.addCuboid(-8.0F, 0.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F);
		rightWing.setPivot(-0.5F, -3.0F, 1.0F);
		body.addChild(rightWing);
	}

	@Override
	public void setAngles(VexEvokerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}