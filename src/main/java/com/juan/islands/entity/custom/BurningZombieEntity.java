package com.juan.islands.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class BurningZombieEntity extends ZombieEntity {

    public BurningZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean isOnFire() {
        return true; // Siempre se ve en llamas, sin importar fireTicks ni inmunidad
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean success = super.tryAttack(target);
        if (success) {
            target.setFireTicks(100); // 5 segundos de quemadura (20 ticks = 1 segundo)
        }
        return success;
    }
}