package com.lordskittles.seidra.common.crafting;

import com.lordskittles.seidra.common.crafting.input.ArcaneCraftingInput;
import com.lordskittles.seidra.common.crafting.recipe.ArcaneCraftingRecipe;
import com.lordskittles.seidra.common.crafting.recipe.VanillaRecipeWrapper;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// This is a custom class to handle crafting using arcane crafting and vanilla recipes
public class SeidraCraftingManager
{
    public static Optional<RecipeHolder<? extends Recipe<ArcaneCraftingInput>>> getRecipeFor(ArcaneCraftingInput input, Level level)
    {
        RecipeManager recipeManager = level.getRecipeManager();

        for (RecipeHolder<ArcaneCraftingRecipe> holder : recipeManager.getAllRecipesFor(SeidraRecipes.Types.ARCANE_CRAFTING.get()))
        {
            if (holder.value().matches(input, level))
            {
                return Optional.of(holder);
            }
        }

        for (RecipeHolder<CraftingRecipe> holder : recipeManager.getAllRecipesFor(RecipeType.CRAFTING))
        {
            VanillaRecipeWrapper wrapper = new VanillaRecipeWrapper(holder.value());
            if (wrapper.matches(input, level))
            {
                RecipeHolder<VanillaRecipeWrapper> wrapperHolder = new RecipeHolder<>(holder.id(), wrapper);
                return Optional.of(wrapperHolder);
            }
        }

        return Optional.empty();
    }

    public static List<RecipeHolder<? extends Recipe<ArcaneCraftingInput>>> getAllRecipes(Level level)
    {
        List<RecipeHolder<? extends Recipe<ArcaneCraftingInput>>> allRecipes = new ArrayList<>();
        RecipeManager recipeManager = level.getRecipeManager();

        // Add custom arcane crafting recipes
        for (RecipeHolder<ArcaneCraftingRecipe> holder : recipeManager.getAllRecipesFor(SeidraRecipes.Types.ARCANE_CRAFTING.get()))
        {
            allRecipes.add(holder);
        }

        // Add vanilla crafting recipes as wrapped recipes
        for (RecipeHolder<CraftingRecipe> holder : recipeManager.getAllRecipesFor(RecipeType.CRAFTING))
        {
            VanillaRecipeWrapper wrapper = new VanillaRecipeWrapper(holder.value());
            RecipeHolder<VanillaRecipeWrapper> wrapperHolder = new RecipeHolder<>(holder.id(), wrapper);
            allRecipes.add(wrapperHolder);
        }

        return allRecipes;
    }
}
