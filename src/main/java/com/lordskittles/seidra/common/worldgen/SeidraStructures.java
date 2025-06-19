package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.worldgen.structure.CrumbledPillarStructure;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;

public class SeidraStructures
{
	public static final ResourceKey<Structure> CRUMBLED_PILLAR_KEY = registerKey("crumbled_pillar");

	public static void bootstrap(BootstrapContext<Structure> context)
	{
		HolderGetter<Biome> holderGetter = context.lookup(Registries.BIOME);

		context.register(CRUMBLED_PILLAR_KEY, new CrumbledPillarStructure(new Structure.StructureSettings(holderGetter.getOrThrow(BiomeTags.IS_OVERWORLD))));
	}

	private static void register(BootstrapContext<Structure> context, ResourceKey<Structure> key, Structure structure)
	{
		context.register(key, structure);
	}

	private static ResourceKey<Structure> registerKey(String name)
	{
		return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, name));
	}
}
