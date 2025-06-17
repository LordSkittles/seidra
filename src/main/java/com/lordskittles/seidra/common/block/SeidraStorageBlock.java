package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public class SeidraStorageBlock extends SeidraBlock
{
	public SeidraStorageBlock(String prettyName, Float destroyTime)
	{
		super(prettyName, Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(destroyTime, 6.0F));
	}

	@Override
	public Supplier<CreativeModeTab> getTab()
	{
		return CreativeTabs.WORLD;
	}
}
