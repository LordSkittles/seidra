package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.Items;
import com.lordskittles.seidra.common.tag.ItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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
        tag(ItemTags.BISMUTH_INGOT).add(Items.BISMUTH_INGOT.get());
        tag(ItemTags.SILVER_INGOT).add(Items.SILVER_INGOT.get());
        tag(ItemTags.TUNGSTEN_INGOT).add(Items.TUNGSTEN_INGOT.get());
        tag(ItemTags.RAW_BISMUTH).add(Items.RAW_BISMUTH.get());
        tag(ItemTags.RAW_SILVER).add(Items.RAW_SILVER.get());
        tag(ItemTags.RAW_TUNGSTEN).add(Items.RAW_TUNGSTEN.get());

        tag(ItemTags.AMBER).add(Items.AMBER_GEM.get());
        tag(ItemTags.LABRADORITE).add(Items.LABRADORITE_GEM.get());
        tag(ItemTags.THULITE).add(Items.THULITE_GEM.get());

        tag(ItemTags.BISMUTH_ORE).add(Blocks.BISMUTH_ORE.asItem(), Blocks.DEEPSLATE_BISMUTH_ORE.asItem());
        tag(ItemTags.SILVER_ORE).add(Blocks.SILVER_ORE.asItem(), Blocks.DEEPSLATE_SILVER_ORE.asItem());
        tag(ItemTags.TUNGSTEN_ORE).add(Blocks.TUNGSTEN_ORE.asItem(), Blocks.DEEPSLATE_TUNGSTEN_ORE.asItem());
        tag(ItemTags.AMBER_ORE).add(Blocks.AMBER_ORE.asItem(), Blocks.DEEPSLATE_AMBER_ORE.asItem());
        tag(ItemTags.LABRADORITE_ORE).add(Blocks.LABRADORITE_ORE.asItem(), Blocks.DEEPSLATE_LABRADORITE_ORE.asItem());
        tag(ItemTags.THULITE_ORE).add(Blocks.THULITE_ORE.asItem(), Blocks.DEEPSLATE_THULITE_ORE.asItem());
    }
}
