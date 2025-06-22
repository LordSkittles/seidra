package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Items;
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
        tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/silver"))).add(Items.SILVER_INGOT.get());
        tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "raw_materials/silver"))).add(Items.RAW_SILVER.get());

        tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "gems/amber"))).add(Items.AMBER_GEM.get());
        tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "gems/labradorite"))).add(Items.LABRADORITE_GEM.get());
        tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "gems/thulite"))).add(Items.THULITE_GEM.get());
    }
}
