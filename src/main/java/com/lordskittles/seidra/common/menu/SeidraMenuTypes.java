package com.lordskittles.seidra.common.menu;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.menu.container.ArcaneCraftingBlockMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lordskittles.seidra.Constants.*;

public class SeidraMenuTypes
{
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, Seidra.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<ArcaneCraftingBlockMenu>> ARCANE_CRAFTING_BLOCK = registerMenuType(buildName(Types.ARCANE_CRAFTING, Groups.BLOCK), ArcaneCraftingBlockMenu::new);

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory)
    {
        return MENU_TYPES.register(name, () -> IMenuTypeExtension.create(factory));
    }
}
