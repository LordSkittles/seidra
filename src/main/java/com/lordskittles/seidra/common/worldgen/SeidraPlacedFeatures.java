package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class SeidraPlacedFeatures
{
	public static final ResourceKey<PlacedFeature> ASH_TREE_KEY = registerKey("ash_tree");
	public static final ResourceKey<PlacedFeature> PINE_TREE_KEY = registerKey("pine_tree");
	public static final ResourceKey<PlacedFeature> YEW_TREE_KEY = registerKey("yew_tree");

	public static final ResourceKey<PlacedFeature> BISMUTH_ORE_KEY = registerKey("bismuth_ore");
	public static final ResourceKey<PlacedFeature> SILVER_ORE_KEY = registerKey("silver_ore");
	public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");

	public static final ResourceKey<PlacedFeature> AMBER_ORE_KEY = registerKey("amber_ore");
	public static final ResourceKey<PlacedFeature> LABRADORITE_ORE_KEY = registerKey("labradorite_ore");
	public static final ResourceKey<PlacedFeature> THULITE_ORE_KEY = registerKey("thulite_ore");

	public static final ResourceKey<PlacedFeature> FELDSPAR_KEY = registerKey("feldspar");

	public static void bootstrap(BootstrapContext<PlacedFeature> context)
	{
		var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		register(context, ASH_TREE_KEY, configuredFeatures.getOrThrow(SeidraConfiguredFeatures.ASH_TREE_KEY),
				VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100), Blocks.ASH_SAPLING.get())
		);
		register(context, PINE_TREE_KEY, configuredFeatures.getOrThrow(SeidraConfiguredFeatures.PINE_TREE_KEY),
				VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100), Blocks.PINE_SAPLING.get())
		);
		register(context, YEW_TREE_KEY, configuredFeatures.getOrThrow(SeidraConfiguredFeatures.YEW_TREE_KEY),
				VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100), Blocks.YEW_SAPLING.get())
		);

		registerOre(context, BISMUTH_ORE_KEY, SeidraConfiguredFeatures.BISMUTH_ORE_KEY, commonOrePlacement(4, 32, 64));
		registerOre(context, SILVER_ORE_KEY, SeidraConfiguredFeatures.SILVER_ORE_KEY, commonOrePlacement(3, -16, 32));
		registerOre(context, TUNGSTEN_ORE_KEY, SeidraConfiguredFeatures.TUNGSTEN_ORE_KEY, commonOrePlacement(2, -48, 0));

		registerOre(context, AMBER_ORE_KEY, SeidraConfiguredFeatures.AMBER_ORE_KEY, commonOrePlacement(2, 48, 80));
		registerOre(context, THULITE_ORE_KEY, SeidraConfiguredFeatures.THULITE_ORE_KEY, commonOrePlacement(3, 0, 48));
		registerOre(context, LABRADORITE_ORE_KEY, SeidraConfiguredFeatures.LABRADORITE_ORE_KEY, commonOrePlacement(2, -24, 24));

		registerOre(context, FELDSPAR_KEY, SeidraConfiguredFeatures.FELDSPAR_KEY, commonOrePlacement(1, 0, 128));
	}

	public static ResourceKey<PlacedFeature> registerKey(String name)
	{
		return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, name));
	}

	private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers)
	{
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}

	private static void registerOre(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> configured, List<PlacementModifier> modifiers)
	{
		var configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(configured);
		register(context, key, configuredFeature, modifiers);
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, int minHeight, int maxHeight)
	{
		return List.of(countPlacement, InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)), BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int count, int minHeight, int maxHeight)
	{
		return orePlacement(CountPlacement.of(count), minHeight, maxHeight);
	}

	private static List<PlacementModifier> rareOrePlacement(int chance, int minHeight, int maxHeight)
	{
		return orePlacement(RarityFilter.onAverageOnceEvery(chance), minHeight, maxHeight);
	}
}
