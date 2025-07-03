package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.item.SeidraItems;
import com.lordskittles.seidra.common.tag.ItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeidraItemTagProvider extends ItemTagsProvider
{
    public SeidraItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTags, Seidra.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(ItemTags.BISMUTH_INGOT).add(SeidraItems.BISMUTH_INGOT.get());
        tag(ItemTags.SILVER_INGOT).add(SeidraItems.SILVER_INGOT.get());
        tag(ItemTags.TUNGSTEN_INGOT).add(SeidraItems.TUNGSTEN_INGOT.get());
        tag(ItemTags.RAW_BISMUTH).add(SeidraItems.RAW_BISMUTH.get());
        tag(ItemTags.RAW_SILVER).add(SeidraItems.RAW_SILVER.get());
        tag(ItemTags.RAW_TUNGSTEN).add(SeidraItems.RAW_TUNGSTEN.get());

        tag(ItemTags.AMBER).add(SeidraItems.AMBER_GEM.get());
        tag(ItemTags.LABRADORITE).add(SeidraItems.LABRADORITE_GEM.get());
        tag(ItemTags.THULITE).add(SeidraItems.THULITE_GEM.get());

        tag(ItemTags.BISMUTH_ORE).add(SeidraBlocks.BISMUTH_ORE.asItem(), SeidraBlocks.DEEPSLATE_BISMUTH_ORE.asItem());
        tag(ItemTags.SILVER_ORE).add(SeidraBlocks.SILVER_ORE.asItem(), SeidraBlocks.DEEPSLATE_SILVER_ORE.asItem());
        tag(ItemTags.TUNGSTEN_ORE).add(SeidraBlocks.TUNGSTEN_ORE.asItem(), SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE.asItem());
        tag(ItemTags.AMBER_ORE).add(SeidraBlocks.AMBER_ORE.asItem(), SeidraBlocks.DEEPSLATE_AMBER_ORE.asItem());
        tag(ItemTags.LABRADORITE_ORE).add(SeidraBlocks.LABRADORITE_ORE.asItem(), SeidraBlocks.DEEPSLATE_LABRADORITE_ORE.asItem());
        tag(ItemTags.THULITE_ORE).add(SeidraBlocks.THULITE_ORE.asItem(), SeidraBlocks.DEEPSLATE_THULITE_ORE.asItem());
    }
}
