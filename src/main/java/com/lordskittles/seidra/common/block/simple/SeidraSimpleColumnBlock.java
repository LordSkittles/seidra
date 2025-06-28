package com.lordskittles.seidra.common.block.simple;

import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class SeidraSimpleColumnBlock extends SeidraColumnBlock
{
    private final DeferredHolder<CreativeModeTab, CreativeModeTab> creativeTab;
    private final String subFolder;

    public SeidraSimpleColumnBlock(String prettyName, DeferredHolder<CreativeModeTab, CreativeModeTab> creativeTab, String subFolder, Properties properties)
    {
        super(prettyName, properties);

        this.creativeTab = creativeTab;
        this.subFolder = subFolder;
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.axisBlockSubFolder(this, subFolder, "top");
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return creativeTab;
    }
}
