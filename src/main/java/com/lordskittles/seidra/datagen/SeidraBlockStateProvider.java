package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.blocks.SeidraColumnBlock;
import com.lordskittles.seidra.common.blocks.SeidraLogBlock;
import com.lordskittles.seidra.common.blocks.SeidraOreBlock;
import com.lordskittles.seidra.common.blocks.SeidraPlankBlock;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
        for (DeferredBlock<SeidraOreBlock> ore : Blocks.ORES)
        {
            blockWithItemSubFolder(ore, "ores");

            // add(ore.get(), block -> createOreDrop(ore.get(), ore.get().drop()));
        }

        for (DeferredBlock<SeidraOreBlock> ore : Blocks.DEEPSLATE_ORES)
        {
            blockWithItemSubFolder(ore, "ores");
        }

        for (DeferredBlock<SeidraLogBlock> log : Blocks.LOGS)
        {
            axisBlockSubFolder(log.get(), "wood", "top");
        }

        for (DeferredBlock<SeidraLogBlock> log : Blocks.STRIPPED_LOGS)
        {
            axisBlockSubFolder(log.get(), "wood", "top");
        }

        for (DeferredBlock<SeidraPlankBlock> plank : Blocks.PLANKS)
        {
            blockWithItemSubFolder(plank, "wood");
        }
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockWithItemSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAllSubFolder(deferredBlock, subFolder));
    }

    private ModelFile cubeAllSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                deferredBlock.getId().getNamespace(), "block/" + subFolder + "/" + deferredBlock.getId().getPath()
        );

        return this.models().cubeAll(deferredBlock.getId().getPath(), location);
    }

    private void axisBlockSubFolder(SeidraColumnBlock deferredBlock, String subFolder, String endName)
    {
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(deferredBlock);

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(
                blockId.getNamespace(), "block/" + subFolder + "/" + blockId.getPath()
        );

        ResourceLocation end = extend(location, "_" + endName);

        axisBlock(deferredBlock,
                  this.models().cubeColumn(blockId.getPath(), location, end),
                  this.models().cubeColumnHorizontal(blockId.getPath(), location, end)
        );

        simpleBlockItem(deferredBlock, this.models().cubeColumn(blockId.getPath(), location, end));
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        String namespace = rl.getNamespace();
        String path = rl.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
