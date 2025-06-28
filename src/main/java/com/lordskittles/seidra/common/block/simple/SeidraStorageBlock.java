package com.lordskittles.seidra.common.block.simple;

import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

public class SeidraStorageBlock extends SeidraBlock
{
	public SeidraStorageBlock(String prettyName, Float destroyTime)
	{
		super(prettyName, Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).strength(destroyTime, 6.0F));
	}

	@Override
	public Supplier<CreativeModeTab> getTab()
	{
		return CreativeTabs.WORLD;
	}

	@Override
	public Runnable generate(SeidraBlockStateProvider provider)
	{
		return () -> provider.blockWithItemSubFolder(Blocks.ALL.get(getPrettyName()), "ores");
	}
}
