package com.lordskittles.seidra.common.block;

import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.datagen.SeidraBlockStateProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.function.Supplier;

public class WakestoneBlock extends SeidraColumnBlock
{
	public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

	public WakestoneBlock()
	{
		super("Wakestone Pillar", Properties.ofFullCopy(Blocks.DEEPSLATE));

		this.registerDefaultState(this.defaultBlockState().setValue(ACTIVE, false).setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	public Supplier<CreativeModeTab> getTab()
	{
		return CreativeTabs.WORLD;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(ACTIVE, AXIS);
	}

	@Override
	public Runnable generate(SeidraBlockStateProvider provider)
	{
		return provider::registerWakestone;
	}
}
