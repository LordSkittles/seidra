package com.lordskittles.seidra.common.entities.block;

import com.lordskittles.seidra.common.registries.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CraftingClothBlockEntity extends BlockEntity
{
    public CraftingClothBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityTypes.CRAFTING_CLOTH_BLOCK_ENTITY.get(), pos, blockState);
    }
}
