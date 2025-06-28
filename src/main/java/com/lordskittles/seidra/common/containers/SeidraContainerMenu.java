package com.lordskittles.seidra.common.containers;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class SeidraContainerMenu extends AbstractContainerMenu
{
    protected SeidraContainerMenu(@Nullable MenuType<?> menuType, int containerId)
    {
        super(menuType, containerId);
    }

    protected void addPlayerInventory(Inventory inventory)
    {
        addPlayerInventory(inventory, 8, 108);
    }

    protected void addPlayerInventory(Inventory inventory, int startX, int startY)
    {
        addPlayerInventory(inventory, startX, startY, 18, 18);
    }

    protected void addPlayerInventory(Inventory playerInventory, int startX, int startY, int spacingX, int spacingY)
    {
        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 9; ++x)
            {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, startX + x * spacingX, startY + y * spacingY));
            }
        }
    }

    protected void addPlayerHotbar(Inventory playerInventory)
    {
        addPlayerHotbar(playerInventory, 8, 166);
    }

    protected void addPlayerHotbar(Inventory playerInventory, int startX, int startY)
    {
        addPlayerHotbar(playerInventory, startX, startY, 18);
    }

    protected void addPlayerHotbar(Inventory playerInventory, int startX, int startY, int spacing)
    {
        for (int x = 0; x < 9; ++x)
        {
            this.addSlot(new Slot(playerInventory, x, startX + x * spacing, startY));
        }
    }
}
