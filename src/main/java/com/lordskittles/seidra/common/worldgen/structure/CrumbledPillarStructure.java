package com.lordskittles.seidra.common.worldgen.structure;

import com.lordskittles.seidra.common.registries.StructureTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
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

	private void generate(StructurePiecesBuilder builder, Structure.GenerationContext context)
	{
		BlockPos centerPos = new BlockPos(context.chunkPos().getMinBlockX() + 8, 0, context.chunkPos().getMinBlockZ() + 8);

		// Find the surface height
		int surfaceHeight = context.chunkGenerator().getFirstOccupiedHeight(
				centerPos.getX(), centerPos.getZ(),
				Heightmap.Types.WORLD_SURFACE_WG,
				context.heightAccessor(),
				context.randomState()
		);

		BlockPos structurePos = new BlockPos(centerPos.getX(), surfaceHeight + 1, centerPos.getZ());
		Rotation rotation = Rotation.getRandom(context.random());

		// Add the main piece with random variant
		CrumbledPillarPiece piece = CrumbledPillarPiece.createPiece(
				context.structureTemplateManager(),
				structurePos,
				rotation,
				context.random()
		);

		builder.addPiece(piece);
	}

	@Override
	public @NotNull StructureType<?> type()
	{
		return StructureTypes.CRUMBLED_PILLAR.get();
	}
}
