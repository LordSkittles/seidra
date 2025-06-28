package com.lordskittles.seidra.client.tabs;

import com.lordskittles.seidra.common.registries.Blocks;

public class SeidraMainTab extends SeidraCreativeTab
{
    public SeidraMainTab()
    {
        super("seidra", Blocks.ARCANE_CRAFTING_BLOCK);
    }

    @Override
    public String getPrettyName()
    {
        return "Seidra";
    }
}
