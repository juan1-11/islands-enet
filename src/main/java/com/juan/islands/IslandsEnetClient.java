package com.juan.islands;

import com.juan.islands.block.ModBlocks;
import com.juan.islands.entity.ModEntities;
import com.juan.islands.entity.client.AprendiceRenderer;
import com.juan.islands.entity.client.BurningZombieRenderer;
import com.juan.islands.entity.client.SharkRenderer;
import com.juan.islands.entity.client.VexEvokerRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class IslandsEnetClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SEA_TORCH, RenderLayer.getCutout());
        EntityRendererRegistry.INSTANCE.register(ModEntities.SHARK, (dispatcher, context) -> new SharkRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.VEX_EVOKER, (dispatcher, context) -> new VexEvokerRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.APRENDICE, (dispatcher, context) -> new AprendiceRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.BURNING_ZOMBIE, (dispatcher, context) -> new BurningZombieRenderer(dispatcher));

    }
}