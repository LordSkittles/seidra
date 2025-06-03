package com.lordskittles.seidra.common.blocks;

import com.lordskittles.seidra.common.interfaces.ICreativeTabProvider;
import com.lordskittles.seidra.common.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class SeidraLeafBlock extends LeavesBlock implements IPrettyNameProvider, ICreativeTabProvider
{
    private final String prettyName;

    public SeidraLeafBlock(String prettyName)
    {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));

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
