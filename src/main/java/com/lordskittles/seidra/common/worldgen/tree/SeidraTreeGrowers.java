package com.lordskittles.seidra.common.worldgen.tree;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.worldgen.SeidraConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class SeidraTreeGrowers
{
	public static final TreeGrower ASH = new TreeGrower(Seidra.MODID + ":ash", Optional.empty(),
			Optional.of(SeidraConfiguredFeatures.ASH_TREE_KEY), Optional.empty());

	public static final TreeGrower PINE = new TreeGrower(Seidra.MODID + ":pine", Optional.empty(),
			Optional.of(SeidraConfiguredFeatures.PINE_TREE_KEY), Optional.empty());

	public static final TreeGrower YEW = new TreeGrower(Seidra.MODID + ":yew", Optional.empty(),
			Optional.of(SeidraConfiguredFeatures.YEW_TREE_KEY), Optional.empty());
}
