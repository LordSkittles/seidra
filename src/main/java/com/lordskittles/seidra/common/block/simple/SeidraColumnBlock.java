package com.lordskittles.seidra.common.block.simple;

import api.lordskittles.seidra.interfaces.IBlockStateDatagenProvider;
import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.ILootTableDatagenProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.datagen.SeidraBlockLootTableProvider;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.world.level.block.RotatedPillarBlock;

public abstract class SeidraColumnBlock extends RotatedPillarBlock implements IPrettyNameProvider, ICreativeTabProvider, ILootTableDatagenProvider<SeidraBlockLootTableProvider>, IBlockStateDatagenProvider<SeidraBlockStateProvider>
{
    private final String prettyName;

    public SeidraColumnBlock(String prettyName, Properties properties)
    {
        super(properties);

        this.prettyName = prettyName;
    }

    @Override
    public String getPrettyName()
    {
        return prettyName;
    }

    @Override
    public Runnable drop(SeidraBlockLootTableProvider provider)
    {
        return () -> provider.dropSelf(this);
    }
}
