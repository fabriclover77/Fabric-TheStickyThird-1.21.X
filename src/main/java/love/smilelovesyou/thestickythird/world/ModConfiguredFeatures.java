package love.smilelovesyou.thestickythird.world;

import love.smilelovesyou.thestickythird.TheStickyThird;
import love.smilelovesyou.thestickythird.block.ModBlocks;
import love.smilelovesyou.thestickythird.block.custom.AloeVeraPlantBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ALOE_VERA_PLANT_KEY = registerKey("aloe_vera_plant");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, ALOE_VERA_PLANT_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of((BlockState)
                                ModBlocks.ALOE_VERA_PLANT.getDefaultState().with(AloeVeraPlantBlock.AGE, 3))),
                        List.of(Blocks.SAND, Blocks.GRASS_BLOCK, Blocks.DIRT)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TheStickyThird.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}