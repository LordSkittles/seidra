package com.lordskittles.seidra.common.block;

import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import net.minecraft.world.level.block.RotatedPillarBlock;

public abstract class SeidraColumnBlock extends RotatedPillarBlock implements IPrettyNameProvider, ICreativeTabProvider
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
}
