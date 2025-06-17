package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.tag.BiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeidraBiomeTagProvider extends BiomeTagsProvider
{
	public SeidraBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, provider, Seidra.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider)
	{
		tag(BiomeTags.IS_MOUNTAINOUS).add(
				Biomes.WINDSWEPT_HILLS,
				Biomes.STONY_PEAKS,
				Biomes.SNOWY_SLOPES,
				Biomes.TAIGA
		);
		tag(BiomeTags.IS_COLD).add(
				Biomes.SNOWY_TAIGA,
				Biomes.GROVE,
				Biomes.FROZEN_PEAKS,
				Biomes.SNOWY_PLAINS
		);
		tag(BiomeTags.IS_VOLCANIC).add(
				Biomes.DEEP_DARK,
				Biomes.SAVANNA_PLATEAU,
				Biomes.STONY_PEAKS
		);
		tag(BiomeTags.IS_EXPOSED_CLIFFSIDE).add(
				Biomes.WINDSWEPT_GRAVELLY_HILLS,
				Biomes.MEADOW,
				Biomes.BEACH,
				Biomes.RIVER
		);
		tag(BiomeTags.IS_FLORAL).add(
				Biomes.FLOWER_FOREST,
				Biomes.TAIGA,
				Biomes.BIRCH_FOREST,
				Biomes.PLAINS
		);
		tag(BiomeTags.IS_MYSTIC_CAVE).add(
				Biomes.LUSH_CAVES,
				Biomes.DRIPSTONE_CAVES,
				Biomes.OLD_GROWTH_SPRUCE_TAIGA
		);
	}
}
