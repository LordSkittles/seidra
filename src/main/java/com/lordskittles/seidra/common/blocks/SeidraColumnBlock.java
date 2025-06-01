package com.lordskittles.seidra.common.blocks;

import net.minecraft.world.level.block.RotatedPillarBlock;

public class SeidraColumnBlock extends RotatedPillarBlock implements IPrettyNameProvider
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
