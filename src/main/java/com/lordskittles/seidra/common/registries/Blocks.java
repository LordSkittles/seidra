package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.*;
import com.lordskittles.seidra.common.worldgen.tree.SeidraTreeGrowers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Blocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Seidra.MODID);
    public static final Map<String, DeferredBlock<?>> ALL = new HashMap<>();

    public static final DeferredBlock<SeidraLogBlock> JUNIPER_LOG = registerBlock("juniper_log", "Juniper Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> PINE_LOG = registerBlock("pine_log", "Pine Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> YEW_LOG = registerBlock("yew_log", "Yew Log", SeidraLogBlock.class, false);

    public static final DeferredBlock<SeidraLogBlock> JUNIPER_WOOD = registerBlock("juniper_wood", "Juniper wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> PINE_WOOD = registerBlock("pine_wood", "Pine wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> YEW_WOOD = registerBlock("yew_wood", "Yew wood", SeidraLogBlock.class, true);

    public static final DeferredBlock<SeidraLogBlock> STRIPPED_JUNIPER_LOG = registerBlock("stripped_juniper_log", "Stripped Juniper Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log", "Stripped Pine Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_YEW_LOG = registerBlock("stripped_yew_log", "Stripped Yew Log", SeidraLogBlock.class, false);

    public static final DeferredBlock<SeidraLogBlock> STRIPPED_JUNIPER_WOOD = registerBlock("stripped_juniper_wood", "Stripped Juniper Wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood", "Stripped Pine Wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_YEW_WOOD = registerBlock("stripped_yew_wood", "Stripped Yew Wood", SeidraLogBlock.class, true);

    public static final DeferredBlock<SeidraPlankBlock> JUNIPER_PLANKS = registerBlock("juniper_planks", "Juniper Planks", SeidraPlankBlock.class);
    public static final DeferredBlock<SeidraPlankBlock> PINE_PLANKS = registerBlock("pine_planks", "Pine Planks", SeidraPlankBlock.class);
    public static final DeferredBlock<SeidraPlankBlock> YEW_PLANKS = registerBlock("yew_planks", "Yew Planks", SeidraPlankBlock.class);

    public static final DeferredBlock<SeidraSaplingBlock> JUNIPER_SAPLING = registerBlock("juniper_sapling", "Juniper Sapling", SeidraSaplingBlock.class, SeidraTreeGrowers.JUNIPER);
    public static final DeferredBlock<SeidraSaplingBlock> PINE_SAPLING = registerBlock("pine_sapling", "Pine Sapling", SeidraSaplingBlock.class, SeidraTreeGrowers.PINE);
    public static final DeferredBlock<SeidraSaplingBlock> YEW_SAPLING = registerBlock("yew_sapling", "Yew Sapling", SeidraSaplingBlock.class, SeidraTreeGrowers.YEW);

    public static final DeferredBlock<SeidraLeafBlock> JUNIPER_LEAVES = registerBlock("juniper_leaves", "Juniper Leaves", SeidraLeafBlock.class, JUNIPER_SAPLING);
    public static final DeferredBlock<SeidraLeafBlock> PINE_LEAVES = registerBlock("pine_leaves", "Pine Leaves", SeidraLeafBlock.class, PINE_SAPLING);
    public static final DeferredBlock<SeidraLeafBlock> YEW_LEAVES = registerBlock("yew_leaves", "Yew Leaves", SeidraLeafBlock.class, YEW_SAPLING);

    public static final DeferredBlock<SeidraOreBlock> BISMUTH_ORE = registerBlock("bismuth_ore", "Bismuth Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.RAW_BISMUTH);
    public static final DeferredBlock<SeidraOreBlock> COBALT_ORE = registerBlock("cobalt_ore", "Cobalt Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.RAW_COBALT);
    public static final DeferredBlock<SeidraOreBlock> TUNGSTEN_ORE = registerBlock("tungsten_ore", "Tungsten Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.RAW_TUNGSTEN);
    public static final DeferredBlock<SeidraOreBlock> IOLITE_ORE = registerBlock("iolite_ore", "Iolite Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.IOLITE_GEM);
    public static final DeferredBlock<SeidraOreBlock> THULITE_ORE = registerBlock("thulite_ore", "Thulite Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.THULITE_GEM);
    public static final DeferredBlock<SeidraOreBlock> ZOISITE_ORE = registerBlock("zoisite_ore", "Zoisite Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.ZOISITE_GEM);

    public static final DeferredBlock<SeidraStorageBlock> BISMUTH_BLOCK = registerBlock("bismuth_block", "Bismuth Block", SeidraStorageBlock.class, 5.0F);
    public static final DeferredBlock<SeidraStorageBlock> COBALT_BLOCK = registerBlock("cobalt_block", "Cobalt Block", SeidraStorageBlock.class, 5.0F);
    public static final DeferredBlock<SeidraStorageBlock> TUNGSTEN_BLOCK = registerBlock("tungsten_block", "Tungsten Block", SeidraStorageBlock.class, 5.0F);
    public static final DeferredBlock<SeidraStorageBlock> IOLITE_BLOCK = registerBlock("iolite_block", "Iolite Block", SeidraStorageBlock.class, 5.0F);
    public static final DeferredBlock<SeidraStorageBlock> THULITE_BLOCK = registerBlock("thulite_block", "Thulite Block", SeidraStorageBlock.class, 5.0F);
    public static final DeferredBlock<SeidraStorageBlock> ZOISITE_BLOCK = registerBlock("zoisite_block", "Zoisite Block", SeidraStorageBlock.class, 5.0F);

    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_BISMUTH_ORE = registerBlock("deepslate_bismuth_ore", "Deepslate Bismuth Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.RAW_BISMUTH);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", "Deepslate Cobalt Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.RAW_COBALT);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore", "Deepslate Tungsten Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.RAW_TUNGSTEN);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_IOLITE_ORE = registerBlock("deepslate_iolite_ore", "Deepslate Iolite Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.IOLITE_GEM);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_THULITE_ORE = registerBlock("deepslate_thulite_ore", "Deepslate Thulite Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.THULITE_GEM);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_ZOISITE_ORE = registerBlock("deepslate_zoisite_ore", "Deepslate Zoisite Ore", SeidraOreBlock.class, 3.0F, 3.0F, Items.ZOISITE_GEM);

    public static final DeferredBlock<SeidraWakestoneBlock> WAKESTONE = registerBlock("wakestone", SeidraWakestoneBlock::new);
    public static final DeferredBlock<SlabBlock> CRACKED_DEEPSLATE_BRICK_SLAB = registerBlock("cracked_deepslate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final DeferredBlock<StairBlock> CRACKED_DEEPSLATE_BRICK_STAIRS = registerBlock("cracked_deepslate_brick_stairs", () -> new StairBlock(net.minecraft.world.level.block.Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRACKED_DEEPSLATE_BRICKS)));

    private static <BLOCK extends Block> DeferredBlock<BLOCK> registerBlock(String id, Supplier<BLOCK> supplier)
    {
        DeferredBlock<BLOCK> deferredBlock = BLOCKS.register(id, supplier);
        Items.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        return deferredBlock;
    }

    private static <BLOCK extends Block> DeferredBlock<BLOCK> registerBlock(String id, String prettyName, Class<BLOCK> clazz, Object... params)
    {
        DeferredBlock<BLOCK> deferredBlock = BLOCKS.register(id, () -> instantiateBlock(clazz, prettyName, params));
        Items.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        ALL.put(prettyName, deferredBlock);

        return deferredBlock;
    }

    private static <BLOCK> BLOCK instantiateBlock(Class<BLOCK> clazz, String prettyName, Object... params)
    {
        try
        {
            if (params.length > 0)
            {
                Class<?>[] paramTypes = new Class<?>[params.length + 1];
                paramTypes[0] = String.class;
                IntStream.range(0, params.length).forEach(i -> paramTypes[i + 1] = params[i].getClass());

                Object[] paramValues = new Object[params.length + 1];
                paramValues[0] = prettyName;
                System.arraycopy(params, 0, paramValues, 1, params.length);

                return clazz.getConstructor(paramTypes).newInstance(paramValues);
            }

            return clazz.getConstructor(String.class).newInstance(prettyName);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }
}
