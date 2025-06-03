package com.lordskittles.seidra.blocks;

import com.lordskittles.seidra.interfaces.ICreativeTabProvider;
import com.lordskittles.seidra.interfaces.IPrettyNameProvider;
import net.minecraft.world.level.block.Block;

public abstract class SeidraBlock extends Block implements IPrettyNameProvider, ICreativeTabProvider
{
    private final String prettyName;

    public SeidraBlock(String prettyName, Properties properties)
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
