package com.lordskittles.seidra.datagen.builders;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.lordskittles.seidra.common.crafting.recipe.ArcaneCraftingRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ArcaneCraftingRecipeBuilder implements RecipeBuilder
{
    private final RecipeCategory category;

    private final Item result;
    private final ItemStack resultStack;

    private final int saiCost;
    private final Map<Character, Ingredient> key;
    private final List<String> rows;
    private final Map<String, Criterion<?>> criteria;
    @Nullable
    private String group;
    private boolean showNotification;

    private ArcaneCraftingRecipeBuilder(RecipeCategory category, ItemLike result, int count, int saiCost)
    {
        this(category, new ItemStack(result, count), saiCost);
    }

    private ArcaneCraftingRecipeBuilder(RecipeCategory category, ItemStack result, int saiCost)
    {
        this.rows = Lists.newArrayList();
        this.key = Maps.newLinkedHashMap();
        this.criteria = new LinkedHashMap<>();

        this.showNotification = true;
        this.category = category;

        this.result = result.getItem();
        this.resultStack = result;
        this.saiCost = saiCost;
    }

    public static ArcaneCraftingRecipeBuilder of(RecipeCategory category, ItemLike result, int count, int saiCost)
    {
        return new ArcaneCraftingRecipeBuilder(category, result, count, saiCost);
    }

    public ArcaneCraftingRecipeBuilder define(Character symbol, TagKey<Item> tag)
    {
        return this.define(symbol, Ingredient.of(tag));
    }

    public ArcaneCraftingRecipeBuilder define(Character symbol, ItemLike item)
    {
        return this.define(symbol, Ingredient.of(item));
    }

    public ArcaneCraftingRecipeBuilder define(Character symbol, Ingredient ingredient)
    {
        if (this.key.containsKey(symbol))
        {
            throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined");
        }
        else if (symbol == ' ')
        {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        }

        this.key.put(symbol, ingredient);
        return this;
    }

    public ArcaneCraftingRecipeBuilder pattern(String pattern)
    {
        if (!this.rows.isEmpty() && pattern.length() != this.rows.getFirst().length())
        {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        }

        this.rows.add(pattern);
        return this;
    }

    @Override
    public @NotNull ArcaneCraftingRecipeBuilder unlockedBy(@NotNull String name, @NotNull Criterion<?> criterion)
    {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public @NotNull ArcaneCraftingRecipeBuilder group(@Nullable String group)
    {
        this.group = group;
        return this;
    }

    public ArcaneCraftingRecipeBuilder showNotification(boolean showNotification)
    {
        this.showNotification = showNotification;
        return this;
    }

    @Override
    public @NotNull Item getResult()
    {
        return this.result;
    }

    @Override
    public void save(@NotNull RecipeOutput recipeOutput, @NotNull ResourceLocation id)
    {
        ShapedRecipePattern pattern = this.ensureValid(id);
        Advancement.Builder advancement$builder = Advancement.Builder.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);

        Objects.requireNonNull(advancement$builder);
        this.criteria.forEach(advancement$builder::addCriterion);

        ArcaneCraftingRecipe recipe = new ArcaneCraftingRecipe(
                Objects.requireNonNullElse(this.group, ""), pattern,
                this.resultStack, this.saiCost, this.showNotification
        );

        recipeOutput.accept(id, recipe, advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private ShapedRecipePattern ensureValid(ResourceLocation location)
    {
        if (this.criteria.isEmpty())
        {
            throw new IllegalStateException("No way of obtaining recipe " + location.toString());
        }
        else
        {
            return ShapedRecipePattern.of(this.key, this.rows);
        }
    }
}
