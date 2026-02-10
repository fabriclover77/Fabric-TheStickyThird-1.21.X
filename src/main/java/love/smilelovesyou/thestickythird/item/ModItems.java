package love.smilelovesyou.thestickythird.item;

import love.smilelovesyou.thestickythird.TheStickyThird;
import love.smilelovesyou.thestickythird.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ALOE_VERA = registerItem("aloe_vera", new Item(new Item.Settings()));
    public static final Item ALOE_VERA_GEL = registerItem("aloe_vera_gel", new Item(new Item.Settings()));
    public static final Item ALOE_VERA_OFFSET = registerItem("aloe_vera_offset",
            new AliasedBlockItem(ModBlocks.ALOE_VERA_PLANT, new  Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheStickyThird.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheStickyThird.LOGGER.info("Registering ModItems for " +  TheStickyThird.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
            itemGroup.add(ModItems.ALOE_VERA);
            itemGroup.add(ModItems.ALOE_VERA_GEL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> {
            itemGroup.add(ModItems.ALOE_VERA);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> {
            itemGroup.add(ModItems.ALOE_VERA);
            itemGroup.add(ModItems.ALOE_VERA_OFFSET);
        });
    }
}