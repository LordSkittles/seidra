package com.lordskittles.seidra.common.interfaces;

import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

public interface ICreativeTabProvider
{
    Supplier<CreativeModeTab> getTab();
}
