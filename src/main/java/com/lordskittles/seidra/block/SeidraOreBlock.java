package com.lordskittles.seidra.block;

import com.lordskittles.seidra.item.SeidraItem;
import com.lordskittles.seidra.registries.CreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

public class SeidraOreBlock extends SeidraBlock
{
    private final DeferredItem<SeidraItem> drop;

    public SeidraOreBlock(String prettyName, Float destroyTime, Float explosionResist, DeferredItem<SeidraItem> drop)
    {
        super(prettyName,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(destroyTime, explosionResist)
        );

        this.drop = drop;
    }

    public DeferredItem<SeidraItem> getDrop()
    {
        return drop;
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.WORLD;
    }
}
