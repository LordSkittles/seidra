package com.lordskittles.seidra.common.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class SeidraOreBlock extends SeidraBlock
{
    public SeidraOreBlock(String prettyName, Float destroyTime, Float explosionResist)
    {
        super(prettyName,
              BlockBehaviour.Properties.of(Material.STONE)
                .requiresCorrectToolForDrops()
                .strength(destroyTime, explosionResist)
        );
    }
}
