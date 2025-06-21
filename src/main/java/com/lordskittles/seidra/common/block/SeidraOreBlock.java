package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.common.item.SeidraItem;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockLootTableProvider;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Consumer;
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

    @Override
    public Runnable drop(SeidraBlockLootTableProvider provider)
    {
        return () -> provider.dropOre(this, getDrop());
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.blockWithItemSubFolder(Blocks.ALL.get(getPrettyName()), "ores");
    }
}
