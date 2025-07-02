package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Names;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;

public class SeidraStructureSets
{
	public static final ResourceKey<StructureSet> CRUMBLED_PILLAR = createKey(Names.buildName(Names.Prefixes.CRUMBLED, Names.Suffixes.PILLAR));

	public static void bootstrap(BootstrapContext<StructureSet> context)
	{
		var structureGetter = context.lookup(Registries.STRUCTURE);

		context.register(CRUMBLED_PILLAR, new StructureSet(
				List.of(StructureSet.entry(structureGetter.getOrThrow(SeidraStructures.CRUMBLED_PILLAR_KEY))),
				new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 14357618))
		);
	}

	private static ResourceKey<StructureSet> createKey(String name)
	{
		return ResourceKey.create(Registries.STRUCTURE_SET, Names.modRes(name));
	}
}
