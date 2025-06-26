package com.lordskittles.seidra.common.item;

import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class CraftingClothItem extends SeidraItem
{
    public CraftingClothItem()
    {
        super("Crafting Cloth", new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public Supplier<CreativeModeTab> getTab()
    {
        return CreativeTabs.WORLD;
    }
}
