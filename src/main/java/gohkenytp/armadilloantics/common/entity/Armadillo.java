package gohkenytp.armadilloantics.common.entity;

import gohkenytp.armadilloantics.core.ArmadilloAntics;
import gohkenytp.armadilloantics.core.other.tags.ArmadilloAnticsItemTags;
import gohkenytp.armadilloantics.core.registry.ArmadilloAnticsEntityTypes;
import gohkenytp.armadilloantics.core.registry.ArmadilloAnticsItems;
import gohkenytp.armadilloantics.core.registry.ArmadilloAnticsSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class Armadillo extends Animal {

    public Armadillo(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(ArmadilloAnticsItems.ARMADILLO_SPAWN_EGG.get());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return ArmadilloAnticsEntityTypes.ARMADILLO.get().create(p_146743_);
    }

    public boolean isFood(ItemStack stack) {
        return stack.is(ArmadilloAnticsItemTags.ARMADILLO_FOOD);
    }


    public float getScale() {
        return this.isBaby() ? 0.7F : 1.0F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ArmadilloAnticsSoundEvents.ARMADILLO_HURT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ArmadilloAnticsSoundEvents.ARMADILLO_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ArmadilloAnticsSoundEvents.ARMADILLO_HURT.get();
    }
}
