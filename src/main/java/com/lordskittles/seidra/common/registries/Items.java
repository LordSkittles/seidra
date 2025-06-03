package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.blocks.SeidraBlock;
import com.lordskittles.seidra.common.blocks.SeidraColumnBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Seidra.MODID);

    public static final DeferredItem<Item> JUNIPER_LOG = registerItemBlock(Blocks.JUNIPER_LOG);
    public static final DeferredItem<Item> PINE_LOG = registerItemBlock(Blocks.PINE_LOG);
    public static final DeferredItem<Item> YEW_LOG = registerItemBlock(Blocks.YEW_LOG);

    public static final DeferredItem<Item> STRIPPED_JUNIPER_LOG = registerItemBlock(Blocks.STRIPPED_JUNIPER_LOG);
    public static final DeferredItem<Item> STRIPPED_PINE_LOG = registerItemBlock(Blocks.STRIPPED_PINE_LOG);
    public static final DeferredItem<Item> STRIPPED_YEW_LOG = registerItemBlock(Blocks.STRIPPED_YEW_LOG);

    public static final DeferredItem<Item> JUNIPER_PLANKS = registerItemBlock(Blocks.JUNIPER_PLANKS);
    public static final DeferredItem<Item> PINE_PLANKS = registerItemBlock(Blocks.PINE_PLANKS);
    public static final DeferredItem<Item> YEW_PLANKS = registerItemBlock(Blocks.YEW_PLANKS);

    public static final DeferredItem<Item> JUNIPER_LEAVES = registerItemBlock(Blocks.JUNIPER_LEAVES);
    public static final DeferredItem<Item> PINE_LEAVES = registerItemBlock(Blocks.PINE_LEAVES);
    public static final DeferredItem<Item> YEW_LEAVES = registerItemBlock(Blocks.YEW_LEAVES);


    public static final DeferredItem<Item> BISMUTH_ORE = registerItemBlock(Blocks.BISMUTH_ORE);
    public static final DeferredItem<Item> COBALT_ORE = registerItemBlock(Blocks.COBALT_ORE);
    public static final DeferredItem<Item> TUNGSTEN_ORE = registerItemBlock(Blocks.TUNGSTEN_ORE);
    public static final DeferredItem<Item> IOLITE_ORE = registerItemBlock(Blocks.IOLITE_ORE);
    public static final DeferredItem<Item> THULITE_ORE = registerItemBlock(Blocks.THULITE_ORE);
    public static final DeferredItem<Item> ZIOSITE_ORE = registerItemBlock(Blocks.ZOISITE_ORE);

    public static final DeferredItem<Item> DEEPSLATE_BISMUTH_ORE = registerItemBlock(Blocks.DEEPSLATE_BISMUTH_ORE);
    public static final DeferredItem<Item> DEEPSLATE_COBALT_ORE = registerItemBlock(Blocks.DEEPSLATE_COBALT_ORE);
    public static final DeferredItem<Item> DEEPSLATE_TUNGSTEN_ORE = registerItemBlock(Blocks.DEEPSLATE_TUNGSTEN_ORE);
    public static final DeferredItem<Item> DEEPSLATE_IOLITE_ORE = registerItemBlock(Blocks.DEEPSLATE_IOLITE_ORE);
    public static final DeferredItem<Item> DEEPSLATE_THULITE_ORE = registerItemBlock(Blocks.DEEPSLATE_THULITE_ORE);
    public static final DeferredItem<Item> DEEPSLATE_ZIOSITE_ORE = registerItemBlock(Blocks.DEEPSLATE_ZOISITE_ORE);

    private static DeferredItem<Item> registerItemBlock(DeferredBlock<?> block)
    {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
