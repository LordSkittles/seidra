package com.lordskittles.seidra.common.block.functional;

import com.lordskittles.seidra.common.entities.block.ArcaneCraftingBlockEntity;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ArcaneCraftingBlock extends SeidraEntityBlock<ArcaneCraftingBlockEntity>
{
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final MapCodec<ArcaneCraftingBlock> CODEC = simpleCodec(ArcaneCraftingBlock::new);

    public ArcaneCraftingBlock(Properties properties)
    {
        super("Arcane Crafting Block", CODEC, SHAPE, ArcaneCraftingBlockEntity.class, Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE).noOcclusion());
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

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult)
    {
        if(level.getBlockEntity(pos) instanceof ArcaneCraftingBlockEntity be)
        {
            if(!level.isClientSide())
            {
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(be, Component.literal(getPrettyName())), pos);
                return ItemInteractionResult.SUCCESS;
            }
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
