package com.lordskittles.seidra.datagen;

import api.lordskittles.seidra.interfaces.IBlockStateDatagenProvider;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.simple.SeidraColumnBlock;
import com.lordskittles.seidra.common.block.simple.WakestoneBlock;
import com.lordskittles.seidra.common.registries.SeidraBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
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
        SeidraBlocks.BLOCKS.getEntries().forEach(block -> {
            //noinspection rawtypes
            if(block.get() instanceof IBlockStateDatagenProvider provider)
            {
                provider.generate(this).run();
            }
        });

        saplingBlockWithItem(SeidraBlocks.ASH_SAPLING);
        saplingBlockWithItem(SeidraBlocks.PINE_SAPLING);
        saplingBlockWithItem(SeidraBlocks.YEW_SAPLING);

        ResourceLocation crackedDeepslateBricks = ResourceLocation.fromNamespaceAndPath("minecraft", "block/cracked_deepslate_bricks");

        stairsBlock((StairBlock) SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), crackedDeepslateBricks);
        slabBlock((SlabBlock) SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), crackedDeepslateBricks, crackedDeepslateBricks);
        simpleBlockItem(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), this.models().slab(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.getId().getPath(), crackedDeepslateBricks, crackedDeepslateBricks, crackedDeepslateBricks));
        simpleBlockItem(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), this.models().stairs(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.getId().getPath(), crackedDeepslateBricks, crackedDeepslateBricks, crackedDeepslateBricks));
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

    public void saplingBlockWithItem(DeferredBlock<Block> deferredBlock)
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

    public ModelFile cubeAllSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                deferredBlock.getId().getNamespace(), "block/" + subFolder + "/" + deferredBlock.getId().getPath()
        );

        return this.models().cubeAll(deferredBlock.getId().getPath(), location);
    }

    public void axisBlockSubFolder(SeidraColumnBlock deferredBlock, String subFolder)
    {
        axisBlockSubFolder(deferredBlock, subFolder, "");
    }

    public void axisBlockSubFolder(SeidraColumnBlock deferredBlock, String subFolder, String endName)
    {
        axisBlockSubFolder(deferredBlock, subFolder, endName, "", "");
    }

    public void axisBlockSubFolder(SeidraColumnBlock deferredBlock, String subFolder, String endName, String toReplace, String replacement)
    {
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(deferredBlock);

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                blockId.getNamespace(), "block/" + subFolder + "/" + blockId.getPath().replace(toReplace, replacement)
        );

        ResourceLocation end = !endName.isEmpty() ? extend(location, "_" + endName) : location;

        axisBlock(deferredBlock,
                  this.models().cubeColumn(blockId.getPath(), location, end),
                  this.models().cubeColumnHorizontal(blockId.getPath(), location, end)
        );

        simpleBlockItem(deferredBlock, this.models().cubeColumn(blockId.getPath(), location, end));
    }

    public ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        String namespace = rl.getNamespace();
        String path = rl.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
