package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.simple.WakestoneBlock;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SeidraBlockStateProvider extends BlockStateProvider
{
    public SeidraBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, Seidra.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        registerWakestone();
        
        axisBlockSubFolder(SeidraBlocks.ASH_LOG, "wood", "top");
        axisBlockSubFolder(SeidraBlocks.PINE_LOG, "wood", "top");
        axisBlockSubFolder(SeidraBlocks.YEW_LOG, "wood", "top");
        
        blockWithItemSubFolder(SeidraBlocks.ASH_WOOD, "wood", "wood", "log");
        blockWithItemSubFolder(SeidraBlocks.PINE_WOOD, "wood", "wood", "log");
        blockWithItemSubFolder(SeidraBlocks.YEW_WOOD, "wood", "wood", "log");
        
        axisBlockSubFolder(SeidraBlocks.STRIPPED_ASH_LOG, "wood", "top");
        axisBlockSubFolder(SeidraBlocks.STRIPPED_PINE_LOG, "wood", "top");
        axisBlockSubFolder(SeidraBlocks.STRIPPED_YEW_LOG, "wood", "top");
        
        blockWithItemSubFolder(SeidraBlocks.STRIPPED_ASH_WOOD, "wood", "wood", "log");
        blockWithItemSubFolder(SeidraBlocks.STRIPPED_PINE_WOOD, "wood", "wood", "log");
        blockWithItemSubFolder(SeidraBlocks.STRIPPED_YEW_WOOD, "wood", "wood", "log");
        
        blockWithItemSubFolder(SeidraBlocks.ASH_PLANKS, "wood");
        blockWithItemSubFolder(SeidraBlocks.PINE_PLANKS, "wood");
        blockWithItemSubFolder(SeidraBlocks.YEW_PLANKS, "wood");
        
        saplingBlockWithItem(SeidraBlocks.ASH_SAPLING);
        saplingBlockWithItem(SeidraBlocks.PINE_SAPLING);
        saplingBlockWithItem(SeidraBlocks.YEW_SAPLING);
        
        blockWithItemSubFolder(SeidraBlocks.ASH_LEAVES, "plants");
        blockWithItemSubFolder(SeidraBlocks.PINE_LEAVES, "plants");
        blockWithItemSubFolder(SeidraBlocks.YEW_LEAVES, "plants");
        
        blockWithItemSubFolder(SeidraBlocks.BISMUTH_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.SILVER_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.TUNGSTEN_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.AMBER_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.LABRADORITE_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.THULITE_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.RAW_BISMUTH_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.RAW_SILVER_BLOCK, "ores");
        blockWithItemSubFolder(SeidraBlocks.RAW_TUNGSTEN_BLOCK, "ores");
        
        blockWithItemSubFolder(SeidraBlocks.BISMUTH_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.SILVER_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.TUNGSTEN_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.AMBER_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.LABRADORITE_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.THULITE_ORE, "ores");
        
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_BISMUTH_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_SILVER_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_AMBER_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_LABRADORITE_ORE, "ores");
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_THULITE_ORE, "ores");
        
        blockWithItemSubFolder(SeidraBlocks.FELDSPAR, "stone");
        blockWithItemSubFolder(SeidraBlocks.FELDSPAR_BRICK, "stone");
        blockWithItemSubFolder(SeidraBlocks.POLISHED_FELDSPAR, "stone");
        blockWithItemSubFolder(SeidraBlocks.CRACKED_FELDSPAR, "stone");
        blockWithItemSubFolder(SeidraBlocks.CRACKED_FELDSPAR_BRICK, "stone");
        blockWithItemSubFolder(SeidraBlocks.CRACKED_POLISHED_FELDSPAR, "stone");
        blockWithItemSubFolder(SeidraBlocks.CHISELED_FELDSPAR_BRICK, "stone");
        axisBlockSubFolder(SeidraBlocks.FELDSPAR_PILLAR, "stone", "top");
        
        blockWithItem(SeidraBlocks.ARCANE_CRAFTING_BLOCK);

        ResourceLocation crackedDeepslateBricks = ResourceLocation.fromNamespaceAndPath("minecraft", "block/cracked_deepslate_bricks");

        stairsBlock((StairBlock) SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), crackedDeepslateBricks);
        slabBlock((SlabBlock) SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), crackedDeepslateBricks, crackedDeepslateBricks);
        blockItem(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);
        blockItem(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);
    }

    public void registerWakestone()
    {
        ResourceLocation dormantWakestoneSide = ResourceLocation.fromNamespaceAndPath(
                Seidra.MODID, "block/stone/wakestone_pillar"
        );
        ResourceLocation activeWakestoneSide = ResourceLocation.fromNamespaceAndPath(
                Seidra.MODID, "block/stone/activated_wakestone_pillar"
        );
        ResourceLocation wakestoneEnd = ResourceLocation.fromNamespaceAndPath(
                Seidra.MODID, "block/stone/wakestone_pillar_end"
        );

        ModelFile dormantVertical = this.models().cubeColumn(
                "dormant_wakestone", dormantWakestoneSide, wakestoneEnd
        );
        ModelFile dormantHorizontal = this.models().cubeColumnHorizontal(
                "dormant_wakestone", dormantWakestoneSide, wakestoneEnd
        );

        ModelFile activeVertical = this.models().cubeColumn(
                "active_wakestone", activeWakestoneSide, wakestoneEnd
        );
        ModelFile activeHorizontal = this.models().cubeColumnHorizontal(
                "active_wakestone", activeWakestoneSide, wakestoneEnd
        );

        wakestoneState(false, Direction.Axis.Y).modelForState().modelFile(dormantVertical).addModel();
        wakestoneState(true, Direction.Axis.Y).modelForState().modelFile(activeVertical).addModel();
        wakestoneState(false, Direction.Axis.X).modelForState().modelFile(dormantHorizontal).rotationX(90).rotationY(90).addModel();
        wakestoneState(true, Direction.Axis.X).modelForState().modelFile(activeHorizontal).rotationX(90).rotationY(90).addModel();
        wakestoneState(false, Direction.Axis.Z).modelForState().modelFile(dormantHorizontal).rotationX(90).addModel();
        wakestoneState(true, Direction.Axis.Z).modelForState().modelFile(activeHorizontal).rotationX(90).addModel();

        simpleBlockItem(SeidraBlocks.WAKESTONE.get(), dormantVertical);
    }

    public VariantBlockStateBuilder.PartialBlockstate wakestoneState(boolean active, Direction.Axis axis)
    {
        return this.getVariantBuilder(SeidraBlocks.WAKESTONE.get()).partialState()
            .with(RotatedPillarBlock.AXIS, axis).with(WakestoneBlock.ACTIVE, active);
    }

    public void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    public void saplingBlockWithItem(DeferredBlock<?> deferredBlock)
    {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                deferredBlock.getId().getNamespace(), "block/plants/" + deferredBlock.getId().getPath()
        );

        BlockModelBuilder blockModel = this.models().cross(deferredBlock.getId().getPath(), location).renderType("cutout");
        simpleBlock(deferredBlock.get(), blockModel);
    }

    public void blockWithItemSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAllSubFolder(deferredBlock, subFolder));
    }

    public void blockWithItemSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String toReplace, String replacement)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAllSubFolder(deferredBlock, subFolder, toReplace, replacement));
    }

    public ModelFile cubeAllSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        return cubeAllSubFolder(deferredBlock, subFolder, "", "");
    }

    public ModelFile cubeAllSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String toReplace, String replacement)
    {
        ResourceLocation blockId = deferredBlock.getId();
        
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                blockId.getNamespace(), "block/" + subFolder + "/" + blockId.getPath().replace(toReplace, replacement)
        );

        return this.models().cubeAll(deferredBlock.getId().getPath(), location);
    }

    public void axisBlockSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        axisBlockSubFolder(deferredBlock, subFolder, "");
    }

    public void axisBlockSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String endName)
    {
        axisBlockSubFolder(deferredBlock, subFolder, endName, "", "");
    }

    public void axisBlockSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String endName, String toReplace, String replacement)
    {
        ResourceLocation blockId = deferredBlock.getId();

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                blockId.getNamespace(), "block/" + subFolder + "/" + blockId.getPath().replace(toReplace, replacement)
        );

        ResourceLocation end = !endName.isEmpty() ? extend(location, "_" + endName) : location;

        axisBlock(((RotatedPillarBlock) deferredBlock.get()),
                  this.models().cubeColumn(blockId.getPath(), location, end),
                  this.models().cubeColumnHorizontal(blockId.getPath(), location, end)
        );

        simpleBlockItem(deferredBlock.get(), this.models().cubeColumn(blockId.getPath(), location, end));
    }
    
    private void blockItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(Seidra.MODID + ":block/" + deferredBlock.getId().getPath()));
    }

    public ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        String namespace = rl.getNamespace();
        String path = rl.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
