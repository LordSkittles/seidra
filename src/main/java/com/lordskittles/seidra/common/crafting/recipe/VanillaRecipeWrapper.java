package com.lordskittles.seidra.common.crafting.recipe;

import com.lordskittles.seidra.common.crafting.input.ArcaneCraftingInput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class VanillaRecipeWrapper implements Recipe<ArcaneCraftingInput>
{
    private final CraftingRecipe wrappedRecipe;

    public VanillaRecipeWrapper(CraftingRecipe recipe)
    {
        this.wrappedRecipe = recipe;
    }

    @Override
    public boolean matches(ArcaneCraftingInput input, @NotNull Level level)
    {
        // Convert ArcaneCraftingInput to CraftingInput for vanilla recipe matching
        CraftingInput craftingInput = CraftingInput.of(input.width(), input.height(), input.items());
        return this.wrappedRecipe.matches(craftingInput, level);
    }

    @Override
    public @NotNull ItemStack assemble(ArcaneCraftingInput input, HolderLookup.@NotNull Provider registries)
    {
        CraftingInput craftingInput = CraftingInput.of(input.width(), input.height(), input.items());
        return this.wrappedRecipe.assemble(craftingInput, registries);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return this.wrappedRecipe.canCraftInDimensions(width, height);
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider registries)
    {
        return this.wrappedRecipe.getResultItem(registries);
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer()
    {
        return this.wrappedRecipe.getSerializer();
    }

    @Override
    public @NotNull RecipeType<?> getType()
    {
        return this.wrappedRecipe.getType();
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients()
    {
        return this.wrappedRecipe.getIngredients();
    }

    @Override
    public @NotNull String getGroup()
    {
        return this.wrappedRecipe.getGroup();
    }

    public CraftingBookCategory category()
    {
        return this.wrappedRecipe.category();
    }

    @Override
    public boolean showNotification()
    {
        return this.wrappedRecipe.showNotification();
    }

    public CraftingRecipe getWrappedRecipe()
    {
        return this.wrappedRecipe;
    }

    public int getSaiCost()
    {
        return 0; // Vanilla recipes don't have sai cost
    }
}
