package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.common.entities.block.CraftingClothBlockEntity;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CraftingClothBlock extends SeidraBlock implements EntityBlock
{
    public CraftingClothBlock()
    {
        super("Crafting Cloth", Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.WHITE_WOOL));
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.blockWithItem(Blocks.CRAFTING_CLOTH);
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.MAIN;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState)
    {
        return new CraftingClothBlockEntity(blockPos, blockState);
    }
}
