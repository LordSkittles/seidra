package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Tuple;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class SeidraConfiguredFeatures
{
	public static final ResourceKey<ConfiguredFeature<?, ?>> JUNIPER_TREE_KEY = registerKey("juniper");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE_KEY = registerKey("pine");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YEW_TREE_KEY = registerKey("yew");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BISMUTH_ORE_KEY = registerKey("bismuth_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY = registerKey("cobalt_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");

	public static final ResourceKey<ConfiguredFeature<?, ?>> IOLITE_ORE_KEY = registerKey("iolite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> THULITE_ORE_KEY = registerKey("thulite_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ZOISITE_ORE_KEY = registerKey("zoisite_ore");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
	{
		bootstrapOres(context);
		bootstrapTrees(context);
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

	private static void bootstrapOres(BootstrapContext<ConfiguredFeature<?, ?>> context)
	{
		registerOre(context, BISMUTH_ORE_KEY, new Tuple<>(Blocks.BISMUTH_ORE.get().defaultBlockState(), Blocks.DEEPSLATE_BISMUTH_ORE.get().defaultBlockState()), 8);
		registerOre(context, COBALT_ORE_KEY, new Tuple<>(Blocks.COBALT_ORE.get().defaultBlockState(), Blocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState()), 6);
		registerOre(context, TUNGSTEN_ORE_KEY, new Tuple<>(Blocks.TUNGSTEN_ORE.get().defaultBlockState(), Blocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState()), 5);

		registerOre(context, IOLITE_ORE_KEY, new Tuple<>(Blocks.IOLITE_ORE.get().defaultBlockState(), Blocks.DEEPSLATE_IOLITE_ORE.get().defaultBlockState()), 4);
		registerOre(context, THULITE_ORE_KEY, new Tuple<>(Blocks.THULITE_ORE.get().defaultBlockState(), Blocks.DEEPSLATE_THULITE_ORE.get().defaultBlockState()), 6);
		registerOre(context, ZOISITE_ORE_KEY, new Tuple<>(Blocks.ZOISITE_ORE.get().defaultBlockState(), Blocks.DEEPSLATE_ZOISITE_ORE.get().defaultBlockState()), 5);
	}

	private static void registerOre(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Tuple<BlockState, BlockState> ores,
									int veinSize)
	{
		// Create the rule tests for stone and deepslate replaceable blocks
		RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		// Create the target block states for the ore generation
		List<OreConfiguration.TargetBlockState> targets = List.of(
				OreConfiguration.target(stoneReplaceable, ores.getA()),
				OreConfiguration.target(deepslateReplaceable, ores.getB())
		);

		register(context, key, Feature.ORE, new OreConfiguration(targets, veinSize));
	}

	private static void bootstrapTrees(BootstrapContext<ConfiguredFeature<?, ?>> context)
	{
		register(context, JUNIPER_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(Blocks.JUNIPER_LOG.get()),
						new ForkingTrunkPlacer(4, 4, 3),
						BlockStateProvider.simple(Blocks.JUNIPER_LEAVES.get()),
						new BlobFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 1), 3),
						new TwoLayersFeatureSize(1, 0, 2)
				).build()
		);

		register(context, PINE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(Blocks.PINE_LOG.get()),
						new ForkingTrunkPlacer(4, 4, 3),
						BlockStateProvider.simple(Blocks.PINE_LEAVES.get()),
						new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
						new TwoLayersFeatureSize(1, 0, 2)
				).build()
		);

		register(context, YEW_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(Blocks.YEW_LOG.get()),
						new ForkingTrunkPlacer(4, 4, 3),
						BlockStateProvider.simple(Blocks.YEW_LEAVES.get()),
						new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
						new TwoLayersFeatureSize(1, 0, 2)
				).build()
		);
	}
}
