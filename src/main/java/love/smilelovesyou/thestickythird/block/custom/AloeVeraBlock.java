package love.smilelovesyou.thestickythird.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AloeVeraBlock extends Block {
    public AloeVeraBlock(Settings settings) {super(settings);}

    // Use a HashMap to track cooldowns per player
    private static final Map<UUID, Long> COOLDOWN_MAP = new HashMap<>();
    private static final long COOLDOWN_TICKS = 600; // 10 seconds

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

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        Vec3d vec3d = new Vec3d(0.8, 0.8, 0.8);

        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasStatusEffect(StatusEffects.WEAVING)) {
                vec3d = new Vec3d(0.8, 0.8, 0.8);
            }
        }

        if (entity instanceof PlayerEntity player && !world.isClient) {
            UUID playerUUID = player.getUuid();
            long currentTime = world.getTime();

            // Get the last time this player received regeneration from aloe vera
            Long lastCooldown = COOLDOWN_MAP.get(playerUUID);

            // Check if cooldown has expired (or never been set)
            if (lastCooldown == null || currentTime - lastCooldown >= COOLDOWN_TICKS) {
                // Apply regeneration
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.REGENERATION,
                        30,      //duration in ticks
                        0,       // Regeneration I
                        false,
                        true
                ));

                // Update the cooldown map
                COOLDOWN_MAP.put(playerUUID, currentTime);
            }

            entity.slowMovement(state, vec3d);
        }
    }
}