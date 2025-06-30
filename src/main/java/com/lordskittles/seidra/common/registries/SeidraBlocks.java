package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.functional.ArcaneCraftingBlock;
import com.lordskittles.seidra.common.block.simple.SeidraLogBlock;
import com.lordskittles.seidra.common.block.simple.SeidraSimpleBlock;
import com.lordskittles.seidra.common.block.simple.SeidraSimpleColumnBlock;
import com.lordskittles.seidra.common.block.simple.WakestoneBlock;
import com.lordskittles.seidra.common.worldgen.tree.SeidraTreeGrowers;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SeidraBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Seidra.MODID);
    public static final Map<String, DeferredBlock<?>> ALL = new HashMap<>();

    public static final DeferredBlock<SeidraLogBlock> ASH_LOG = registerBlock("ash_log", "Ash Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> PINE_LOG = registerBlock("pine_log", "Pine Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> YEW_LOG = registerBlock("yew_log", "Yew Log", SeidraLogBlock.class, false);

    public static final DeferredBlock<SeidraLogBlock> ASH_WOOD = registerBlock("ash_wood", "Ash wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> PINE_WOOD = registerBlock("pine_wood", "Pine wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> YEW_WOOD = registerBlock("yew_wood", "Yew wood", SeidraLogBlock.class, true);

    public static final DeferredBlock<SeidraLogBlock> STRIPPED_ASH_LOG = registerBlock("stripped_ash_log", "Stripped Ash Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log", "Stripped Pine Log", SeidraLogBlock.class, false);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_YEW_LOG = registerBlock("stripped_yew_log", "Stripped Yew Log", SeidraLogBlock.class, false);

    public static final DeferredBlock<SeidraLogBlock> STRIPPED_ASH_WOOD = registerBlock("stripped_ash_wood", "Stripped Ash Wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood", "Stripped Pine Wood", SeidraLogBlock.class, true);
    public static final DeferredBlock<SeidraLogBlock> STRIPPED_YEW_WOOD = registerBlock("stripped_yew_wood", "Stripped Yew Wood", SeidraLogBlock.class, true);

    public static final DeferredBlock<Block> ASH_PLANKS = register("ash_planks", Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> PINE_PLANKS = register("pine_planks", Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> YEW_PLANKS = register("yew_planks", Blocks.OAK_PLANKS);

    public static final DeferredBlock<Block> ASH_SAPLING = BLOCKS.register("ash_sapling", () -> new SaplingBlock(SeidraTreeGrowers.ASH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PINE_SAPLING = BLOCKS.register("pine_sapling", () -> new SaplingBlock(SeidraTreeGrowers.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> YEW_SAPLING = BLOCKS.register("yew_sapling", () -> new SaplingBlock(SeidraTreeGrowers.YEW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> ASH_LEAVES = BLOCKS.registerBlock("ash_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> PINE_LEAVES = BLOCKS.registerBlock("ash_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> YEW_LEAVES = BLOCKS.registerBlock("ash_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));

    public static final DeferredBlock<Block> BISMUTH_BLOCK = register("bismuth_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> SILVER_BLOCK = register("silver_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> TUNGSTEN_BLOCK = register("tungsten_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> RAW_BISMUTH_BLOCK = register("raw_bismuth_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = register("raw_silver_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> RAW_TUNGSTEN_BLOCK = register("raw_tungsten_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> AMBER_BLOCK = register("amber_block", Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<Block> LABRADORITE_BLOCK = register("labradorite_block", Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<Block> THULITE_BLOCK = register("thulite_block", Blocks.DIAMOND_BLOCK);

    public static final DeferredBlock<Block> BISMUTH_ORE = registerOre("bismuth_ore", ConstantInt.of(0), Blocks.IRON_ORE);
    public static final DeferredBlock<Block> TUNGSTEN_ORE = registerOre("tungsten_ore", ConstantInt.of(0), Blocks.IRON_ORE);
    public static final DeferredBlock<Block> SILVER_ORE = registerOre("silver_ore", ConstantInt.of(0), Blocks.IRON_ORE);
    public static final DeferredBlock<Block> AMBER_ORE = registerOre("amber_ore", UniformInt.of(2, 5), Blocks.DIAMOND_ORE);
    public static final DeferredBlock<Block> LABRADORITE_ORE = registerOre("labradorite_ore", UniformInt.of(2, 5), Blocks.DIAMOND_ORE);
    public static final DeferredBlock<Block> THULITE_ORE = registerOre("thulite_ore", UniformInt.of(3, 7), Blocks.DIAMOND_ORE);

    public static final DeferredBlock<Block> DEEPSLATE_BISMUTH_ORE = registerOre("deepslate_bismuth_ore", ConstantInt.of(0), Blocks.DEEPSLATE_IRON_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE =  registerOre("deepslate_silver_ore", ConstantInt.of(0), Blocks.DEEPSLATE_IRON_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_TUNGSTEN_ORE =  registerOre("deepslate_tungsten_ore", ConstantInt.of(0), Blocks.DEEPSLATE_IRON_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_AMBER_ORE =  registerOre("deepslate_amber_ore", UniformInt.of(2, 5), Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_LABRADORITE_ORE =  registerOre("deepslate_labradorite_ore", UniformInt.of(2, 5), Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_THULITE_ORE =  registerOre("deepslate_thulite_ore", UniformInt.of(3, 7), Blocks.DEEPSLATE_DIAMOND_ORE);

    public static final DeferredBlock<SeidraSimpleBlock> FELDSPAR = registerBlock("feldspar", "Feldspar", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<SeidraSimpleBlock> FELDSPAR_BRICK = registerBlock("feldspar_brick", "Feldspar Brick", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final DeferredBlock<SeidraSimpleBlock> POLISHED_FELDSPAR = registerBlock("feldspar_polished", "Polished Feldspar", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE));
    public static final DeferredBlock<SeidraSimpleBlock> CRACKED_FELDSPAR = registerBlock("cracked_feldspar", "Cracked Feldspar", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<SeidraSimpleBlock> CRACKED_FELDSPAR_BRICK = registerBlock("cracked_feldspar_brick", "Cracked Polished Brick", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final DeferredBlock<SeidraSimpleBlock> CRACKED_POLISHED_FELDSPAR = registerBlock("cracked_feldspar_polished", "Cracked Polished Feldspar", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE));
    public static final DeferredBlock<SeidraSimpleBlock> CHISELED_FELDSPAR_BRICK = registerBlock("chiseled_feldspar_brick", "Chiseled Feldspar Brick", SeidraSimpleBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS));
    public static final DeferredBlock<SeidraSimpleColumnBlock> FELDSPAR_PILLAR = registerBlock("feldspar_pillar", "Feldspar Pillar", SeidraSimpleColumnBlock.class, CreativeTabs.WORLD, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE));

    public static final DeferredBlock<WakestoneBlock> WAKESTONE = registerBlock("wakestone", WakestoneBlock::new);
    public static final DeferredBlock<Block> CRACKED_DEEPSLATE_BRICK_SLAB = BLOCKS.registerBlock("cracked_deepslate_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS));
    public static final DeferredBlock<Block> CRACKED_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("cracked_deepslate_brick_stairs", () -> new StairBlock(Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS)));

    public static final DeferredBlock<ArcaneCraftingBlock> ARCANE_CRAFTING_BLOCK = registerBlockEntity("arcane_crafting_block", ArcaneCraftingBlock.class);

    private static <BLOCK extends Block> DeferredBlock<BLOCK> registerBlockEntity(String id, Class<BLOCK> clazz)
    {
        DeferredBlock<BLOCK> deferredBlock = BLOCKS.register(id, () -> instantiateBlockEntity(clazz));

        Items.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        return deferredBlock;
    }

    private static DeferredBlock<Block> register(String id, Block block)
    {
        return register(id, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static DeferredBlock<Block> register(String id, BlockBehaviour.Properties properties)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.registerBlock(id, Block::new, properties);

        Items.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        return deferredBlock;
    }

    private static DeferredBlock<Block> registerOre(String id, IntProvider provider, Block parent)
    {
        return registerOre(id, provider, BlockBehaviour.Properties.ofFullCopy(parent));
    }

    private static DeferredBlock<Block> registerOre(String id, IntProvider provider, BlockBehaviour.Properties properties)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.register(id, () -> new DropExperienceBlock(provider, properties));

        Items.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        return deferredBlock;
    }

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

    private static <BLOCK> BLOCK instantiateBlockEntity(Class<BLOCK> clazz, Object... params)
    {
        try
        {
            BlockBehaviour.Properties props = BlockBehaviour.Properties.of();

            if (params.length > 0)
            {
                Class<?>[] paramTypes = new Class<?>[params.length + 1];
                paramTypes[0] = BlockBehaviour.Properties.class;
                IntStream.range(0, params.length).forEach(i -> paramTypes[i + 1] = params[i].getClass());

                Object[] paramValues = new Object[params.length + 1];
                paramValues[0] = props;
                System.arraycopy(params, 0, paramValues, 1, params.length);

                return clazz.getConstructor(paramTypes).newInstance(paramValues);
            }

            return clazz.getConstructor(BlockBehaviour.Properties.class).newInstance(props);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
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
