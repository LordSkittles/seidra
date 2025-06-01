package com.lordskittles.seidra.common.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public abstract class SeidraBlock extends Block implements IPrettyNameProvider
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
