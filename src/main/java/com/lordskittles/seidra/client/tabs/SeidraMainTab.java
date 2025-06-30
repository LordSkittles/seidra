package com.lordskittles.seidra.client.tabs;

import com.lordskittles.seidra.common.registries.SeidraBlocks;

public class SeidraMainTab extends SeidraCreativeTab
{
    public SeidraMainTab()
    {
        super("seidra", SeidraBlocks.ARCANE_CRAFTING_BLOCK);
    }

    @Override
    public String getPrettyName()
    {
        return "Seidra";
    }
}
