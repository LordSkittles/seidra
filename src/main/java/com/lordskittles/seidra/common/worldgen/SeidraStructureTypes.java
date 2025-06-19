package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.common.worldgen.structure.CrumbledPillarStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public interface SeidraStructureTypes<S extends StructureType>
{
	StructureType<CrumbledPillarStructure> CRUMBLED_PILLAR = register("crumbled_pillar", CrumbledPillarStructure.CODEC);

	MapCodec<S> codec();

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static <S extends Structure> StructureType<S> register(String name, MapCodec<S> codec)
	{
		return (StructureType) Registry.register(BuiltInRegistries.STRUCTURE_TYPE, name, (StructureType)() -> codec);
	}
}
