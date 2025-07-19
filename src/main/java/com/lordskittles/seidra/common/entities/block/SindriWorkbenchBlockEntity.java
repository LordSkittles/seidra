package com.lordskittles.seidra.common.entities.block;

import static com.lordskittles.seidra.Constants.*;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.crafting.SeidraCraftingManager;
import com.lordskittles.seidra.common.crafting.input.ArcaneCraftingInput;
import com.lordskittles.seidra.common.crafting.recipe.ArcaneCraftingRecipe;
import com.lordskittles.seidra.common.entities.SeidraBlockEntityTypes;
import com.lordskittles.seidra.common.menu.container.SindriWorkbenchBlockMenu;
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

public class SindriWorkbenchBlockEntity extends SeidraBlockEntity implements MenuProvider
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

                if (slot < OUTPUT_SLOT)
                {
                    if (!shouldIgnoreChanges)
                    {
                        needsCraftingUpdate = true;
                    }
                }
                else
                {
                    if(getStackInSlot(OUTPUT_SLOT).isEmpty())
                    {
                        if(!lastResult.isEmpty() && !shouldIgnoreChanges)
                        {
                            shouldIgnoreChanges = true;
                            for (int i = 0; i < OUTPUT_SLOT; i++)
                            {
                                getStackInSlot(i).shrink(1);
                            }
                            shouldIgnoreChanges = false;
                        }

                        lastResult = ItemStack.EMPTY;
                        needsCraftingUpdate = true;
                    }
                }
            }
        }
    };
    public static final int OUTPUT_SLOT = 9;
    public ItemStack lastResult = ItemStack.EMPTY;

    private boolean needsCraftingUpdate = false;
    private boolean shouldIgnoreChanges = false;

    public SindriWorkbenchBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(SeidraBlockEntityTypes.SINDRI_WORKBENCH_BE.get(), pos, blockState);
    }

    public void clearContents()
    {
        for (int i = 0; i < inventory.getSlots(); i++)
        {
            inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    @Override
    public void dropContents()
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
        return Component.translatable(buildName(Groups.BLOCK + Groups.ENTITY, Seidra.MODID, Types.SINDRI));
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory, @NotNull Player player)
    {
        assert level != null;
        return new SindriWorkbenchBlockMenu(containerId, inventory, this);
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
        boolean hasAnyItems = false;

        for (int i = 0; i < OUTPUT_SLOT; i++)
        {
            ItemStack stack = inventory.getStackInSlot(i);
            items.add(stack);
            if (!stack.isEmpty())
            {
                hasAnyItems = true;
            }
        }

        ItemStack newResult = ItemStack.EMPTY;

        // Only try to craft if there are actually items in the grid
        if (hasAnyItems)
        {
            int availableSai = Integer.MAX_VALUE;
            ArcaneCraftingInput input = ArcaneCraftingInput.of(3, 3, items, availableSai);
            assert level != null;
            Optional<RecipeHolder<? extends Recipe<ArcaneCraftingInput>>> foundRecipe = SeidraCraftingManager.getRecipeFor(input, level);

            if (foundRecipe.isPresent())
            {
                Recipe<ArcaneCraftingInput> recipe = foundRecipe.get().value();

                boolean canCraft = true;
                if(recipe instanceof ArcaneCraftingRecipe arcaneRecipe)
                {
                    canCraft = availableSai >= arcaneRecipe.saiCost();
                }

                if(canCraft)
                {
                    ItemStack result = recipe.assemble(input, level.registryAccess());
                    if (result.isItemEnabled(level.enabledFeatures()))
                    {
                        newResult = result;
                    }
                }
            }
        }

        if (!ItemStack.isSameItemSameComponents(lastResult, newResult))
        {
            shouldIgnoreChanges = true;
            lastResult = newResult.copy();
            inventory.setStackInSlot(OUTPUT_SLOT, newResult);
            shouldIgnoreChanges = false;
            setChanged();

            notifyOpenMenus();
        }
    }

    public int calculateMaxCrafts(int maxCount)
    {
        if (lastResult.isEmpty()) return 0;

        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < OUTPUT_SLOT; i++)
        {
            items.add(inventory.getStackInSlot(i));
        }

        int availableSai = Integer.MAX_VALUE;
        ArcaneCraftingInput input = ArcaneCraftingInput.of(3, 3, items, availableSai);
        assert level != null;
        Optional<RecipeHolder<? extends Recipe<ArcaneCraftingInput>>> foundRecipe = SeidraCraftingManager.getRecipeFor(input, level);

        if (foundRecipe.isEmpty()) return 0;

        Recipe<ArcaneCraftingInput> recipe = foundRecipe.get().value();

        // Calculate how many we can actually craft
        int possibleCrafts = maxCount;

        // Check ingredient limits
        for (int i = 0; i < OUTPUT_SLOT; i++)
        {
            ItemStack ingredient = inventory.getStackInSlot(i);
            if (!ingredient.isEmpty())
            {
                possibleCrafts = Math.min(possibleCrafts, ingredient.getCount());
            }
        }

        // Check sai cost if applicable
        if (recipe instanceof ArcaneCraftingRecipe arcaneRecipe)
        {
            int saiCrafts = availableSai / arcaneRecipe.saiCost();
            possibleCrafts = Math.min(possibleCrafts, saiCrafts);
        }

        return Math.max(0, possibleCrafts);
    }

    public void consumeIngredients(int count)
    {
        if (count <= 0) return;

        shouldIgnoreChanges = true;
        for (int i = 0; i < OUTPUT_SLOT; i++)
        {
            ItemStack ingredient = inventory.getStackInSlot(i);
            if (!ingredient.isEmpty())
            {
                ingredient.shrink(count);
            }
        }
        shouldIgnoreChanges = false;

        // Don't set needsCraftingUpdate here - we'll handle it manually in shift-click
    }

    public void updateCraftingResultForShiftClick()
    {
        // Force an immediate crafting update without waiting for tick
        needsCraftingUpdate = false;
        updateCraftingResult();
    }

    private void notifyOpenMenus()
    {
        assert level != null;
        for (Player player : level.players())
        {
            if (player.containerMenu instanceof SindriWorkbenchBlockMenu menu)
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
