package com.lordskittles.seidra.common.entities;

import com.lordskittles.seidra.Names;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.entities.block.ArcaneCraftingBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Seidra.MODID);

    public static final Supplier<BlockEntityType<ArcaneCraftingBlockEntity>> ARCANE_CRAFTING_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            Names.buildName(Names.Types.ARCANE_CRAFTING, Names.Groups.BLOCK, Names.Groups.ENTITY),
            () -> BlockEntityType.Builder.of(
                    ArcaneCraftingBlockEntity::new,
                    SeidraBlocks.ARCANE_CRAFTING_BLOCK.get()
            ).build(null)
    );
}
