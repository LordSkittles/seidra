package com.lordskittles.seidra.common.block.simple;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class WakestoneBlock extends RotatedPillarBlock
{
	public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

	public WakestoneBlock()
	{
		super(Properties.ofFullCopy(Blocks.DEEPSLATE));

		this.registerDefaultState(this.defaultBlockState().setValue(ACTIVE, false).setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
	{
		builder.add(ACTIVE, AXIS);
	}
}
