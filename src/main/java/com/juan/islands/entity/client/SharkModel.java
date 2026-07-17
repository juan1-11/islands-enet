package com.juan.islands.entity.client;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class SharkModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart tail;
	private final ModelPart tail_fin;
	private final ModelPart back_fin;
	private final ModelPart left_fin;
	private final ModelPart right_fin;

	public SharkModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelPart(this, 22, 0);
		body.addCuboid(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F, 0.0F);
		body.setPivot(0.0F, 24.0F, -3.0F);

		head = new ModelPart(this, 0, 0);
		head.addCuboid(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 6.0F, 0.0F);
		head.setPivot(0.0F, 0.0F, 0.0F);
		body.addChild(head);

		nose = new ModelPart(this, -2, 13);
		nose.addCuboid(-3.0F, -5.0F, 0.0F, 6.0F, 4.0F, 4.0F, 0.0F);
		nose.setPivot(0.0F, 0.0F, -10.0F);
		head.addChild(nose);

		tail = new ModelPart(this, 0, 19);
		tail.addCuboid(-2.0F, -2.5F, -1.0F, 4.0F, 5.0F, 11.0F, 0.0F);
		tail.setPivot(0.0F, -2.5F, 14.0F);
		body.addChild(tail);

		tail_fin = new ModelPart(this, 19, 20);
		tail_fin.addCuboid(-5.0F, -0.5F, -1.0F, 10.0F, 1.0F, 6.0F, 0.0F);
		tail_fin.setPivot(0.0F, 0.0F, 9.0F);
		tail.addChild(tail_fin);

		back_fin = new ModelPart(this, 49, -2);
		back_fin.addCuboid(-0.5F, -3.75F, -2.5F, 1.0F, 7.0F, 7.0F, 0.0F);
		setRotationAngle(back_fin, 1.0472F, 0.0F, 0.0F);
		back_fin.setPivot(0.0F, -7.0F, 5.0F);
		body.addChild(back_fin);

		left_fin = new ModelPart(this, 48, 20);
		left_fin.addCuboid(0.0F, -4.0F, -1.5F, 1.0F, 4.0F, 7.0F, 0.0F);
		setRotationAngle(left_fin, 0.9599F, 0.0F, 1.8675F);
		left_fin.setPivot(3.0F, -2.0F, 5.0F);
		body.addChild(left_fin);

		right_fin = new ModelPart(this, 48, 20);
		right_fin.mirror = true;
		right_fin.addCuboid(-1.0F, -4.0F, -1.5F, 1.0F, 4.0F, 7.0F, 0.0F);
		right_fin.mirror = false;
		setRotationAngle(right_fin, 0.9599F, 0.0F, -1.8675F);
		right_fin.setPivot(-3.0F, -2.0F, 5.0F);
		body.addChild(right_fin);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Animaciones (nado, giro de cabeza) van acá — lo vemos en un paso siguiente
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}

	private void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
		modelPart.pitch = x;
		modelPart.yaw = y;
		modelPart.roll = z;
	}
}