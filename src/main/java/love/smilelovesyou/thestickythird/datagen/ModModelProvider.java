package love.smilelovesyou.thestickythird.datagen;

import love.smilelovesyou.thestickythird.block.ModBlocks;
import love.smilelovesyou.thestickythird.block.custom.AloeVeraPlantBlock;
import love.smilelovesyou.thestickythird.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.ALOE_VERA_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED,
                AloeVeraPlantBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
