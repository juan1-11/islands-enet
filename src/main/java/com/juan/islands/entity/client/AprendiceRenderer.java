package com.juan.islands.entity.client;

import com.juan.islands.entity.custom.AprendiceEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EvokerEntityRenderer;
import net.minecraft.util.Identifier;

public class AprendiceRenderer extends EvokerEntityRenderer<AprendiceEntity> {

    private static final Identifier TEXTURE = new Identifier("islands_enet", "textures/entity/illager/aprendice.png");

    public AprendiceRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public Identifier getTexture(AprendiceEntity entity) {
        return TEXTURE;
    }
}