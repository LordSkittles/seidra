package com.lordskittles.seidra.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.blocks.*;
import com.lordskittles.seidra.worldgen.tree.SeidraTreeGrowers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Blocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Seidra.MODID);

    public static final DeferredBlock<SeidraLogBlock> JUNIPER_LOG = registerBlock("juniper_log", "Juniper Log", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> PINE_LOG = registerBlock("pine_log", "Pine Log", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> YEW_LOG = registerBlock("yew_log", "Yew Log", SeidraLogBlock.class);

    public static final DeferredBlock<SeidraLogBlock> JUNIPER_WOOD = registerBlock("juniper_wood", "Juniper wood", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> PINE_WOOD = registerBlock("pine_wood", "Pine wood", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> YEW_WOOD = registerBlock("yew_wood", "Yew wood", SeidraLogBlock.class);

    public static final DeferredBlock<SeidraLogBlock> STRIPPED_JUNIPER_LOG = registerBlock("stripped_juniper_log", "Stripped Juniper Log", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log", "Stripped Pine Log", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_YEW_LOG = registerBlock("stripped_yew_log", "Stripped Yew Log", SeidraLogBlock.class);

    public static final DeferredBlock<SeidraLogBlock> STRIPPED_JUNIPER_WOOD = registerBlock("stripped_juniper_wood", "Stripped Juniper Wood", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood", "Stripped Pine Wood", SeidraLogBlock.class);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_YEW_WOOD = registerBlock("stripped_yew_wood", "Stripped Yew Wood", SeidraLogBlock.class);

    public static final DeferredBlock<SeidraPlankBlock> JUNIPER_PLANKS = registerBlock("juniper_planks", "Juniper Planks", SeidraPlankBlock.class);
    public static final DeferredBlock<SeidraPlankBlock> PINE_PLANKS = registerBlock("pine_planks", "Pine Planks", SeidraPlankBlock.class);
    public static final DeferredBlock<SeidraPlankBlock> YEW_PLANKS = registerBlock("yew_planks", "Yew Planks", SeidraPlankBlock.class);

    public static final DeferredBlock<SeidraSaplingBlock> JUNIPER_SAPLING = registerBlock("juniper_sapling", "Juniper Sapling", SeidraSaplingBlock.class, SeidraTreeGrowers.JUNIPER);
    public static final DeferredBlock<SeidraSaplingBlock> PINE_SAPLING = registerBlock("pine_sapling", "Pine Sapling", SeidraSaplingBlock.class, SeidraTreeGrowers.PINE);
    public static final DeferredBlock<SeidraSaplingBlock> YEW_SAPLING = registerBlock("yew_sapling", "Yew Sapling", SeidraSaplingBlock.class, SeidraTreeGrowers.YEW);

    public static final DeferredBlock<SeidraLeafBlock> JUNIPER_LEAVES = registerBlock("juniper_leaves", "Juniper Leaves", SeidraLeafBlock.class, JUNIPER_SAPLING);
    public static final DeferredBlock<SeidraLeafBlock> PINE_LEAVES = registerBlock("pine_leaves", "Pine Leaves", SeidraLeafBlock.class, PINE_SAPLING);
    public static final DeferredBlock<SeidraLeafBlock> YEW_LEAVES = registerBlock("yew_leaves", "Yew Leaves", SeidraLeafBlock.class, YEW_SAPLING);

    public static final DeferredBlock<SeidraOreBlock> BISMUTH_ORE = registerBlock("bismuth_ore", "Bismuth Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> COBALT_ORE = registerBlock("cobalt_ore", "Cobalt Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> TUNGSTEN_ORE = registerBlock("tungsten_ore", "Tungsten Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> IOLITE_ORE = registerBlock("iolite_ore", "Iolite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> THULITE_ORE = registerBlock("thulite_ore", "Thulite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> ZOISITE_ORE = registerBlock("zoisite_ore", "Zoisite Ore", SeidraOreBlock.class, 3.0F, 3.0F);

    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_BISMUTH_ORE = registerBlock("deepslate_bismuth_ore", "Deepslate Bismuth Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", "Deepslate Cobalt Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore", "Deepslate Tungsten Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_IOLITE_ORE = registerBlock("deepslate_iolite_ore", "Deepslate Iolite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_THULITE_ORE = registerBlock("deepslate_thulite_ore", "Deepslate Thulite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final DeferredBlock<SeidraOreBlock> DEEPSLATE_ZOISITE_ORE = registerBlock("deepslate_zoisite_ore", "Deepslate Zoisite Ore", SeidraOreBlock.class, 3.0F, 3.0F);

    public static final Map<DeferredBlock<SeidraLogBlock>, DeferredBlock<SeidraLogBlock>> STRIPPING_MAP = Map.of(
            JUNIPER_LOG, STRIPPED_JUNIPER_LOG,
            PINE_LOG, STRIPPED_PINE_LOG,
            YEW_LOG, STRIPPED_YEW_LOG,
            JUNIPER_WOOD, STRIPPED_JUNIPER_WOOD,
            PINE_WOOD, STRIPPED_PINE_WOOD,
            YEW_WOOD, STRIPPED_YEW_WOOD
    );

    // TODO: Don't do this... it's stupid
    public static final List<DeferredBlock<SeidraLogBlock>> LOGS = List.of(JUNIPER_LOG, PINE_LOG, YEW_LOG, STRIPPED_JUNIPER_LOG, STRIPPED_PINE_LOG, STRIPPED_YEW_LOG);
    public static final List<DeferredBlock<SeidraLogBlock>> WOOD = List.of(JUNIPER_WOOD, PINE_WOOD, YEW_WOOD, STRIPPED_JUNIPER_WOOD, STRIPPED_PINE_WOOD, STRIPPED_YEW_WOOD);
    public static final List<DeferredBlock<SeidraPlankBlock>> PLANKS = List.of(JUNIPER_PLANKS, PINE_PLANKS, YEW_PLANKS);
    public static final List<DeferredBlock<SeidraLeafBlock>> LEAVES = List.of(JUNIPER_LEAVES, PINE_LEAVES, YEW_LEAVES);
    public static final List<DeferredBlock<SeidraSaplingBlock>> SAPLINGS = List.of(JUNIPER_SAPLING, PINE_SAPLING, YEW_SAPLING);

    public static final List<DeferredBlock<SeidraOreBlock>> ORES = List.of(BISMUTH_ORE, COBALT_ORE, TUNGSTEN_ORE, IOLITE_ORE, THULITE_ORE, ZOISITE_ORE);
    public static final List<DeferredBlock<SeidraOreBlock>> DEEPSLATE_ORES = List.of(DEEPSLATE_BISMUTH_ORE, DEEPSLATE_COBALT_ORE, DEEPSLATE_TUNGSTEN_ORE, DEEPSLATE_IOLITE_ORE, DEEPSLATE_THULITE_ORE, DEEPSLATE_ZOISITE_ORE);

    private static <BLOCK extends Block> DeferredBlock<BLOCK> registerBlock(String id, String prettyName, Class<BLOCK> clazz, Object... params)
    {
        DeferredBlock<BLOCK> deferredBlock = BLOCKS.register(id, () -> instantiateBlock(clazz, prettyName, params));
        Items.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

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
