package com.lordskittles.seidra.common.block;

import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class SeidraSaplingBlock extends SaplingBlock implements IPrettyNameProvider, ICreativeTabProvider
{
	private final String prettyName;

	public SeidraSaplingBlock(String prettyName, TreeGrower treeGrower)
	{
		super(treeGrower, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

		this.prettyName = prettyName;
	}

	@Override
	public Supplier<CreativeModeTab> getTab()
	{
		return CreativeTabs.WORLD;
	}

	@Override
	public String getPrettyName()
	{
		return prettyName;
	}
}
