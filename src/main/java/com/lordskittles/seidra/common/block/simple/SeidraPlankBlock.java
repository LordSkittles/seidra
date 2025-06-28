package com.lordskittles.seidra.common.block.simple;

import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class SeidraPlankBlock extends SeidraBlock
{
    public SeidraPlankBlock(String prettyName)
    {
        super(prettyName, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.WORLD;
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.blockWithItemSubFolder(Blocks.ALL.get(getPrettyName()), "wood");
    }
}
