package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.common.entities.block.ArcaneCraftingBlockEntity;
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

public class ArcaneCraftingBlock extends SeidraBlock implements EntityBlock
{
    public ArcaneCraftingBlock()
    {
        super("Arcane Crafting Block", Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE));
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.blockWithItem(Blocks.ARCANE_CRAFTING_BLOCK);
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.MAIN;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState)
    {
        return new ArcaneCraftingBlockEntity(blockPos, blockState);
    }
}
