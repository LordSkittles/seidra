package com.lordskittles.seidra.client.tabs;

import com.lordskittles.seidra.registries.Blocks;

public class SeidraWorldTab extends SeidraCreativeTab
{
    public SeidraWorldTab()
    {
        super("world", Blocks.BISMUTH_ORE);
    }

    @Override
    public String getPrettyName()
    {
        return "Seidra: World";
    }
}
