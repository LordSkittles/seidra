package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class SeidraConfiguredFeatures
{
	public static final ResourceKey<ConfiguredFeature<?, ?>> JUNIPER_KEY = registerKey("juniper");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_KEY = registerKey("pine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YEW_KEY = registerKey("yew");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
	{
		register(context, JUNIPER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(Blocks.JUNIPER_LOG.get()),
				new ForkingTrunkPlacer(4, 4, 3),
				BlockStateProvider.simple(Blocks.JUNIPER_LEAVES.get()),
				new BlobFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 1), 3),
				new TwoLayersFeatureSize(1, 0, 2)
		).build());

		register(context, PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(Blocks.PINE_LOG.get()),
				new ForkingTrunkPlacer(4, 4, 3),
				BlockStateProvider.simple(Blocks.PINE_LEAVES.get()),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
				new TwoLayersFeatureSize(1, 0, 2)
		).build());

		register(context, YEW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(Blocks.YEW_LOG.get()),
				new ForkingTrunkPlacer(4, 4, 3),
				BlockStateProvider.simple(Blocks.YEW_LEAVES.get()),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
				new TwoLayersFeatureSize(1, 0, 2)
		).build());
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name)
	{
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
																						  ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
	{
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
