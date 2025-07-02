package com.lordskittles.seidra.common.worldgen.structure.pieces;

import com.lordskittles.seidra.Seidra;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SeidraStructurePieceTypes
{
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = DeferredRegister.create(Registries.STRUCTURE_PIECE, Seidra.MODID);

	public static final Supplier<StructurePieceType> CRUMBLED_PILLAR_PIECE = STRUCTURE_PIECE_TYPES.register("crumbled_pillar_piece", () -> CrumbledPillarPiece::new);
}
