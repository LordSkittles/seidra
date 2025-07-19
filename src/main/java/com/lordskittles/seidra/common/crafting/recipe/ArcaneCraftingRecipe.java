package com.lordskittles.seidra.common.crafting.recipe;

import com.lordskittles.seidra.common.crafting.SeidraRecipes;
import com.lordskittles.seidra.common.crafting.input.ArcaneCraftingInput;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record ArcaneCraftingRecipe(String group, ShapedRecipePattern pattern, ItemStack result, int saiCost, boolean showNotification) implements Recipe<ArcaneCraftingInput>
{
    @Override
    public boolean matches(ArcaneCraftingInput input, @NotNull Level level)
    {
        return this.pattern.matches(input.toCraftingInput());
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull ArcaneCraftingInput arcaneCraftingInput, HolderLookup.@NotNull Provider provider)
    {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider provider)
    {
        return this.result;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients()
    {
        return this.pattern.ingredients();
    }

    @Override
    public boolean showNotification()
    {
        return this.showNotification;
    }

    public int getWidth()
    {
        return this.pattern.width();
    }

    public int getHeight()
    {
        return this.pattern.height();
    }

    public int getSaiCost()
    {
        return this.saiCost;
    }

    @Override
    public String group()
    {
        return this.group;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer()
    {
        return SeidraRecipes.Serializers.ARCANE_CRAFTING.get();
    }

    @Override
    public @NotNull RecipeType<?> getType()
    {
        return SeidraRecipes.Types.ARCANE_CRAFTING.get();
    }

    public static class Serializer implements RecipeSerializer<ArcaneCraftingRecipe>
    {
        public static final MapCodec<ArcaneCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(
                builder -> builder.group(
                        Codec.STRING.fieldOf("group").forGetter(ArcaneCraftingRecipe::getGroup),
                        ShapedRecipePattern.MAP_CODEC.forGetter(ArcaneCraftingRecipe::pattern),
                        ItemStack.CODEC.fieldOf("result").forGetter(ArcaneCraftingRecipe::result),
                        Codec.INT.fieldOf("sai").forGetter(ArcaneCraftingRecipe::saiCost),
                        Codec.BOOL.fieldOf("showNotification").forGetter(ArcaneCraftingRecipe::showNotification)
                ).apply(builder, ArcaneCraftingRecipe::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, ArcaneCraftingRecipe> STREAM_CODEC = StreamCodec.composite(
                StreamCodec.of(FriendlyByteBuf::writeUtf, FriendlyByteBuf::readUtf), ArcaneCraftingRecipe::group,
                ShapedRecipePattern.STREAM_CODEC, ArcaneCraftingRecipe::pattern,
                ItemStack.STREAM_CODEC, ArcaneCraftingRecipe::result,
                StreamCodec.of(FriendlyByteBuf::writeVarInt, FriendlyByteBuf::readVarInt), ArcaneCraftingRecipe::saiCost,
                StreamCodec.of(FriendlyByteBuf::writeBoolean, FriendlyByteBuf::readBoolean), ArcaneCraftingRecipe::showNotification,
                ArcaneCraftingRecipe::new
        );

        @Override
        public @NotNull MapCodec<ArcaneCraftingRecipe> codec()
        {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, ArcaneCraftingRecipe> streamCodec()
        {
            return STREAM_CODEC;
        }
    }
}
