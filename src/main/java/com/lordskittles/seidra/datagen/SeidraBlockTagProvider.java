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
				.add(Blocks.JUNIPER_LOG.get(),
						Blocks.PINE_LOG.get(),
						Blocks.YEW_LOG.get(),
						Blocks.JUNIPER_WOOD.get(),
						Blocks.PINE_WOOD.get(),
						Blocks.YEW_WOOD.get(),
						Blocks.STRIPPED_JUNIPER_LOG.get(),
						Blocks.STRIPPED_PINE_LOG.get(),
						Blocks.STRIPPED_YEW_LOG.get(),
						Blocks.STRIPPED_JUNIPER_WOOD.get(),
						Blocks.STRIPPED_PINE_WOOD.get(),
						Blocks.STRIPPED_YEW_WOOD.get(),
						Blocks.JUNIPER_PLANKS.get(),
						Blocks.PINE_PLANKS.get(),
						Blocks.YEW_PLANKS.get()
				);

		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(Blocks.BISMUTH_ORE.get(),
						Blocks.COBALT_ORE.get(),
						Blocks.TUNGSTEN_ORE.get(),
						Blocks.IOLITE_ORE.get(),
						Blocks.THULITE_ORE.get(),
						Blocks.ZOISITE_ORE.get(),
						Blocks.DEEPSLATE_BISMUTH_ORE.get(),
						Blocks.DEEPSLATE_COBALT_ORE.get(),
						Blocks.DEEPSLATE_TUNGSTEN_ORE.get(),
						Blocks.DEEPSLATE_IOLITE_ORE.get(),
						Blocks.DEEPSLATE_THULITE_ORE.get(),
						Blocks.DEEPSLATE_ZOISITE_ORE.get(),
						Blocks.BISMUTH_BLOCK.get(),
						Blocks.COBALT_BLOCK.get(),
						Blocks.TUNGSTEN_BLOCK.get(),
						Blocks.IOLITE_BLOCK.get(),
						Blocks.THULITE_BLOCK.get(),
						Blocks.ZOISITE_BLOCK.get(),
						Blocks.WAKESTONE.get(),
						Blocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(),
						Blocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get()
				);

		tag(BlockTags.MINEABLE_WITH_HOE)
				.add(Blocks.JUNIPER_LEAVES.get(),
						Blocks.PINE_LEAVES.get(),
						Blocks.YEW_LEAVES.get(),
						Blocks.JUNIPER_SAPLING.get(),
						Blocks.PINE_SAPLING.get(),
						Blocks.YEW_SAPLING.get()
				);

		tag(BlockTags.LEAVES)
				.add(Blocks.JUNIPER_LEAVES.get(),
						Blocks.PINE_LEAVES.get(),
						Blocks.YEW_LEAVES.get()
				);

		tag(BlockTags.SAPLINGS)
				.add(Blocks.JUNIPER_SAPLING.get(),
						Blocks.PINE_SAPLING.get(),
						Blocks.YEW_SAPLING.get()
				);

		tag(BlockTags.NEEDS_IRON_TOOL)
				.add(Blocks.BISMUTH_ORE.get(),
						Blocks.COBALT_ORE.get(),
						Blocks.TUNGSTEN_ORE.get(),
						Blocks.IOLITE_ORE.get(),
						Blocks.THULITE_ORE.get(),
						Blocks.ZOISITE_ORE.get(),
						Blocks.DEEPSLATE_BISMUTH_ORE.get(),
						Blocks.DEEPSLATE_COBALT_ORE.get(),
						Blocks.DEEPSLATE_TUNGSTEN_ORE.get(),
						Blocks.DEEPSLATE_IOLITE_ORE.get(),
						Blocks.DEEPSLATE_THULITE_ORE.get(),
						Blocks.DEEPSLATE_ZOISITE_ORE.get(),
						Blocks.BISMUTH_BLOCK.get(),
						Blocks.COBALT_BLOCK.get(),
						Blocks.TUNGSTEN_BLOCK.get(),
						Blocks.IOLITE_BLOCK.get(),
						Blocks.THULITE_BLOCK.get(),
						Blocks.ZOISITE_BLOCK.get()
				);
	}
}
