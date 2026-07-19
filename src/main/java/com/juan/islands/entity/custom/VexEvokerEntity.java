package com.juan.islands.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class VexEvokerEntity extends VexEntity {

    public VexEvokerEntity(EntityType<? extends VexEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new VexEvokerMoveControl(this);
        this.experiencePoints = 5;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(4, new ChargeAttackGoal());
        this.goalSelector.add(8, new WanderGoal());
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createVexEvokerAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
    }

    // Equivalente propio de VexEntity.ChargeTargetGoal (inaccesible por ser package-private)
    class ChargeAttackGoal extends Goal {
        public ChargeAttackGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return VexEvokerEntity.this.getTarget() != null
                && !VexEvokerEntity.this.getMoveControl().isMoving()
                && VexEvokerEntity.this.random.nextInt(7) == 0
                && VexEvokerEntity.this.squaredDistanceTo(VexEvokerEntity.this.getTarget()) > 4.0;
        }

        @Override
        public boolean shouldContinue() {
            LivingEntity target = VexEvokerEntity.this.getTarget();
            return VexEvokerEntity.this.getMoveControl().isMoving() && target != null && target.isAlive();
        }

        @Override
        public void start() {
            Vec3d vec3d = VexEvokerEntity.this.getTarget().getCameraPosVec(1.0F);
            VexEvokerEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0);
        }

        @Override
        public void tick() {
            LivingEntity target = VexEvokerEntity.this.getTarget();
            if (VexEvokerEntity.this.getBoundingBox().intersects(target.getBoundingBox())) {
                VexEvokerEntity.this.tryAttack(target);
            } else if (VexEvokerEntity.this.squaredDistanceTo(target) < 9.0) {
                Vec3d vec3d = target.getCameraPosVec(1.0F);
                VexEvokerEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0);
            }
        }
    }

    // Equivalente propio de VexEntity.LookAtTargetGoal — vuelo erratico cuando no ataca
    class WanderGoal extends Goal {
        public WanderGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return !VexEvokerEntity.this.getMoveControl().isMoving() && VexEvokerEntity.this.random.nextInt(7) == 0;
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void tick() {
            BlockPos pos = VexEvokerEntity.this.getBlockPos();
            for (int i = 0; i < 3; i++) {
                BlockPos target = pos.add(
                    VexEvokerEntity.this.random.nextInt(15) - 7,
                    VexEvokerEntity.this.random.nextInt(11) - 5,
                    VexEvokerEntity.this.random.nextInt(15) - 7
                );
                if (VexEvokerEntity.this.world.isAir(target)) {
                    VexEvokerEntity.this.moveControl.moveTo(target.getX() + 0.5, target.getY() + 0.5, target.getZ() + 0.5, 0.25);
                    break;
                }
            }
        }
    }

    // Equivalente propio de VexEntity.VexMoveControl
    static class VexEvokerMoveControl extends MoveControl {
        private final VexEvokerEntity vex;

        public VexEvokerMoveControl(VexEvokerEntity vex) {
            super(vex);
            this.vex = vex;
        }

        @Override
        public void tick() {
            if (this.state == MoveControl.State.MOVE_TO) {
                Vec3d vec3d = new Vec3d(this.targetX - vex.getX(), this.targetY - vex.getY(), this.targetZ - vex.getZ());
                double d = vec3d.length();
                if (d < vex.getBoundingBox().getAverageSideLength()) {
                    this.state = MoveControl.State.WAIT;
                    vex.setVelocity(vex.getVelocity().multiply(0.5));
                } else {
                    vex.setVelocity(vex.getVelocity().add(vec3d.multiply(this.speed * 0.05 / d)));
                    if (vex.getTarget() == null) {
                        Vec3d velocity = vex.getVelocity();
                        vex.yaw = -((float) MathHelper.atan2(velocity.x, velocity.z)) * (180.0F / (float) Math.PI);
                        vex.bodyYaw = vex.yaw;
                    } else {
                        double e = vex.getTarget().getX() - vex.getX();
                        double f = vex.getTarget().getZ() - vex.getZ();
                        vex.yaw = -((float) MathHelper.atan2(e, f)) * (180.0F / (float) Math.PI);
                        vex.bodyYaw = vex.yaw;
                    }
                }
            }
        }
    }
}