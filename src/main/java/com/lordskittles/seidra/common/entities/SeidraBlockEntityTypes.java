package com.lordskittles.seidra.common.entities;

import com.lordskittles.seidra.Constants;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.entities.block.SindriWorkbenchBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SeidraBlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Seidra.MODID);

    public static final Supplier<BlockEntityType<SindriWorkbenchBlockEntity>> ARCANE_CRAFTING_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            Constants.buildName(Constants.Types.ARCANE_CRAFTING, Constants.Groups.BLOCK, Constants.Groups.ENTITY),
            () -> BlockEntityType.Builder.of(
                    SindriWorkbenchBlockEntity::new,
                    SeidraBlocks.SINDRI_WORKBENCH.get()
            ).build(null)
    );
}
