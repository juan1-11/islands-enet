package com.juan.islands.entity;

import com.juan.islands.entity.custom.AprendiceEntity;
import com.juan.islands.entity.custom.BurningZombieEntity;
import com.juan.islands.entity.custom.SharkEntity;
import com.juan.islands.entity.custom.VexEvokerEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final EntityType<SharkEntity> SHARK = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("islands_enet", "shark_kid"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SharkEntity::new)
            .dimensions(EntityDimensions.fixed(0.9F, 0.6F))
            .build()
    );

    public static final EntityType<VexEvokerEntity> VEX_EVOKER = Registry.register(
        Registry.ENTITY_TYPE,
         new Identifier("islands_enet", "vex_evoker"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VexEvokerEntity::new)
            .dimensions(EntityDimensions.fixed(0.9F, 0.6F))
            .build()
        
    );

    public static final EntityType<AprendiceEntity> APRENDICE = Registry.register(
    Registry.ENTITY_TYPE,
    new Identifier("islands_enet", "aprendice"),
    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AprendiceEntity::new)
        .dimensions(EntityDimensions.fixed(0.6F, 1.95F))
        .build()
    );

    public static final EntityType<BurningZombieEntity> BURNING_ZOMBIE = Registry.register(
    Registry.ENTITY_TYPE,
    new Identifier("islands_enet", "burning_zombie"),
    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BurningZombieEntity::new)
        .dimensions(EntityDimensions.fixed(0.6F, 1.95F))
        .build()
    );

    public static void registerModEntities() {
        // Fuerza la carga de la clase
    }
}