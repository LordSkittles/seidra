package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.registries.Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class SeidraRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public SeidraRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.JUNIPER_PLANKS, 4)
                .requires(Blocks.JUNIPER_LOG)
                .unlockedBy("has_juniper_log", has(Blocks.JUNIPER_LOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.PINE_PLANKS, 4)
                .requires(Blocks.PINE_LOG)
                .unlockedBy("has_pine_log", has(Blocks.PINE_LOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.YEW_PLANKS, 4)
                .requires(Blocks.YEW_LOG)
                .unlockedBy("has_yew_log", has(Blocks.YEW_LOG)).save(recipeOutput);
    }
}
