package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.entities.block.CraftingClothBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Seidra.MODID);

    public static final Supplier<BlockEntityType<CraftingClothBlockEntity>> CRAFTING_CLOTH_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "crafting_cloth_block_entity",
            () -> BlockEntityType.Builder.of(
                    CraftingClothBlockEntity::new,
                    Blocks.CRAFTING_CLOTH.get()
            ).build(null)
    );
}
