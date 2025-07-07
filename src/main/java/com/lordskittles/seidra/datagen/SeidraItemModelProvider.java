package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.item.SeidraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.lordskittles.seidra.Constants.*;

public class SeidraItemModelProvider extends ItemModelProvider
{
    public SeidraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Seidra.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(SeidraItems.AMBER_GEM, Suffixes.GEM);
        simpleItem(SeidraItems.LABRADORITE_GEM, Suffixes.GEM);
        simpleItem(SeidraItems.THULITE_GEM, Suffixes.GEM);

        simpleItem(SeidraItems.BISMUTH_INGOT, Groups.METAL);
        simpleItem(SeidraItems.SILVER_INGOT, Groups.METAL);
        simpleItem(SeidraItems.TUNGSTEN_INGOT, Groups.METAL);

        simpleItem(SeidraItems.RAW_BISMUTH, Groups.METAL);
        simpleItem(SeidraItems.RAW_SILVER, Groups.METAL);
        simpleItem(SeidraItems.RAW_TUNGSTEN, Groups.METAL);

        saplingItem(SeidraBlocks.ASH_SAPLING);
        saplingItem(SeidraBlocks.PINE_SAPLING);
        saplingItem(SeidraBlocks.YEW_SAPLING);

        woodGroup(SeidraBlocks.ASH_FENCE, SeidraBlocks.ASH_BUTTON, SeidraBlocks.ASH_PLANKS);
        woodGroup(SeidraBlocks.PINE_FENCE, SeidraBlocks.PINE_BUTTON, SeidraBlocks.PINE_PLANKS);
        woodGroup(SeidraBlocks.YEW_FENCE, SeidraBlocks.YEW_BUTTON, SeidraBlocks.YEW_PLANKS);
    }

    private void saplingItem(DeferredBlock<?> item)
    {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")
        ).texture("layer0",
                modRes(buildName('/', Groups.BLOCK, Groups.PLANT, item.getId().getPath()))
        );
    }

    private void simpleItem(DeferredItem<?> item)
    {
        simpleItem(item, "");
    }

    private void simpleItem(DeferredItem<?> item, String subFolder)
    {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")
        ).texture("layer0",
                modRes("item/" + subFolder + "/" + item.getId().getPath())
        );
    }

    private void woodGroup(DeferredBlock<Block> fence, DeferredBlock<Block> button, DeferredBlock<Block> parentBlock)
    {
        buttonItem(button, parentBlock, "wood");
        fenceItem(fence, parentBlock, "wood");
    }

    private void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock)
    {
        buttonItem(block, baseBlock, "");
    }

    private void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock, String subFolder)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", modRes(buildName('/', Groups.BLOCK, subFolder, baseBlock.getId().getPath())));
    }

    private void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock)
    {
        this.fenceItem(block, baseBlock, "");
    }

    private void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock, String subFolder)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", modRes(buildName('/', Groups.BLOCK, subFolder, baseBlock.getId().getPath())));
    }

    private void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock)
    {
        wallItem(block, baseBlock, "");
    }

    private void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock, String subFolder)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modRes(buildName('/', Groups.BLOCK, subFolder, baseBlock.getId().getPath())));
    }

    private void handheldItem(DeferredItem<Item> item)
    {
        handheldItem(item, "");
    }

    private void handheldItem(DeferredItem<Item> item, String subFolder)
    {
        this.withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                modRes(buildName('/', Groups.ITEM, subFolder, item.getId().getPath()))
        );
    }
}
