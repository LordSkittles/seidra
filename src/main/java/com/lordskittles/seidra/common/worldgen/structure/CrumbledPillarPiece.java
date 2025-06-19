package com.lordskittles.seidra.common.worldgen.structure;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.StructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.storage.loot.LootTable;

public class CrumbledPillarPiece extends TemplateStructurePiece
{
	private static final ResourceLocation[] VARIANTS = {
			ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "crumbled_pillar/1")
	};

	public CrumbledPillarPiece(StructureTemplateManager templateManager, ResourceLocation template,
							   BlockPos pos, Rotation rotation, Mirror mirror, BoundingBox boundingBox)
	{
		super(StructurePieceTypes.CRUMBLED_PILLAR_PIECE.get(), 0, templateManager, template, template.toString(), makeSettings(rotation, mirror), pos);
		this.boundingBox = boundingBox;
	}

	public CrumbledPillarPiece(StructureTemplateManager templateManager, CompoundTag tag)
	{
		super(StructurePieceTypes.CRUMBLED_PILLAR_PIECE.get(), tag, templateManager,
				(resourceLocation) -> makeSettings(Rotation.NONE, Mirror.NONE)
		);
	}

	public CrumbledPillarPiece(StructurePieceSerializationContext context, CompoundTag tag)
	{
		super(StructurePieceTypes.CRUMBLED_PILLAR_PIECE.get(), tag, context.structureTemplateManager(),
				(resourceLocation) -> makeSettings(Rotation.NONE, Mirror.NONE)
		);
	}


	private static StructurePlaceSettings makeSettings(Rotation rotation, Mirror mirror)
	{
		return new StructurePlaceSettings()
				.setRotation(rotation)
				.setMirror(mirror)
				.setRotationPivot(BlockPos.ZERO)
				.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
	}

	public static CrumbledPillarPiece createPiece(StructureTemplateManager templateManager,
												  BlockPos pos, Rotation rotation, RandomSource random)
	{
		// Pick a random variant
		ResourceLocation template = VARIANTS[random.nextInt(VARIANTS.length)];
		Mirror mirror = random.nextBoolean() ? Mirror.NONE : Mirror.LEFT_RIGHT;

		StructureTemplate structureTemplate = templateManager.getOrCreate(template);
		BoundingBox boundingBox = structureTemplate.getBoundingBox(makeSettings(rotation, mirror), pos);

		return new CrumbledPillarPiece(templateManager, template, pos, rotation, mirror, boundingBox);
	}

	@Override
	protected void handleDataMarker(String marker, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox bounds)
	{
		String[] parts = marker.split(":");
		String markerType = parts[0];

		if(markerType.equals("barrel"))
		{
			level.setBlock(pos, Blocks.BARREL.defaultBlockState(), 2);

			if(level.getBlockEntity(pos) instanceof net.minecraft.world.level.block.entity.BarrelBlockEntity barrel)
			{
				// Fill the barrel with random loot
				ResourceKey<LootTable> lootTable = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "chest/crumbled_pillar"));
				barrel.setLootTable(lootTable, random.nextLong());
			}
		}
	}
}
