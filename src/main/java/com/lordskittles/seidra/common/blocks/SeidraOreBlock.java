package com.lordskittles.seidra.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class SeidraOreBlock extends SeidraBlock
{
    public SeidraOreBlock(String prettyName, Float destroyTime, Float explosionResist)
    {
        super(prettyName,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(destroyTime, explosionResist)
        );
    }
}
