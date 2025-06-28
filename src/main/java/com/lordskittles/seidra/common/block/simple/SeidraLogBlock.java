package com.lordskittles.seidra.common.block.simple;

import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Supplier;

public class SeidraLogBlock extends SeidraColumnBlock
{
    public static final Map<DeferredBlock<SeidraLogBlock>, DeferredBlock<SeidraLogBlock>> STRIPPING_MAP = Map.of(
            Blocks.ASH_LOG, Blocks.STRIPPED_ASH_LOG,
            Blocks.PINE_LOG, Blocks.STRIPPED_PINE_LOG,
            Blocks.YEW_LOG, Blocks.STRIPPED_YEW_LOG,
            Blocks.ASH_WOOD, Blocks.STRIPPED_ASH_WOOD,
            Blocks.PINE_WOOD, Blocks.STRIPPED_PINE_WOOD,
            Blocks.YEW_WOOD, Blocks.STRIPPED_YEW_WOOD
    );

    private final boolean isFullWood;

    public SeidraLogBlock(String prettyName, Boolean isFullWood)
    {
        super(prettyName, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.WOOD));

        this.isFullWood = isFullWood;
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.WORLD;
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction)
    {
        return true;
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction)
    {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction)
    {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, UseOnContext context, @NotNull ItemAbility itemAbility, boolean simulate)
    {
        if (context.getItemInHand().getItem() instanceof AxeItem)
        {
            for(Map.Entry<DeferredBlock<SeidraLogBlock>, DeferredBlock<SeidraLogBlock>> entry : STRIPPING_MAP.entrySet())
            {
                DeferredBlock<SeidraLogBlock> normal = entry.getKey();
                DeferredBlock<SeidraLogBlock> stripped = entry.getValue();

                if(state.is(normal))
                {
                    return stripped.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        if(isFullWood)
        {
            return () -> provider.axisBlockSubFolder(this, "wood", "", "wood", "log");
        }

        return () -> provider.axisBlockSubFolder(this, "wood", "top");
    }
}
