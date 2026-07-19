package com.juan.islands.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.world.World;

public class AprendiceEntity extends EvokerEntity {

    public AprendiceEntity(EntityType<? extends EvokerEntity> entityType, World world) {
        super(entityType, world);
    }
}
