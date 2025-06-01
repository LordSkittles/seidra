package com.lordskittles.seidra.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class SeidraPlankBlock extends SeidraBlock
{
    public SeidraPlankBlock(String prettyName)
    {
        super(prettyName, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }
}
