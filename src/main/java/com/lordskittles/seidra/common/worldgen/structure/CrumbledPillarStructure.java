package com.lordskittles.seidra.common.worldgen.structure;

import com.lordskittles.seidra.common.worldgen.SeidraStructureTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CrumbledPillarStructure extends Structure
{
	public static final MapCodec<CrumbledPillarStructure> CODEC = simpleCodec(CrumbledPillarStructure::new);

	public CrumbledPillarStructure(StructureSettings settings)
	{
		super(settings);
	}

	@Override
	protected @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context)
	{
		return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, (builder) -> generate(builder, context));
	}

	private void generate(StructurePiecesBuilder builder, Structure.GenerationContext generationContext)
	{

	}

	@Override
	public @NotNull StructureType<?> type()
	{
		return SeidraStructureTypes.CRUMBLED_PILLAR;
	}
}
