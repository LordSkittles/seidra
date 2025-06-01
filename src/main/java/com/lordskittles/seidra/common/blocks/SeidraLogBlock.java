package com.lordskittles.seidra.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class SeidraLogBlock extends SeidraColumnBlock
{
    public SeidraLogBlock(String prettyName)
    {
        super(prettyName, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F).sound(SoundType.WOOD));
    }
}
