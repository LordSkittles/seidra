package com.lordskittles.seidra.common.blocks;

import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

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


    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.WORLD_TAB;
    }
}
