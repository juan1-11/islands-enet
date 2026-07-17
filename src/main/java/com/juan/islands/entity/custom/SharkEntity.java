package com.juan.islands.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SharkEntity extends HostileEntity {

    public SharkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.moveControl = new SharkMoveControl(this);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, true));
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createSharkAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(0.1F, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
        } else {
            super.travel(movementInput);
        }
    }

    static class SharkMoveControl extends MoveControl {
        private final SharkEntity shark;

        public SharkMoveControl(SharkEntity shark) {
            super(shark);
            this.shark = shark;
        }

        @Override
        public void tick() {
            if (this.state == MoveControl.State.MOVE_TO && !this.shark.getNavigation().isIdle()) {
                double d = this.targetX - this.shark.getX();
                double e = this.targetY - this.shark.getY();
                double f = this.targetZ - this.shark.getZ();
                double g = Math.sqrt(d * d + e * e + f * f);
                e /= g;
                float h = (float) (MathHelper.atan2(f, d) * 180.0F / (float) Math.PI) - 90.0F;
                this.shark.yaw = this.wrapDegrees(this.shark.yaw, h, 90.0F);
                this.shark.bodyYaw = this.shark.yaw;
                float i = (float) (this.speed * this.shark.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                float j = MathHelper.lerp(0.125F, this.shark.getMovementSpeed(), i);
                this.shark.setMovementSpeed(j);
                this.shark.setVelocity(this.shark.getVelocity().add(0.0, j * e * 0.1, 0.0));
            } else {
                this.shark.setMovementSpeed(0.0F);
            }
        }
    }
}
