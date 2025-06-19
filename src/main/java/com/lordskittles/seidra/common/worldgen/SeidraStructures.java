package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.worldgen.structure.CrumbledPillarStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class SeidraStructures
{
	public static final ResourceKey<Structure> CRUMBLED_PILLAR_KEY = registerKey("crumbled_pillar");

	public static void bootstrap(BootstrapContext<Structure> context)
	{
		context.register(CRUMBLED_PILLAR_KEY, CrumbledPillarStructure.CODEC);
	}

	private static ResourceKey<Structure> registerKey(String name)
	{
		return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, name));
	}
}
