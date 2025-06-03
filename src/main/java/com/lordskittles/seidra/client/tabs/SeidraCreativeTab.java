package com.lordskittles.seidra.client.tabs;

import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public abstract class SeidraCreativeTab extends CreativeModeTab implements IPrettyNameProvider
{
    protected SeidraCreativeTab(String title, ItemLike icon)
    {
        super(CreativeModeTab.builder()
                      .title(Component.translatable("creativetab.seidra." + title))
                      .icon(() -> new ItemStack(icon)));
    }
}
