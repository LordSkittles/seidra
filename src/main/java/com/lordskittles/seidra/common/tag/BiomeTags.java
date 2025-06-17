package com.lordskittles.seidra.common.tag;

import com.lordskittles.seidra.Seidra;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeTags
{
	public static final TagKey<Biome> IS_MOUNTAINOUS = create("is_mountainous");
	public static final TagKey<Biome> IS_COLD = create("is_cold");
	public static final TagKey<Biome> IS_VOLCANIC = create("is_volcanic");
	public static final TagKey<Biome> IS_EXPOSED_CLIFFSIDE = create("is_exposed_cliffside");
	public static final TagKey<Biome> IS_FLORAL = create("is_floral");
	public static final TagKey<Biome> IS_MYSTIC_CAVE = create("is_mystic_cave");

	private static TagKey<Biome> create(String name) {
		return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, name));
	}
}
