package com.lordskittles.seidra.block;

import com.lordskittles.seidra.interfaces.ICreativeTabProvider;
import com.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.registries.CreativeTabs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class SeidraLeafBlock extends LeavesBlock implements IPrettyNameProvider, ICreativeTabProvider
{
    private final String prettyName;
    private final DeferredBlock<SeidraSaplingBlock> sapling;

    public SeidraLeafBlock(String prettyName, DeferredBlock<SeidraSaplingBlock> sapling)
    {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));

        this.prettyName = prettyName;
        this.sapling = sapling;
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.WORLD;
    }

    @Override
    public String getPrettyName()
    {
        return prettyName;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return 30;
    }

    public DeferredBlock<SeidraSaplingBlock> getSapling()
    {
        return sapling;
    }
}
