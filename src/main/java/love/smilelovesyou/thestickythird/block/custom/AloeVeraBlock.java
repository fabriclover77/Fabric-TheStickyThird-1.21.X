package love.smilelovesyou.thestickythird.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AloeVeraBlock extends Block {
    public AloeVeraBlock(Settings settings) {super(settings);}

    public static final MapCodec<AloeVeraBlock> CODEC = createCodec(AloeVeraBlock::new);

    public MapCodec<AloeVeraBlock> getCodec() {
        return CODEC;
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
        if (!world.isClient) {
            world.sendEntityStatus(entity, (byte) 54);
        }

        if (entity.handleFallDamage(fallDistance, 0, world.getDamageSources().fall())) {
            entity.playSound(this.soundGroup.getFallSound(), this.soundGroup.getVolume() * 0.5F, this.soundGroup.getPitch() * 0.75F);
        }

    }
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        Vec3d vec3d = new Vec3d((double)0.8F, (double)0.8F, (double)0.8F);
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasStatusEffect(StatusEffects.WEAVING)) {
                vec3d = new Vec3d((double)0.8F, (double)0.8F, (double)0.8F);
            }
        }
        if (entity instanceof PlayerEntity player) {
            // Apply regeneration (20 ticks = 1 second)
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION,  // Effect type
                    60,                          // Duration: 3 seconds (60 ticks)
                    0,                           // Amplifier: 0 = Regen I
                    false,                       // Ambient (from beacon)
                    true                        // Show particles
            ));

        entity.slowMovement(state, vec3d);
        }
    }
}
