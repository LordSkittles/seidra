package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.blocks.SeidraBlock;
import com.lordskittles.seidra.common.blocks.SeidraColumnBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Seidra.MODID);

    public static final RegistryObject<Item> JUNIPER_LOG = registerColumnItemBlock(Blocks.JUNIPER_LOG);
    public static final RegistryObject<Item> PINE_LOG = registerColumnItemBlock(Blocks.PINE_LOG);
    public static final RegistryObject<Item> YEW_LOG = registerColumnItemBlock(Blocks.YEW_LOG);

    public static final RegistryObject<Item> STRIPPED_JUNIPER_LOG = registerColumnItemBlock(Blocks.STRIPPED_JUNIPER_LOG);
    public static final RegistryObject<Item> STRIPPED_PINE_LOG = registerColumnItemBlock(Blocks.STRIPPED_PINE_LOG);
    public static final RegistryObject<Item> STRIPPED_YEW_LOG = registerColumnItemBlock(Blocks.STRIPPED_YEW_LOG);

    public static final RegistryObject<Item> JUNIPER_PLANKS = registerItemBlock(Blocks.JUNIPER_PLANKS);
    public static final RegistryObject<Item> PINE_PLANKS = registerItemBlock(Blocks.PINE_PLANKS);
    public static final RegistryObject<Item> YEW_PLANKS = registerItemBlock(Blocks.YEW_PLANKS);


    public static final RegistryObject<Item> BISMUTH_ORE = registerItemBlock(Blocks.BISMUTH_ORE);
    public static final RegistryObject<Item> COBALT_ORE = registerItemBlock(Blocks.COBALT_ORE);
    public static final RegistryObject<Item> TUNGSTEN_ORE = registerItemBlock(Blocks.TUNGSTEN_ORE);
    public static final RegistryObject<Item> IOLITE_ORE = registerItemBlock(Blocks.IOLITE_ORE);
    public static final RegistryObject<Item> THULITE_ORE = registerItemBlock(Blocks.THULITE_ORE);
    public static final RegistryObject<Item> ZIOSITE_ORE = registerItemBlock(Blocks.ZOISITE_ORE);

    public static final RegistryObject<Item> DEEPSLATE_BISMUTH_ORE = registerItemBlock(Blocks.DEEPSLATE_BISMUTH_ORE);
    public static final RegistryObject<Item> DEEPSLATE_COBALT_ORE = registerItemBlock(Blocks.DEEPSLATE_COBALT_ORE);
    public static final RegistryObject<Item> DEEPSLATE_TUNGSTEN_ORE = registerItemBlock(Blocks.DEEPSLATE_TUNGSTEN_ORE);
    public static final RegistryObject<Item> DEEPSLATE_IOLITE_ORE = registerItemBlock(Blocks.DEEPSLATE_IOLITE_ORE);
    public static final RegistryObject<Item> DEEPSLATE_THULITE_ORE = registerItemBlock(Blocks.DEEPSLATE_THULITE_ORE);
    public static final RegistryObject<Item> DEEPSLATE_ZIOSITE_ORE = registerItemBlock(Blocks.DEEPSLATE_ZOISITE_ORE);

    private static <BLOCK extends SeidraBlock> RegistryObject<Item> registerItemBlock(RegistryObject<BLOCK> block)
    {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }

    private static <BLOCK extends SeidraColumnBlock> RegistryObject<Item> registerColumnItemBlock(RegistryObject<BLOCK> block)
    {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }
}
