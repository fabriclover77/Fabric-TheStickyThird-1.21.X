package love.smilelovesyou.thestickythird;

import love.smilelovesyou.thestickythird.block.ModBlocks;
import love.smilelovesyou.thestickythird.block.custom.AloeVeraBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class TheStickyThirdClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALOE_VERA_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALOE_VERA_PLANT, RenderLayer.getCutout());
    }
}
