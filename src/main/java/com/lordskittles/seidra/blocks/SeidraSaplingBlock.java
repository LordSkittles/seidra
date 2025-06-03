package com.lordskittles.seidra.blocks;

import com.lordskittles.seidra.interfaces.ICreativeTabProvider;
import com.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.registries.CreativeTabs;
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
		return CreativeTabs.WORLD_TAB;
	}

	@Override
	public String getPrettyName()
	{
		return prettyName;
	}
}
