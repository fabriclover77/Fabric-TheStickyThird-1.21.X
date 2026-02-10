package love.smilelovesyou.thestickythird.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ALOE_VERA = new FoodComponent.Builder()
            .nutrition(1)
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION,  // Effect type
                    40,  // Duration in ticks (20 ticks = 1 second, so 60 = 3 seconds)
                    0    // Amplifier (0 = Regeneration I, 1 = Regeneration II, etc.)
            ), 0.9f)  // Chance (1.0f = 100% chance)
            .alwaysEdible()
            .build();
}
