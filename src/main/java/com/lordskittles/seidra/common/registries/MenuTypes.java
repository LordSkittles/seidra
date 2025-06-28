package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.containers.ArcaneCraftingBlockMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuTypes
{
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, Seidra.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<ArcaneCraftingBlockMenu>> ARCANE_CRAFTING_BLOCK = registerMenuType("arcane_crafting_block", ArcaneCraftingBlockMenu::new);

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory)
    {
        return MENU_TYPES.register(name, () -> IMenuTypeExtension.create(factory));
    }
}
