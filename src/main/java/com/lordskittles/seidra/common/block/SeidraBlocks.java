package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.functional.ArcaneCraftingBlock;
import com.lordskittles.seidra.common.block.simple.WakestoneBlock;
import com.lordskittles.seidra.common.item.SeidraItems;
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
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SeidraBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Seidra.MODID);

    public static final DeferredBlock<Block> ASH_LOG = register("ash_log", RotatedPillarBlock::new, Blocks.OAK_LOG);
    public static final DeferredBlock<Block> PINE_LOG = register("pine_log", RotatedPillarBlock::new, Blocks.OAK_LOG);
    public static final DeferredBlock<Block> YEW_LOG = register("yew_log", RotatedPillarBlock::new, Blocks.OAK_LOG);

    public static final DeferredBlock<Block> ASH_WOOD = register("ash_wood", Blocks.OAK_WOOD);
    public static final DeferredBlock<Block> PINE_WOOD = register("pine_wood", Blocks.OAK_WOOD);
    public static final DeferredBlock<Block> YEW_WOOD = register("yew_wood", Blocks.OAK_WOOD);

    public static final DeferredBlock<Block> STRIPPED_ASH_LOG = register("stripped_ash_log", RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);
    public static final DeferredBlock<Block> STRIPPED_PINE_LOG = register("stripped_pine_log", RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);
    public static final DeferredBlock<Block> STRIPPED_YEW_LOG = register("stripped_yew_log", RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);

    public static final DeferredBlock<Block> STRIPPED_ASH_WOOD = register("stripped_ash_wood", Blocks.STRIPPED_OAK_WOOD);
    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD = register("stripped_pine_wood", Blocks.STRIPPED_OAK_WOOD);
    public static final DeferredBlock<Block> STRIPPED_YEW_WOOD = register("stripped_yew_wood", Blocks.STRIPPED_OAK_WOOD);

    public static final DeferredBlock<Block> ASH_PLANKS = register("ash_planks", Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> PINE_PLANKS = register("pine_planks", Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> YEW_PLANKS = register("yew_planks", Blocks.OAK_PLANKS);

    public static final DeferredBlock<Block> ASH_SAPLING = register("ash_sapling", SaplingBlock.class, SeidraTreeGrowers.ASH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> PINE_SAPLING = register("pine_sapling", SaplingBlock.class, SeidraTreeGrowers.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> YEW_SAPLING = register("yew_sapling", SaplingBlock.class, SeidraTreeGrowers.YEW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> ASH_LEAVES = register("ash_leaves", LeavesBlock::new, Blocks.OAK_LEAVES);
    public static final DeferredBlock<Block> PINE_LEAVES = register("pine_leaves", LeavesBlock::new, Blocks.OAK_LEAVES);
    public static final DeferredBlock<Block> YEW_LEAVES = register("yew_leaves", LeavesBlock::new, Blocks.OAK_LEAVES);

    public static final DeferredBlock<Block> BISMUTH_BLOCK = register("bismuth_block", Blocks.COPPER_BLOCK);
    public static final DeferredBlock<Block> SILVER_BLOCK = register("silver_block", Blocks.GOLD_BLOCK);
    public static final DeferredBlock<Block> TUNGSTEN_BLOCK = register("tungsten_block", Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> RAW_BISMUTH_BLOCK = register("raw_bismuth_block", Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = register("raw_silver_block", Blocks.RAW_GOLD_BLOCK);
    public static final DeferredBlock<Block> RAW_TUNGSTEN_BLOCK = register("raw_tungsten_block", Blocks.RAW_IRON_BLOCK);
    public static final DeferredBlock<Block> AMBER_BLOCK = register("amber_block", Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<Block> LABRADORITE_BLOCK = register("labradorite_block", Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<Block> THULITE_BLOCK = register("thulite_block", Blocks.DIAMOND_BLOCK);

    public static final DeferredBlock<Block> BISMUTH_ORE = registerOre("bismuth_ore", ConstantInt.of(0), Blocks.COPPER_ORE);
    public static final DeferredBlock<Block> SILVER_ORE = registerOre("silver_ore", ConstantInt.of(0), Blocks.GOLD_ORE);
    public static final DeferredBlock<Block> TUNGSTEN_ORE = registerOre("tungsten_ore", ConstantInt.of(0), Blocks.IRON_ORE);
    public static final DeferredBlock<Block> AMBER_ORE = registerOre("amber_ore", UniformInt.of(2, 5), Blocks.LAPIS_ORE);
    public static final DeferredBlock<Block> LABRADORITE_ORE = registerOre("labradorite_ore", UniformInt.of(2, 5), Blocks.DIAMOND_ORE);
    public static final DeferredBlock<Block> THULITE_ORE = registerOre("thulite_ore", UniformInt.of(3, 7), Blocks.EMERALD_ORE);

    public static final DeferredBlock<Block> DEEPSLATE_BISMUTH_ORE = registerOre("deepslate_bismuth_ore", ConstantInt.of(0), Blocks.DEEPSLATE_COPPER_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE =  registerOre("deepslate_silver_ore", ConstantInt.of(0), Blocks.DEEPSLATE_GOLD_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_TUNGSTEN_ORE =  registerOre("deepslate_tungsten_ore", ConstantInt.of(0), Blocks.DEEPSLATE_IRON_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_AMBER_ORE =  registerOre("deepslate_amber_ore", UniformInt.of(2, 5), Blocks.DEEPSLATE_LAPIS_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_LABRADORITE_ORE =  registerOre("deepslate_labradorite_ore", UniformInt.of(2, 5), Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_THULITE_ORE =  registerOre("deepslate_thulite_ore", UniformInt.of(3, 7), Blocks.DEEPSLATE_EMERALD_ORE);

    public static final DeferredBlock<Block> FELDSPAR = register("feldspar", Blocks.STONE);
    public static final DeferredBlock<Block> FELDSPAR_BRICK = register("feldspar_brick", Blocks.STONE_BRICKS);
    public static final DeferredBlock<Block> POLISHED_FELDSPAR = register("feldspar_polished", Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<Block> CRACKED_FELDSPAR = register("cracked_feldspar", Blocks.STONE);
    public static final DeferredBlock<Block> CRACKED_FELDSPAR_BRICK = register("cracked_feldspar_brick", Blocks.STONE_BRICKS);
    public static final DeferredBlock<Block> CRACKED_POLISHED_FELDSPAR = register("cracked_feldspar_polished", Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<Block> CHISELED_FELDSPAR_BRICK = register("chiseled_feldspar_brick", Blocks.CHISELED_STONE_BRICKS);
    public static final DeferredBlock<Block> FELDSPAR_PILLAR = register("feldspar_pillar", RotatedPillarBlock::new, Blocks.POLISHED_ANDESITE);

    public static final DeferredBlock<WakestoneBlock> WAKESTONE = register("wakestone", WakestoneBlock::new);
    public static final DeferredBlock<ArcaneCraftingBlock> ARCANE_CRAFTING_BLOCK = registerBlockEntity("arcane_crafting_block", ArcaneCraftingBlock.class);

    public static final DeferredBlock<Block> CRACKED_DEEPSLATE_BRICK_SLAB = BLOCKS.registerBlock("cracked_deepslate_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS));
    public static final DeferredBlock<Block> CRACKED_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("cracked_deepslate_brick_stairs", () -> new StairBlock(Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS)));

    private static <BLOCK extends Block> DeferredBlock<BLOCK> registerBlockEntity(String id, Class<BLOCK> clazz)
    {
        DeferredBlock<BLOCK> deferredBlock = BLOCKS.register(id, () -> instantiateBlockEntity(clazz));

        SeidraItems.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        return deferredBlock;
    }

    private static DeferredBlock<Block> register(String id, Block block)
    {
        return register(id, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static DeferredBlock<Block> register(String id, BlockBehaviour.Properties properties)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.registerBlock(id, Block::new, properties);

        SeidraItems.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

        return deferredBlock;
    }
    
    private static DeferredBlock<Block> register(String id, Function<BlockBehaviour.Properties, Block> supplier, Block parent)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.register(id, () -> supplier.apply(BlockBehaviour.Properties.ofFullCopy(parent)));
        
        SeidraItems.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));
        
        return deferredBlock;
    }
    
    private static <BLOCK extends Block> DeferredBlock<BLOCK> register(String id, Supplier<BLOCK> supplier)
    {
        DeferredBlock<BLOCK> deferredBlock = BLOCKS.register(id, supplier);
        SeidraItems.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));
        
        return deferredBlock;
    }
    
    private static <BLOCK extends Block> DeferredBlock<Block> register(String id, Class<BLOCK> clazz, Object... params)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.register(id, () -> instantiateBlock(clazz, params));
        SeidraItems.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));
        
        return deferredBlock;
    }

    private static DeferredBlock<Block> registerOre(String id, IntProvider provider, Block parent)
    {
        return registerOre(id, provider, BlockBehaviour.Properties.ofFullCopy(parent));
    }

    private static DeferredBlock<Block> registerOre(String id, IntProvider provider, BlockBehaviour.Properties properties)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.register(id, () -> new DropExperienceBlock(provider, properties));

        SeidraItems.ITEMS.register(id, () -> new BlockItem(deferredBlock.get(), new Item.Properties()));

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
    
    private static <BLOCK> BLOCK instantiateBlock(Class<BLOCK> clazz, Object... params)
    {
        try
        {
            Class<?>[] paramTypes = new Class<?>[params.length];
            IntStream.range(0, params.length).forEach(i -> paramTypes[i] = params[i].getClass());
            
            return clazz.getConstructor(paramTypes).newInstance(params);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }
}
