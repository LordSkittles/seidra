package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.functional.ArcaneCraftingBlock;
import com.lordskittles.seidra.common.block.simple.WakestoneBlock;
import com.lordskittles.seidra.common.item.SeidraItems;
import com.lordskittles.seidra.common.worldgen.tree.SeidraTreeGrowers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static com.lordskittles.seidra.Constants.*;

public class SeidraBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Seidra.MODID);

    public static final DeferredBlock<Block> ASH_LOG = register(buildName(Types.ASH, Suffixes.LOG), RotatedPillarBlock::new, Blocks.OAK_LOG);
    public static final DeferredBlock<Block> PINE_LOG = register(buildName(Types.PINE, Suffixes.LOG), RotatedPillarBlock::new, Blocks.OAK_LOG);
    public static final DeferredBlock<Block> YEW_LOG = register(buildName(Types.YEW, Suffixes.LOG), RotatedPillarBlock::new, Blocks.OAK_LOG);

    public static final DeferredBlock<Block> ASH_WOOD = register(buildName(Types.ASH, Suffixes.WOOD), Blocks.OAK_WOOD);
    public static final DeferredBlock<Block> PINE_WOOD = register(buildName(Types.PINE, Suffixes.WOOD), Blocks.OAK_WOOD);
    public static final DeferredBlock<Block> YEW_WOOD = register(buildName(Types.YEW, Suffixes.WOOD), Blocks.OAK_WOOD);

    public static final DeferredBlock<Block> STRIPPED_ASH_LOG = register(buildName(Prefixes.STRIPPED, Types.ASH, Suffixes.LOG), RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);
    public static final DeferredBlock<Block> STRIPPED_PINE_LOG = register(buildName(Prefixes.STRIPPED, Types.PINE, Suffixes.LOG), RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);
    public static final DeferredBlock<Block> STRIPPED_YEW_LOG = register(buildName(Prefixes.STRIPPED, Types.YEW, Suffixes.LOG), RotatedPillarBlock::new, Blocks.STRIPPED_OAK_LOG);

    public static final DeferredBlock<Block> STRIPPED_ASH_WOOD = register(buildName(Prefixes.STRIPPED, Types.ASH, Suffixes.WOOD), Blocks.STRIPPED_OAK_WOOD);
    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD = register(buildName(Prefixes.STRIPPED, Types.PINE, Suffixes.WOOD), Blocks.STRIPPED_OAK_WOOD);
    public static final DeferredBlock<Block> STRIPPED_YEW_WOOD = register(buildName(Prefixes.STRIPPED, Types.YEW, Suffixes.WOOD), Blocks.STRIPPED_OAK_WOOD);

    public static final DeferredBlock<Block> ASH_PLANKS = register(buildName(Types.ASH, Suffixes.PLANKS), Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> PINE_PLANKS = register(buildName(Types.PINE, Suffixes.PLANKS), Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> YEW_PLANKS = register(buildName(Types.YEW, Suffixes.PLANKS), Blocks.OAK_PLANKS);

    public static final DeferredBlock<Block> ASH_SAPLING = register(buildName(Types.ASH, Suffixes.SAPLING), SaplingBlock.class, SeidraTreeGrowers.ASH, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> PINE_SAPLING = register(buildName(Types.PINE, Suffixes.SAPLING), SaplingBlock.class, SeidraTreeGrowers.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> YEW_SAPLING = register(buildName(Types.YEW, Suffixes.SAPLING), SaplingBlock.class, SeidraTreeGrowers.YEW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> ASH_LEAVES = register(buildName(Types.ASH, Suffixes.LEAVES), LeavesBlock::new, Blocks.OAK_LEAVES);
    public static final DeferredBlock<Block> PINE_LEAVES = register(buildName(Types.PINE, Suffixes.LEAVES), LeavesBlock::new, Blocks.OAK_LEAVES);
    public static final DeferredBlock<Block> YEW_LEAVES = register(buildName(Types.YEW, Suffixes.LEAVES), LeavesBlock::new, Blocks.OAK_LEAVES);

    public static final DeferredBlock<Block> ASH_STAIRS = registerBlock(buildName(Types.ASH, Suffixes.STAIRS), () -> new StairBlock(ASH_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get())));
    public static final DeferredBlock<Block> PINE_STAIRS = registerBlock(buildName(Types.PINE, Suffixes.STAIRS), () -> new StairBlock(PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get())));
    public static final DeferredBlock<Block> YEW_STAIRS = registerBlock(buildName(Types.YEW, Suffixes.STAIRS), () -> new StairBlock(YEW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(YEW_PLANKS.get())));

    public static final DeferredBlock<Block> ASH_SLAB = registerBlock(buildName(Types.ASH, Suffixes.SLAB), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get())));
    public static final DeferredBlock<Block> PINE_SLAB = registerBlock(buildName(Types.PINE, Suffixes.SLAB), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get())));
    public static final DeferredBlock<Block> YEW_SLAB = registerBlock(buildName(Types.YEW, Suffixes.SLAB), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(YEW_PLANKS.get())));

    public static final DeferredBlock<Block> ASH_FENCE = registerBlock(buildName(Types.ASH, Suffixes.FENCE), () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get())));
    public static final DeferredBlock<Block> PINE_FENCE = registerBlock(buildName(Types.PINE, Suffixes.FENCE), () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get())));
    public static final DeferredBlock<Block> YEW_FENCE = registerBlock(buildName(Types.YEW, Suffixes.FENCE), () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(YEW_PLANKS.get())));

    public static final DeferredBlock<Block> ASH_FENCE_GATE = registerBlock(buildName(Types.ASH, Suffixes.FENCE_GATE), () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<Block> PINE_FENCE_GATE = registerBlock(buildName(Types.PINE, Suffixes.FENCE_GATE), () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<Block> YEW_FENCE_GATE = registerBlock(buildName(Types.YEW, Suffixes.FENCE_GATE), () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final DeferredBlock<Block> ASH_BUTTON = registerBlock(buildName(Types.ASH, Suffixes.BUTTON), () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get()).noCollission()));
    public static final DeferredBlock<Block> PINE_BUTTON = registerBlock(buildName(Types.PINE, Suffixes.BUTTON), () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get()).noCollission()));
    public static final DeferredBlock<Block> YEW_BUTTON = registerBlock(buildName(Types.YEW, Suffixes.BUTTON), () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get()).noCollission()));

    public static final DeferredBlock<Block> ASH_PRESSURE_PLATE = registerBlock(buildName(Types.ASH, Suffixes.PRESSURE_PLATE), () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get())));
    public static final DeferredBlock<Block> PINE_PRESSURE_PLATE = registerBlock(buildName(Types.PINE, Suffixes.PRESSURE_PLATE), () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get())));
    public static final DeferredBlock<Block> YEW_PRESSURE_PLATE = registerBlock(buildName(Types.YEW, Suffixes.PRESSURE_PLATE), () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(ASH_PLANKS.get())));

    public static final DeferredBlock<Block> BISMUTH_BLOCK = register(buildName(Types.BISMUTH, Groups.BLOCK), Blocks.COPPER_BLOCK);
    public static final DeferredBlock<Block> SILVER_BLOCK = register(buildName(Types.SILVER, Groups.BLOCK), Blocks.GOLD_BLOCK);
    public static final DeferredBlock<Block> TUNGSTEN_BLOCK = register(buildName(Types.TUNGSTEN, Groups.BLOCK), Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> RAW_BISMUTH_BLOCK = register(buildName(Prefixes.RAW, Types.BISMUTH, Groups.BLOCK), Blocks.RAW_COPPER_BLOCK);
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = register(buildName(Prefixes.RAW, Types.SILVER, Groups.BLOCK), Blocks.RAW_GOLD_BLOCK);
    public static final DeferredBlock<Block> RAW_TUNGSTEN_BLOCK = register(buildName(Prefixes.RAW, Types.TUNGSTEN, Groups.BLOCK), Blocks.RAW_IRON_BLOCK);
    public static final DeferredBlock<Block> AMBER_BLOCK = register(buildName(Types.AMBER, Groups.BLOCK), Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<Block> LABRADORITE_BLOCK = register(buildName(Types.LABRADORITE, Groups.BLOCK), Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<Block> THULITE_BLOCK = register(buildName(Types.THULITE, Groups.BLOCK), Blocks.DIAMOND_BLOCK);

    public static final DeferredBlock<Block> BISMUTH_ORE = registerOre(buildName(Types.BISMUTH, Suffixes.ORE), ConstantInt.of(0), Blocks.COPPER_ORE);
    public static final DeferredBlock<Block> SILVER_ORE = registerOre(buildName(Types.SILVER, Suffixes.ORE), ConstantInt.of(0), Blocks.GOLD_ORE);
    public static final DeferredBlock<Block> TUNGSTEN_ORE = registerOre(buildName(Types.TUNGSTEN, Suffixes.ORE), ConstantInt.of(0), Blocks.IRON_ORE);
    public static final DeferredBlock<Block> AMBER_ORE = registerOre(buildName(Types.AMBER, Suffixes.ORE), UniformInt.of(2, 5), Blocks.LAPIS_ORE);
    public static final DeferredBlock<Block> LABRADORITE_ORE = registerOre(buildName(Types.LABRADORITE, Suffixes.ORE), UniformInt.of(2, 5), Blocks.DIAMOND_ORE);
    public static final DeferredBlock<Block> THULITE_ORE = registerOre(buildName(Types.THULITE, Suffixes.ORE), UniformInt.of(3, 7), Blocks.EMERALD_ORE);

    public static final DeferredBlock<Block> DEEPSLATE_BISMUTH_ORE = registerOre(buildName(Prefixes.DEEPSLATE, Types.BISMUTH, Suffixes.ORE), ConstantInt.of(0), Blocks.DEEPSLATE_COPPER_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerOre(buildName(Prefixes.DEEPSLATE, Types.SILVER, Suffixes.ORE), ConstantInt.of(0), Blocks.DEEPSLATE_GOLD_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_TUNGSTEN_ORE = registerOre(buildName(Prefixes.DEEPSLATE, Types.TUNGSTEN, Suffixes.ORE), ConstantInt.of(0), Blocks.DEEPSLATE_IRON_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_AMBER_ORE = registerOre(buildName(Prefixes.DEEPSLATE, Types.AMBER, Suffixes.ORE), UniformInt.of(2, 5), Blocks.DEEPSLATE_LAPIS_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_LABRADORITE_ORE = registerOre(buildName(Prefixes.DEEPSLATE, Types.LABRADORITE, Suffixes.ORE), UniformInt.of(2, 5), Blocks.DEEPSLATE_DIAMOND_ORE);
    public static final DeferredBlock<Block> DEEPSLATE_THULITE_ORE = registerOre(buildName(Prefixes.DEEPSLATE, Types.THULITE, Suffixes.ORE), UniformInt.of(3, 7), Blocks.DEEPSLATE_EMERALD_ORE);

    public static final DeferredBlock<Block> FELDSPAR = register(buildName(Types.FELDSPAR), Blocks.STONE);
    public static final DeferredBlock<Block> FELDSPAR_BRICK = register(buildName(Types.FELDSPAR, Suffixes.BRICK), Blocks.STONE_BRICKS);
    public static final DeferredBlock<Block> POLISHED_FELDSPAR = register(buildName(Types.FELDSPAR, Suffixes.POLISHED), Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<Block> CRACKED_FELDSPAR = register(buildName(Prefixes.CRACKED, Types.FELDSPAR), Blocks.STONE);
    public static final DeferredBlock<Block> CRACKED_FELDSPAR_BRICK = register(buildName(Prefixes.CRACKED, Types.FELDSPAR, Suffixes.BRICK), Blocks.STONE_BRICKS);
    public static final DeferredBlock<Block> CRACKED_POLISHED_FELDSPAR = register(buildName(Prefixes.CRACKED, Types.FELDSPAR, Suffixes.POLISHED), Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<Block> CHISELED_FELDSPAR_BRICK = register(buildName(Prefixes.CHISELED, Types.FELDSPAR, Suffixes.BRICK), Blocks.CHISELED_STONE_BRICKS);
    public static final DeferredBlock<Block> FELDSPAR_PILLAR = register(buildName(Types.FELDSPAR, Suffixes.PILLAR), RotatedPillarBlock::new, Blocks.POLISHED_ANDESITE);

    public static final DeferredBlock<Block> FELDSPAR_STAIRS = registerBlock(buildName(Types.FELDSPAR, Suffixes.STAIRS), () -> new StairBlock(FELDSPAR.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(FELDSPAR.get())));
    public static final DeferredBlock<Block> FELDSPAR_BRICK_STAIRS = registerBlock(buildName(Types.FELDSPAR, Suffixes.BRICK, Suffixes.STAIRS), () -> new StairBlock(FELDSPAR_BRICK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(FELDSPAR_BRICK.get())));
    public static final DeferredBlock<Block> POLISHED_FELDSPAR_STAIRS = registerBlock(buildName(Types.FELDSPAR, Suffixes.POLISHED, Suffixes.STAIRS), () -> new StairBlock(POLISHED_FELDSPAR.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_FELDSPAR.get())));

    public static final DeferredBlock<Block> FELDSPAR_SLAB = registerBlock(buildName(Types.FELDSPAR, Suffixes.SLAB), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(FELDSPAR.get())));
    public static final DeferredBlock<Block> FELDSPAR_BRICK_SLAB = registerBlock(buildName(Types.FELDSPAR, Suffixes.BRICK, Suffixes.SLAB), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(FELDSPAR_BRICK.get())));
    public static final DeferredBlock<Block> POLISHED_FELDSPAR_SLAB = registerBlock(buildName(Types.FELDSPAR, Suffixes.POLISHED, Suffixes.SLAB), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_FELDSPAR.get())));

    public static final DeferredBlock<Block> FELDSPAR_WALL = registerBlock(buildName(Types.FELDSPAR, Suffixes.WALL), () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(FELDSPAR.get())));
    public static final DeferredBlock<Block> FELDSPAR_BRICK_WALL = registerBlock(buildName(Types.FELDSPAR, Suffixes.BRICK, Suffixes.WALL), () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(FELDSPAR_BRICK.get())));
    public static final DeferredBlock<Block> POLISHED_FELDSPAR_WALL = registerBlock(buildName(Types.FELDSPAR, Suffixes.POLISHED, Suffixes.WALL), () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_FELDSPAR.get())));

    public static final DeferredBlock<Block> FELDSPAR_PRESSURE_PLATE = registerBlock(buildName(Types.FELDSPAR, Suffixes.PRESSURE_PLATE), () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(FELDSPAR.get())));
    public static final DeferredBlock<Block> FELDSPAR_BUTTON = registerBlock(buildName(Types.FELDSPAR, Suffixes.BUTTON), () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(FELDSPAR.get()).noCollission()));

    public static final DeferredBlock<WakestoneBlock> WAKESTONE = register(buildName(Types.WAKESTONE), WakestoneBlock::new);
    public static final DeferredBlock<ArcaneCraftingBlock> ARCANE_CRAFTING_BLOCK = registerBlockEntity(buildName(Types.ARCANE_CRAFTING, Groups.BLOCK), ArcaneCraftingBlock.class);

    public static final DeferredBlock<Block> CRACKED_DEEPSLATE_BRICK_SLAB = BLOCKS.registerBlock(buildName(Prefixes.CRACKED, Prefixes.DEEPSLATE, Suffixes.BRICK, Suffixes.SLAB), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS));
    public static final DeferredBlock<Block> CRACKED_DEEPSLATE_BRICK_STAIRS = BLOCKS.register(buildName(Prefixes.CRACKED, Prefixes.DEEPSLATE, Suffixes.BRICK, Suffixes.STAIRS), () -> new StairBlock(Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS)));

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

    private static <T extends Block> DeferredBlock<T> registerBlock(String id, Supplier<T> block)
    {
        DeferredBlock<T> deferredBlock = BLOCKS.register(id, block);

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
