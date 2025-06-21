package com.lordskittles.seidra.common.block;

import api.lordskittles.seidra.interfaces.IBlockStateDatagenProvider;
import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.ILootTableDatagenProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockLootTableProvider;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class SeidraLeafBlock extends LeavesBlock implements IPrettyNameProvider, ICreativeTabProvider, IBlockStateDatagenProvider<SeidraBlockStateProvider>, ILootTableDatagenProvider<SeidraBlockLootTableProvider>
{
    private final String prettyName;
    private final DeferredBlock<SeidraSaplingBlock> sapling;

    public SeidraLeafBlock(String prettyName, DeferredBlock<SeidraSaplingBlock> sapling)
    {
        super(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.OAK_LEAVES));

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

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.blockWithItemSubFolder(Blocks.ALL.get(getPrettyName()), "plants");
    }

    @Override
    public Runnable drop(SeidraBlockLootTableProvider provider)
    {
        return () -> provider.leafDrop(this, sapling);
    }
}
