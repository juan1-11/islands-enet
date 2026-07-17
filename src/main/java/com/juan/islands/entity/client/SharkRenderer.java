package com.juan.islands.entity.client;

import com.juan.islands.entity.custom.SharkEntity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SharkRenderer extends MobEntityRenderer<SharkEntity, SharkModel<SharkEntity>> {

    private static final Identifier TEXTURE = new Identifier("islands_enet", "textures/entity/shark_kid.png");

    public SharkRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new SharkModel<>(), 0.7F);
    }

    @Override
    public Identifier getTexture(SharkEntity entity) {
        return TEXTURE;
    }
}