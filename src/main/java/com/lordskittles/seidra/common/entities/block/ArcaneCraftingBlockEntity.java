package com.lordskittles.seidra.common.entities.block;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.containers.ArcaneCraftingBlockMenu;
import com.lordskittles.seidra.common.registries.BlockEntityTypes;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArcaneCraftingBlockEntity extends SeidraBlockEntity implements MenuProvider
{
    public final ItemStackHandler inventory = new ItemStackHandler(10)
    {
        @Override
        protected int getStackLimit(int slot, ItemStack stack)
        {
            return stack.getMaxStackSize();
        }

        @Override
        protected void onContentsChanged(int slot)
        {
            setChanged();
            assert level != null;
            if (!level.isClientSide())
            {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public ArcaneCraftingBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityTypes.ARCANE_CRAFTING_BLOCK_ENTITY.get(), pos, blockState);
    }

    public void clearContents()
    {
        for (int i = 0; i < inventory.getSlots(); i++)
        {
            inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    @Override
    public void drops()
    {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++)
        {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

        assert level != null;
        Containers.dropContents(level, worldPosition, inv);
    }

    @Override
    public @NotNull Component getDisplayName()
    {
        return Component.translatable(Seidra.MODID + ".blockentity." + Blocks.ARCANE_CRAFTING_BLOCK.getId().getPath());
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory, @NotNull Player player)
    {
        return new ArcaneCraftingBlockMenu(containerId, inventory, this);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
    {
        super.saveAdditional(tag, registries);

        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
    {
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));

        super.loadAdditional(tag, registries);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries)
    {
        return saveWithoutMetadata(registries);
    }
}
