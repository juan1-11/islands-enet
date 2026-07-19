package com.juan.islands.entity.client;

import com.juan.islands.entity.custom.VexEvokerEntity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class VexEvokerRenderer extends MobEntityRenderer<VexEvokerEntity, VexEvokerModel> {

    private static final Identifier TEXTURE = new Identifier("islands_enet", "textures/entity/vex_evoker.png");

    public VexEvokerRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new VexEvokerModel(), 0.7F);
    }

    @Override
    public Identifier getTexture(VexEvokerEntity entity) {
        return TEXTURE;
    }
}