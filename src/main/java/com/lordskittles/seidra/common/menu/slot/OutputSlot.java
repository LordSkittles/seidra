package com.lordskittles.seidra.common.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

public class OutputSlot extends Slot
{
    private static Container emptyInventory = new SimpleContainer(0);
    private final IItemHandler itemHandler;
    protected final int index;

    public OutputSlot(IItemHandler itemHandler, int slot, int x, int y)
    {
        super(emptyInventory, slot, x, y);

        this.itemHandler = itemHandler;
        this.index = slot;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack)
    {
        return false;
    }

    public ItemStack getItem()
    {
        return this.getItemHandler().getStackInSlot(this.index);
    }

    public void set(ItemStack stack)
    {
        ((IItemHandlerModifiable) this.getItemHandler()).setStackInSlot(this.index, stack);
        this.setChanged();
    }

    public void initialize(ItemStack stack)
    {
        ((IItemHandlerModifiable) this.getItemHandler()).setStackInSlot(this.index, stack);
        this.setChanged();
    }

    public void onQuickCraft(ItemStack oldStackIn, ItemStack newStackIn)
    {
    }

    public int getMaxStackSize()
    {
        return this.itemHandler.getSlotLimit(this.index);
    }

    public int getMaxStackSize(ItemStack stack)
    {
        return Math.min(stack.getMaxStackSize(), this.itemHandler.getSlotLimit(this.index));
    }

    public boolean mayPickup(Player playerIn)
    {
        return !this.getItemHandler().extractItem(this.index, 1, true).isEmpty();
    }

    public ItemStack remove(int amount)
    {
        return this.getItemHandler().extractItem(this.index, amount, false);
    }

    public IItemHandler getItemHandler()
    {
        return this.itemHandler;
    }
}
