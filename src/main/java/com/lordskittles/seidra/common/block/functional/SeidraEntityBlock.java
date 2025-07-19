package com.lordskittles.seidra.common.block.functional;

import com.lordskittles.seidra.common.entities.block.SeidraBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public abstract class SeidraEntityBlock<BE extends SeidraBlockEntity> extends BaseEntityBlock
{
    private final Class<BE> blockEntityClass;

    @SuppressWarnings("rawtypes")
    private final MapCodec<? extends SeidraEntityBlock> codec;
    private final VoxelShape shape;

    @SuppressWarnings("rawtypes")
    public SeidraEntityBlock(MapCodec<? extends SeidraEntityBlock> codec, @NotNull VoxelShape shape, Class<BE> blockEntityClass, Properties properties)
    {
        super(properties);
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
    protected void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston)
    {
        if(state.getBlock() != newState.getBlock())
        {
            if(level.getBlockEntity(pos) != null && blockEntityClass.isInstance(level.getBlockEntity(pos)))
            {
                BE entity = blockEntityClass.cast(level.getBlockEntity(pos));
                assert entity != null;

                entity.dropContents();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }
}
