package com.lordskittles.seidra.common.block.functional;

import api.lordskittles.seidra.interfaces.IBlockStateDatagenProvider;
import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.ILootTableDatagenProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.entities.block.SeidraBlockEntity;
import com.lordskittles.seidra.datagen.SeidraBlockLootTableProvider;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public abstract class SeidraEntityBlock<BE extends SeidraBlockEntity> extends BaseEntityBlock implements IPrettyNameProvider, ICreativeTabProvider, ILootTableDatagenProvider<SeidraBlockLootTableProvider>, IBlockStateDatagenProvider<SeidraBlockStateProvider>
{
    private final Class<BE> blockEntityClass;

    private final String prettyName;
    @SuppressWarnings("rawtypes")
    private final MapCodec<? extends SeidraEntityBlock> codec;
    private final VoxelShape shape;

    @SuppressWarnings("rawtypes")
    public SeidraEntityBlock(String prettyName, MapCodec<? extends SeidraEntityBlock> codec, @NotNull VoxelShape shape, Class<BE> blockEntityClass, Properties properties)
    {
        super(properties);
        this.prettyName = prettyName;
        this.codec = codec;
        this.shape = shape;

        this.blockEntityClass = blockEntityClass;
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return this.shape;
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec()
    {
        return codec;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    public Runnable drop(SeidraBlockLootTableProvider provider)
    {
        return () -> provider.dropSelf(this);
    }

    @Override
    public String getPrettyName()
    {
        return this.prettyName;
    }

    @Override
    protected void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston)
    {
        if(state.getBlock() != newState.getBlock())
        {
            if(level.getBlockEntity(pos) != null && blockEntityClass.isInstance(level.getBlockEntity(pos)))
            {
                BE entity = blockEntityClass.cast(level.getBlockEntity(pos));
                assert entity != null;

                entity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }
}
