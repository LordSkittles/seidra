package com.lordskittles.seidra.common.block.functional;

import com.lordskittles.seidra.common.entities.SeidraBlockEntityTypes;
import com.lordskittles.seidra.common.entities.block.SindriWorkbenchBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SindriWorkbenchBlock extends SeidraEntityBlock<SindriWorkbenchBlockEntity>
{
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final MapCodec<SindriWorkbenchBlock> CODEC = simpleCodec(SindriWorkbenchBlock::new);

    public SindriWorkbenchBlock(Properties properties)
    {
        super(CODEC, SHAPE, SindriWorkbenchBlockEntity.class, Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE).noOcclusion());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState)
    {
        return new SindriWorkbenchBlockEntity(blockPos, blockState);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult)
    {
        if (!level.isClientSide())
        {
            BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof SindriWorkbenchBlockEntity arcaneCraftingBlock)
            {
                player.openMenu(new SimpleMenuProvider(arcaneCraftingBlock, Component.literal("Arcane Crafting Block")), pos);
            }
            else
            {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType)
    {
        if (level.isClientSide())
        {
            return null;
        }

        return createTickerHelper(blockEntityType, SeidraBlockEntityTypes.ARCANE_CRAFTING_BLOCK_ENTITY.get(),
                ((level1, blockPos, blockState1, blockEntity) -> blockEntity.tick(level1, blockPos, blockState1)));
    }
}
