package com.lordskittles.seidra.client.tabs;

import com.lordskittles.seidra.common.registries.SeidraBlocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;

public class SeidraWorldTab extends SeidraCreativeTab
{
    public SeidraWorldTab()
    {
        super("world", SeidraBlocks.BISMUTH_ORE, CreativeTabs.MAIN);
    }

    @Override
    public String getPrettyName()
    {
        return "Seidra: World";
    }
}
