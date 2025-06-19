package com.lordskittles.seidra.common.worldgen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.worldgen.structure.CrumbledPillarStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SeidraStructureTypes
{
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Seidra.MODID);

	public static final Supplier<StructureType<CrumbledPillarStructure>> CRUMBLED_PILLAR = register("crumbled_pillar", CrumbledPillarStructure.CODEC);

	private static <S extends Structure> Supplier<StructureType<S>> register(String name, MapCodec<S> codec)
	{
		return STRUCTURE_TYPES.register(name, () -> () -> codec);
	}
}
