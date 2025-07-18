package com.lordskittles.seidra.common.crafting;

import com.lordskittles.seidra.Constants;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.crafting.recipe.ArcaneCraftingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SeidraRecipes
{
    public static class Types
    {
        public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Seidra.MODID);

        public static final DeferredHolder<RecipeType<?>, RecipeType<ArcaneCraftingRecipe>> ARCANE_CRAFTING = register(Constants.Types.ARCANE_CRAFTING);

        private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> register(String id)
        {
            return TYPES.register(id, () -> new RecipeType<T>()
            {
                @Override
                public String toString()
                {
                    return id;
                }
            });
        }
    }

    public static class Serializers
    {
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Seidra.MODID);

        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ArcaneCraftingRecipe>> ARCANE_CRAFTING =
                register(Constants.Types.ARCANE_CRAFTING, ArcaneCraftingRecipe.Serializer::new);

        private static <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> register(String id, Supplier<RecipeSerializer<T>> supplier)
        {
            return SERIALIZERS.register(id, supplier);
        }
    }
}
