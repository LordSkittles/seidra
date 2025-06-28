package com.lordskittles.seidra.common.block.simple;

import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class SeidraSimpleBlock extends SeidraBlock
{
    private final DeferredHolder<CreativeModeTab, CreativeModeTab> creativeTab;
    private final String subFolder;

    public SeidraSimpleBlock(String prettyName, DeferredHolder<CreativeModeTab, CreativeModeTab> creativeTab, String subFolder, Properties properties)
    {
        super(prettyName, properties);

        this.creativeTab = creativeTab;
        this.subFolder = subFolder;
    }

    @Override
    public Runnable generate(SeidraBlockStateProvider provider)
    {
        return () -> provider.blockWithItemSubFolder(Blocks.ALL.get(getPrettyName()), subFolder);
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return creativeTab;
    }
}
