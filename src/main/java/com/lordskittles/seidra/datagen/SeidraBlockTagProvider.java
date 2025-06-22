package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
				.add(Blocks.ASH_LOG.get(),
						Blocks.PINE_LOG.get(),
						Blocks.YEW_LOG.get(),
						Blocks.ASH_WOOD.get(),
						Blocks.PINE_WOOD.get(),
						Blocks.YEW_WOOD.get(),
						Blocks.STRIPPED_ASH_LOG.get(),
						Blocks.STRIPPED_PINE_LOG.get(),
						Blocks.STRIPPED_YEW_LOG.get(),
						Blocks.STRIPPED_ASH_WOOD.get(),
						Blocks.STRIPPED_PINE_WOOD.get(),
						Blocks.STRIPPED_YEW_WOOD.get(),
						Blocks.ASH_PLANKS.get(),
						Blocks.PINE_PLANKS.get(),
						Blocks.YEW_PLANKS.get()
				);

		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(Blocks.BISMUTH_ORE.get(),
						Blocks.SILVER_ORE.get(),
						Blocks.TUNGSTEN_ORE.get(),
						Blocks.AMBER_ORE.get(),
						Blocks.THULITE_ORE.get(),
						Blocks.LABRADORITE_ORE.get(),
						Blocks.DEEPSLATE_BISMUTH_ORE.get(),
						Blocks.DEEPSLATE_SILVER_ORE.get(),
						Blocks.DEEPSLATE_TUNGSTEN_ORE.get(),
						Blocks.DEEPSLATE_AMBER_ORE.get(),
						Blocks.DEEPSLATE_THULITE_ORE.get(),
						Blocks.DEEPSLATE_LABRADORITE_ORE.get(),
						Blocks.BISMUTH_BLOCK.get(),
						Blocks.SILVER_BLOCK.get(),
						Blocks.TUNGSTEN_BLOCK.get(),
						Blocks.AMBER_BLOCK.get(),
						Blocks.THULITE_BLOCK.get(),
						Blocks.LABRADORITE_BLOCK.get(),
						Blocks.WAKESTONE.get(),
						Blocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(),
						Blocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get()
				);

		tag(BlockTags.MINEABLE_WITH_HOE)
				.add(Blocks.ASH_LEAVES.get(),
						Blocks.PINE_LEAVES.get(),
						Blocks.YEW_LEAVES.get(),
						Blocks.ASH_SAPLING.get(),
						Blocks.PINE_SAPLING.get(),
						Blocks.YEW_SAPLING.get()
				);

		tag(BlockTags.LEAVES)
				.add(Blocks.ASH_LEAVES.get(),
						Blocks.PINE_LEAVES.get(),
						Blocks.YEW_LEAVES.get()
				);

		tag(BlockTags.SAPLINGS)
				.add(Blocks.ASH_SAPLING.get(),
						Blocks.PINE_SAPLING.get(),
						Blocks.YEW_SAPLING.get()
				);

		tag(BlockTags.NEEDS_IRON_TOOL)
				.add(Blocks.BISMUTH_ORE.get(),
						Blocks.SILVER_ORE.get(),
						Blocks.TUNGSTEN_ORE.get(),
						Blocks.AMBER_ORE.get(),
						Blocks.THULITE_ORE.get(),
						Blocks.LABRADORITE_ORE.get(),
						Blocks.DEEPSLATE_BISMUTH_ORE.get(),
						Blocks.DEEPSLATE_SILVER_ORE.get(),
						Blocks.DEEPSLATE_TUNGSTEN_ORE.get(),
						Blocks.DEEPSLATE_AMBER_ORE.get(),
						Blocks.DEEPSLATE_THULITE_ORE.get(),
						Blocks.DEEPSLATE_LABRADORITE_ORE.get(),
						Blocks.BISMUTH_BLOCK.get(),
						Blocks.SILVER_BLOCK.get(),
						Blocks.TUNGSTEN_BLOCK.get(),
						Blocks.AMBER_BLOCK.get(),
						Blocks.THULITE_BLOCK.get(),
						Blocks.LABRADORITE_BLOCK.get()
				);

		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "ores/bismuth"))).add(Blocks.BISMUTH_ORE.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/bismuth"))).add(Blocks.BISMUTH_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_bismuth"))).add(Blocks.RAW_BISMUTH_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "ores/silver"))).add(Blocks.SILVER_ORE.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/silver"))).add(Blocks.SILVER_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_silver"))).add(Blocks.RAW_SILVER_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "ores/tungsten"))).add(Blocks.TUNGSTEN_ORE.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/tungsten"))).add(Blocks.TUNGSTEN_BLOCK.get());
		tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_tungsten"))).add(Blocks.RAW_TUNGSTEN_BLOCK.get());
	}
}
