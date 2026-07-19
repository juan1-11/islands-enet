package com.juan.islands.entity.client;

import com.juan.islands.entity.custom.BurningZombieEntity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

public class BurningZombieRenderer extends ZombieBaseEntityRenderer<BurningZombieEntity, ZombieEntityModel<BurningZombieEntity>> {

    private static final Identifier TEXTURE = new Identifier("islands_enet", "textures/entity/zombie/burning_zombie.png");

    public BurningZombieRenderer(EntityRenderDispatcher dispatcher) {
        super(
            dispatcher,
            new ZombieEntityModel<>(0.0F, false),
            new ZombieEntityModel<>(0.5F, true),
            new ZombieEntityModel<>(1.0F, true)
        );
    }

    @Override
    public Identifier getTexture(BurningZombieEntity entity) {
        return TEXTURE;
    }
}