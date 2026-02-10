package love.smilelovesyou.thestickythird.block;

import love.smilelovesyou.thestickythird.TheStickyThird;
import love.smilelovesyou.thestickythird.block.custom.AloeVeraBlock;
import love.smilelovesyou.thestickythird.block.custom.AloeVeraPlantBlock;
import love.smilelovesyou.thestickythird.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ALOE_VERA_BLOCK = registerBlock("aloe_vera_block",
            new AloeVeraBlock(AloeVeraBlock.Settings.create()
                    .velocityMultiplier(0.4F)
                    .jumpVelocityMultiplier(0.5F)
                    .pistonBehavior(PistonBehavior.NORMAL)
                    .solid()
                    .noCollision()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.HONEY)));
    
    public static final Block ALOE_VERA_PLANT = registerBlockWithoutBlockItem("aloe_vera_plant",
            new AloeVeraPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));



    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TheStickyThird.MOD_ID + ":" + name), block);
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TheStickyThird.MOD_ID, name), block);
    }
    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TheStickyThird.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TheStickyThird.LOGGER.info("Registering ModBlocks for " + TheStickyThird.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> {
            itemGroup.add(ModBlocks.ALOE_VERA_BLOCK);
        });
    }
}
