package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.tag.BiomeTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class SeidraBiomeModifiers
{
	public static final ResourceKey<BiomeModifier> ADD_JUNIPER_TREE_KEY = registerKey("add_juniper_tree");
	public static final ResourceKey<BiomeModifier> ADD_YEW_TREE_KEY = registerKey("add_yew_tree");
	public static final ResourceKey<BiomeModifier> ADD_PINE_TREE_KEY = registerKey("add_pine_tree");

	public static final ResourceKey<BiomeModifier> ADD_BISMUTH_ORE_KEY = registerKey("add_bismuth_ore");
	public static final ResourceKey<BiomeModifier> ADD_COBALT_ORE_KEY = registerKey("add_cobalt_ore");
	public static final ResourceKey<BiomeModifier> ADD_TUNGSTEN_ORE_KEY = registerKey("add_tungsten_ore");

	public static final ResourceKey<BiomeModifier> ADD_IOLITE_ORE_KEY = registerKey("add_iolite_ore");
	public static final ResourceKey<BiomeModifier> ADD_THULITE_ORE_KEY = registerKey("add_thulite_ore");
	public static final ResourceKey<BiomeModifier> ADD_ZOISITE_ORE_KEY = registerKey("add_zoisite_ore");

	public static void bootstrap(BootstrapContext<BiomeModifier> context)
	{
		var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		var biomes = context.lookup(Registries.BIOME);

		registerOres(context, placedFeatures, biomes);
		registerTrees(context, placedFeatures, biomes);
	}

	private static ResourceKey<BiomeModifier> registerKey(String name)
	{
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, name));
	}

	private static void registerTrees(BootstrapContext<BiomeModifier> context, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<Biome> biomes)
	{
		context.register(ADD_JUNIPER_TREE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(net.minecraft.tags.BiomeTags.IS_SAVANNA),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.JUNIPER_TREE_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION
				)
		);

		context.register(ADD_PINE_TREE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(net.minecraft.tags.BiomeTags.IS_TAIGA),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.PINE_TREE_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION
				)
		);

		context.register(ADD_YEW_TREE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(net.minecraft.tags.BiomeTags.IS_FOREST),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.YEW_TREE_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION
				)
		);
	}

	private static void registerOres(BootstrapContext<BiomeModifier> context, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<Biome> biomes)
	{
		context.register(ADD_BISMUTH_ORE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_MOUNTAINOUS),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.BISMUTH_ORE_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
				)
		);

		context.register(ADD_COBALT_ORE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_COLD),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.COBALT_ORE_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
				)
		);

		context.register(ADD_TUNGSTEN_ORE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_VOLCANIC),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.TUNGSTEN_ORE_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
				)
		);

		context.register(ADD_IOLITE_ORE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_EXPOSED_CLIFFSIDE),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.IOLITE_ORE_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
				)
		);

		context.register(ADD_THULITE_ORE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_FLORAL),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.THULITE_ORE_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
				)
		);

		context.register(ADD_ZOISITE_ORE_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_MYSTIC_CAVE),
						HolderSet.direct(placedFeatures.getOrThrow(SeidraPlacedFeatures.ZOISITE_ORE_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
				)
		);
	}
}
