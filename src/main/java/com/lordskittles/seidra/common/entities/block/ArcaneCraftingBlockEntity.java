package com.lordskittles.seidra.common.entities.block;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.crafting.SeidraCraftingManager;
import com.lordskittles.seidra.common.crafting.input.ArcaneCraftingInput;
import com.lordskittles.seidra.common.entities.SeidraBlockEntityTypes;
import com.lordskittles.seidra.common.menu.container.ArcaneCraftingBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

                if(slot < 9)
                {
                    needsCraftingUpdate = true;
                }
                else
                {
                    if(getStackInSlot(0).isEmpty() && !lastResult.isEmpty())
                    {
                        lastResult.setCount(0);
                    }
                }
            }
        }
    };
    private boolean needsCraftingUpdate = false;
    private ItemStack lastResult = ItemStack.EMPTY;

    public ArcaneCraftingBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(SeidraBlockEntityTypes.ARCANE_CRAFTING_BLOCK_ENTITY.get(), pos, blockState);
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
        return Component.translatable(Seidra.MODID + ".blockentity." + SeidraBlocks.ARCANE_CRAFTING_BLOCK.getId().getPath());
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory, @NotNull Player player)
    {
        assert level != null;
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

    public void tick(Level level, BlockPos blockPos, BlockState blockState)
    {
        if (level.isClientSide() || !needsCraftingUpdate)
        {
            return;
        }

        needsCraftingUpdate = false;
        updateCraftingResult();
    }

    private void updateCraftingResult()
    {
        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            items.add(inventory.getStackInSlot(i));
        }

        ArcaneCraftingInput input = ArcaneCraftingInput.of(3, 3, items, 0);
        ItemStack newResult = ItemStack.EMPTY;
        assert level != null;
        Optional<RecipeHolder<? extends Recipe<ArcaneCraftingInput>>> foundRecipe = SeidraCraftingManager.getRecipeFor(input, level);

        if (foundRecipe.isPresent())
        {
            Recipe<ArcaneCraftingInput> recipe = foundRecipe.get().value();
            ItemStack result = recipe.getResultItem(level.registryAccess());
            if (result.isItemEnabled(level.enabledFeatures()))
            {
                newResult = result;
            }
        }

        if (!ItemStack.isSameItemSameComponents(lastResult, newResult))
        {
            lastResult = newResult.copy();
            inventory.setStackInSlot(9, newResult);
            setChanged();

            notifyOpenMenus();
        }
    }

    private void notifyOpenMenus()
    {
        assert level != null;
        for (Player player : level.players())
        {
            if (player.containerMenu instanceof ArcaneCraftingBlockMenu menu)
            {
                if (menu.blockEntity == this)
                {
                    // Send slot update packet
                    if (player instanceof ServerPlayer serverPlayer)
                    {
                        ItemStack result = inventory.getStackInSlot(9);
                        serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(
                                menu.containerId, menu.incrementStateId(), 9, result));
                    }
                }
            }
        }
    }
}
