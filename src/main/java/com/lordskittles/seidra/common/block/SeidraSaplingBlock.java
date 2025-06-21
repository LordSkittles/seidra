package com.lordskittles.seidra.common.block;

import api.lordskittles.seidra.interfaces.IBlockStateDatagenProvider;
import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.ILootTableDatagenProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockLootTableProvider;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class SeidraSaplingBlock extends SaplingBlock implements IPrettyNameProvider, ICreativeTabProvider, ILootTableDatagenProvider<SeidraBlockLootTableProvider>, IBlockStateDatagenProvider<SeidraBlockStateProvider>
{
    private final String prettyName;

    public SeidraSaplingBlock(String prettyName, TreeGrower treeGrower)
    {
        super(treeGrower, BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.OAK_SAPLING));

        this.prettyName = prettyName;
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
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.saplingBlockWithItem((DeferredBlock<SeidraSaplingBlock>) Blocks.ALL.get(prettyName));
    }

    @Override
    public Runnable drop(SeidraBlockLootTableProvider provider)
    {
        return () -> provider.dropSelf(this);
    }
}
