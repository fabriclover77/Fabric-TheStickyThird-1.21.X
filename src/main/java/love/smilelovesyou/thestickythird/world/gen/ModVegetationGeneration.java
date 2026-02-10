package love.smilelovesyou.thestickythird.world.gen;

import love.smilelovesyou.thestickythird.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModVegetationGeneration {
    public static void generateAloe() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.DESERT,
                BiomeKeys.SAVANNA,
                BiomeKeys.SAVANNA_PLATEAU,
                BiomeKeys.WINDSWEPT_SAVANNA,
                BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ALOE_VERA_PLANT_PLACED_KEY);
    }

}
