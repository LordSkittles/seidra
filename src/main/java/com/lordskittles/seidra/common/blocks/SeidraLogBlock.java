package com.lordskittles.seidra.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class SeidraLogBlock extends SeidraColumnBlock
{
    public SeidraLogBlock(String prettyName)
    {
        super(prettyName, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD));
    }
}
