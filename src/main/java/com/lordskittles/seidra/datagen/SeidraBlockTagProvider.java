package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeidraBlockTagProvider extends BlockTagsProvider
{
    public SeidraBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Seidra.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Blocks.JUNIPER_LOG.get())
                .add(Blocks.PINE_LOG.get())
                .add(Blocks.YEW_LOG.get())
                .add(Blocks.JUNIPER_WOOD.get())
                .add(Blocks.PINE_WOOD.get())
                .add(Blocks.YEW_WOOD.get())
                .add(Blocks.STRIPPED_JUNIPER_LOG.get())
                .add(Blocks.STRIPPED_PINE_LOG.get())
                .add(Blocks.STRIPPED_YEW_LOG.get())
                .add(Blocks.STRIPPED_JUNIPER_WOOD.get())
                .add(Blocks.STRIPPED_PINE_WOOD.get())
                .add(Blocks.STRIPPED_YEW_WOOD.get())
                .add(Blocks.JUNIPER_PLANKS.get())
                .add(Blocks.PINE_PLANKS.get())
                .add(Blocks.YEW_PLANKS.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.BISMUTH_ORE.get())
                .add(Blocks.COBALT_ORE.get())
                .add(Blocks.TUNGSTEN_ORE.get())
                .add(Blocks.IOLITE_ORE.get())
                .add(Blocks.THULITE_ORE.get())
                .add(Blocks.ZOISITE_ORE.get())
                .add(Blocks.DEEPSLATE_BISMUTH_ORE.get())
                .add(Blocks.DEEPSLATE_COBALT_ORE.get())
                .add(Blocks.DEEPSLATE_TUNGSTEN_ORE.get())
                .add(Blocks.DEEPSLATE_IOLITE_ORE.get())
                .add(Blocks.DEEPSLATE_THULITE_ORE.get())
                .add(Blocks.DEEPSLATE_ZOISITE_ORE.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(Blocks.JUNIPER_LEAVES.get())
                .add(Blocks.PINE_LEAVES.get())
                .add(Blocks.YEW_LEAVES.get());

        tag(BlockTags.LEAVES)
                .add(Blocks.JUNIPER_LEAVES.get())
                .add(Blocks.PINE_LEAVES.get())
                .add(Blocks.YEW_LEAVES.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.BISMUTH_ORE.get())
                .add(Blocks.COBALT_ORE.get())
                .add(Blocks.TUNGSTEN_ORE.get())
                .add(Blocks.IOLITE_ORE.get())
                .add(Blocks.THULITE_ORE.get())
                .add(Blocks.ZOISITE_ORE.get())
                .add(Blocks.DEEPSLATE_BISMUTH_ORE.get())
                .add(Blocks.DEEPSLATE_COBALT_ORE.get())
                .add(Blocks.DEEPSLATE_TUNGSTEN_ORE.get())
                .add(Blocks.DEEPSLATE_IOLITE_ORE.get())
                .add(Blocks.DEEPSLATE_THULITE_ORE.get())
                .add(Blocks.DEEPSLATE_ZOISITE_ORE.get());
    }
}
