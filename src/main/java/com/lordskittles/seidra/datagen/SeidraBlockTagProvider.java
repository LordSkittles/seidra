package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Constants;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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
				.add(SeidraBlocks.ASH_LOG.get(),
						SeidraBlocks.PINE_LOG.get(),
						SeidraBlocks.YEW_LOG.get(),
						SeidraBlocks.ASH_WOOD.get(),
						SeidraBlocks.PINE_WOOD.get(),
						SeidraBlocks.YEW_WOOD.get(),
						SeidraBlocks.STRIPPED_ASH_LOG.get(),
						SeidraBlocks.STRIPPED_PINE_LOG.get(),
						SeidraBlocks.STRIPPED_YEW_LOG.get(),
						SeidraBlocks.STRIPPED_ASH_WOOD.get(),
						SeidraBlocks.STRIPPED_PINE_WOOD.get(),
						SeidraBlocks.STRIPPED_YEW_WOOD.get(),
						SeidraBlocks.ASH_PLANKS.get(),
						SeidraBlocks.PINE_PLANKS.get(),
						SeidraBlocks.YEW_PLANKS.get()
				);

		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(SeidraBlocks.BISMUTH_ORE.get(),
						SeidraBlocks.SILVER_ORE.get(),
						SeidraBlocks.TUNGSTEN_ORE.get(),
						SeidraBlocks.AMBER_ORE.get(),
						SeidraBlocks.THULITE_ORE.get(),
						SeidraBlocks.LABRADORITE_ORE.get(),
						SeidraBlocks.DEEPSLATE_BISMUTH_ORE.get(),
						SeidraBlocks.DEEPSLATE_SILVER_ORE.get(),
						SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
						SeidraBlocks.DEEPSLATE_AMBER_ORE.get(),
						SeidraBlocks.DEEPSLATE_THULITE_ORE.get(),
						SeidraBlocks.DEEPSLATE_LABRADORITE_ORE.get(),
						SeidraBlocks.BISMUTH_BLOCK.get(),
						SeidraBlocks.SILVER_BLOCK.get(),
						SeidraBlocks.TUNGSTEN_BLOCK.get(),
						SeidraBlocks.AMBER_BLOCK.get(),
						SeidraBlocks.THULITE_BLOCK.get(),
						SeidraBlocks.LABRADORITE_BLOCK.get(),
						SeidraBlocks.WAKESTONE.get(),
						SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(),
						SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(),
						SeidraBlocks.FELDSPAR.get(),
						SeidraBlocks.FELDSPAR_BRICK.get(),
						SeidraBlocks.CHISELED_FELDSPAR_BRICK.get(),
						SeidraBlocks.CRACKED_FELDSPAR.get(),
						SeidraBlocks.CRACKED_FELDSPAR_BRICK.get(),
						SeidraBlocks.CRACKED_POLISHED_FELDSPAR.get(),
						SeidraBlocks.FELDSPAR_PILLAR.get()
				);

		tag(BlockTags.MINEABLE_WITH_HOE)
				.add(SeidraBlocks.ASH_LEAVES.get(),
						SeidraBlocks.PINE_LEAVES.get(),
						SeidraBlocks.YEW_LEAVES.get(),
						SeidraBlocks.ASH_SAPLING.get(),
						SeidraBlocks.PINE_SAPLING.get(),
						SeidraBlocks.YEW_SAPLING.get()
				);

		tag(BlockTags.LEAVES)
				.add(SeidraBlocks.ASH_LEAVES.get(),
						SeidraBlocks.PINE_LEAVES.get(),
						SeidraBlocks.YEW_LEAVES.get()
				);

		tag(BlockTags.SAPLINGS)
				.add(SeidraBlocks.ASH_SAPLING.get(),
						SeidraBlocks.PINE_SAPLING.get(),
						SeidraBlocks.YEW_SAPLING.get()
				);

		tag(BlockTags.NEEDS_IRON_TOOL)
				.add(SeidraBlocks.BISMUTH_ORE.get(),
						SeidraBlocks.SILVER_ORE.get(),
						SeidraBlocks.TUNGSTEN_ORE.get(),
						SeidraBlocks.AMBER_ORE.get(),
						SeidraBlocks.THULITE_ORE.get(),
						SeidraBlocks.LABRADORITE_ORE.get(),
						SeidraBlocks.DEEPSLATE_BISMUTH_ORE.get(),
						SeidraBlocks.DEEPSLATE_SILVER_ORE.get(),
						SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
						SeidraBlocks.DEEPSLATE_AMBER_ORE.get(),
						SeidraBlocks.DEEPSLATE_THULITE_ORE.get(),
						SeidraBlocks.DEEPSLATE_LABRADORITE_ORE.get(),
						SeidraBlocks.BISMUTH_BLOCK.get(),
						SeidraBlocks.SILVER_BLOCK.get(),
						SeidraBlocks.TUNGSTEN_BLOCK.get(),
						SeidraBlocks.AMBER_BLOCK.get(),
						SeidraBlocks.THULITE_BLOCK.get(),
						SeidraBlocks.LABRADORITE_BLOCK.get()
				);

		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("ores/bismuth"))).add(SeidraBlocks.BISMUTH_ORE.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("storage_blocks/bismuth"))).add(SeidraBlocks.BISMUTH_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("storage_blocks/raw_bismuth"))).add(SeidraBlocks.RAW_BISMUTH_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("ores/silver"))).add(SeidraBlocks.SILVER_ORE.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("storage_blocks/silver"))).add(SeidraBlocks.SILVER_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("storage_blocks/raw_silver"))).add(SeidraBlocks.RAW_SILVER_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("ores/tungsten"))).add(SeidraBlocks.TUNGSTEN_ORE.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("storage_blocks/tungsten"))).add(SeidraBlocks.TUNGSTEN_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, Constants.commonRes("storage_blocks/raw_tungsten"))).add(SeidraBlocks.RAW_TUNGSTEN_BLOCK.get());
	}
}
