package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.item.SeidraItems;
import com.lordskittles.seidra.common.tag.ItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.lordskittles.seidra.Names.modRes;

public class SeidraRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public SeidraRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        addPlankCraftingFor(SeidraBlocks.ASH_PLANKS, SeidraBlocks.ASH_LOG, SeidraBlocks.ASH_WOOD, recipeOutput);
        addPlankCraftingFor(SeidraBlocks.PINE_PLANKS, SeidraBlocks.PINE_LOG, SeidraBlocks.PINE_WOOD, recipeOutput);
        addPlankCraftingFor(SeidraBlocks.YEW_PLANKS, SeidraBlocks.YEW_LOG, SeidraBlocks.YEW_WOOD, recipeOutput);

        addIngotSmeltingFor(SeidraItems.BISMUTH_INGOT, new Pair<>(SeidraItems.RAW_BISMUTH.getId(), ItemTags.RAW_BISMUTH),
                new Pair<>(SeidraBlocks.BISMUTH_ORE.getId(), ItemTags.BISMUTH_ORE), .7f, recipeOutput);
        addIngotSmeltingFor(SeidraItems.SILVER_INGOT, new Pair<>(SeidraItems.RAW_SILVER.getId(), ItemTags.RAW_SILVER),
                new Pair<>(SeidraBlocks.SILVER_ORE.getId(), ItemTags.SILVER_ORE), .7f, recipeOutput);
        addIngotSmeltingFor(SeidraItems.TUNGSTEN_INGOT, new Pair<>(SeidraItems.RAW_TUNGSTEN.getId(), ItemTags.RAW_TUNGSTEN),
                new Pair<>(SeidraBlocks.TUNGSTEN_ORE.getId(), ItemTags.TUNGSTEN_ORE), 1f, recipeOutput);

        storageBlockRecipe(SeidraBlocks.BISMUTH_BLOCK, SeidraItems.BISMUTH_INGOT, recipeOutput, ItemTags.BISMUTH_INGOT);
        storageBlockRecipe(SeidraBlocks.SILVER_BLOCK, SeidraItems.SILVER_INGOT, recipeOutput, ItemTags.SILVER_INGOT);
        storageBlockRecipe(SeidraBlocks.TUNGSTEN_BLOCK, SeidraItems.TUNGSTEN_INGOT, recipeOutput, ItemTags.TUNGSTEN_INGOT);
        storageBlockRecipe(SeidraBlocks.RAW_BISMUTH_BLOCK, SeidraItems.RAW_BISMUTH, recipeOutput, ItemTags.RAW_BISMUTH);
        storageBlockRecipe(SeidraBlocks.RAW_SILVER_BLOCK, SeidraItems.RAW_SILVER, recipeOutput, ItemTags.RAW_SILVER);
        storageBlockRecipe(SeidraBlocks.RAW_TUNGSTEN_BLOCK, SeidraItems.RAW_TUNGSTEN, recipeOutput, ItemTags.RAW_TUNGSTEN);
        storageBlockRecipe(SeidraBlocks.AMBER_BLOCK, SeidraItems.AMBER_GEM, recipeOutput, ItemTags.AMBER);
        storageBlockRecipe(SeidraBlocks.LABRADORITE_BLOCK, SeidraItems.LABRADORITE_GEM, recipeOutput, ItemTags.LABRADORITE);
        storageBlockRecipe(SeidraBlocks.THULITE_BLOCK, SeidraItems.THULITE_GEM, recipeOutput, ItemTags.THULITE);

        simpleRecipe2x2(RecipeCategory.BUILDING_BLOCKS, SeidraBlocks.POLISHED_FELDSPAR, SeidraBlocks.FELDSPAR, recipeOutput);
        simpleRecipe2x2(RecipeCategory.BUILDING_BLOCKS, SeidraBlocks.FELDSPAR_BRICK, SeidraBlocks.POLISHED_FELDSPAR, recipeOutput);
        simpleRecipe2x2(RecipeCategory.BUILDING_BLOCKS, SeidraBlocks.CHISELED_FELDSPAR_BRICK, SeidraBlocks.FELDSPAR_BRICK, recipeOutput);
        simpleRecipe2x2(RecipeCategory.BUILDING_BLOCKS, SeidraBlocks.FELDSPAR_PILLAR, SeidraBlocks.CHISELED_FELDSPAR_BRICK, recipeOutput);

        feldsparGroupRecipe(RecipeCategory.DECORATIONS, SeidraBlocks.FELDSPAR, List.of(
                SeidraBlocks.FELDSPAR_BRICK,
                SeidraBlocks.POLISHED_FELDSPAR,
                SeidraBlocks.CHISELED_FELDSPAR_BRICK,
                SeidraBlocks.FELDSPAR_PILLAR
        ), recipeOutput);

        feldsparGroupRecipe(RecipeCategory.DECORATIONS, SeidraBlocks.CRACKED_FELDSPAR, List.of(
                SeidraBlocks.CRACKED_FELDSPAR_BRICK,
                SeidraBlocks.CRACKED_POLISHED_FELDSPAR
        ), recipeOutput);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(SeidraBlocks.FELDSPAR.get()), RecipeCategory.DECORATIONS, SeidraBlocks.CRACKED_FELDSPAR.get(), 0.1f, 200)
                .unlockedBy("has_feldspar", has(SeidraBlocks.FELDSPAR.get()))
                .save(recipeOutput, modRes("cracked_feldspar_from_feldspar"));
    }

    private void simpleRecipe2x2(RecipeCategory category, DeferredBlock<?> output, DeferredBlock<?> input, RecipeOutput recipeOutput)
    {
        ShapedRecipeBuilder.shaped(category, output.get(), 4)
                .define('I', input.get())
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_" + input.getId().getPath(), has(input.get()))
                .save(recipeOutput);
    }

    private void tagRecipe2x2(RecipeCategory category, DeferredBlock<?> output, TagKey<Item> input, ResourceLocation id, RecipeOutput recipeOutput)
    {
        ShapedRecipeBuilder.shaped(category, output.get(), 4)
                .define('I', input)
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_" + id.getPath(), has(input))
                .save(recipeOutput);
    }

    private void feldsparGroupRecipe(RecipeCategory category, DeferredBlock<?> input, List<DeferredBlock<?>> outputs, RecipeOutput recipeOutput)
    {
        for (DeferredBlock<?> deferredBlock : outputs)
        {
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(input.get()), category, deferredBlock.get())
                    .unlockedBy("has_" + input.getId().getPath(), has(input.get()))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                            Seidra.MODID, deferredBlock.getId().getPath() + "_from_" + input.getId().getPath()
                    ));

            SingleItemRecipeBuilder.stonecutting(Ingredient.of(deferredBlock.get()), category, input.get())
                    .unlockedBy("has_" + input.getId().getPath(), has(input.get()))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(
                            Seidra.MODID, input.getId().getPath() + "_from_" + deferredBlock.getId().getPath()
                    ));
        }
    }

    private void storageBlockRecipe(DeferredBlock<?> block, DeferredItem<?> stored, RecipeOutput recipeOutput)
    {
        storageBlockRecipe(block, stored, recipeOutput, null);
    }

    private void storageBlockRecipe(DeferredBlock<?> block, DeferredItem<?> stored, RecipeOutput recipeOutput, TagKey<Item> storedKey)
    {
        if(storedKey == null)
        {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block.get())
                    .define('I', stored)
                    .pattern("III")
                    .pattern("III")
                    .pattern("III")
                    .unlockedBy("has_" + stored.getId().getPath(), has(stored.get()))
                    .save(recipeOutput);
        }
        else
        {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block.get())
                    .define('I', storedKey)
                    .pattern("III")
                    .pattern("III")
                    .pattern("III")
                    .unlockedBy("has_" + stored.getId().getPath(), has(stored.get()))
                    .save(recipeOutput);
        }

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, stored.get(), 9)
                .requires(block.get())
                .unlockedBy("has_" + block.getId().getPath(), has(block.get()))
                .save(recipeOutput, Seidra.MODID + ":" + stored.getId().getPath() + "_from_block");
    }

    private void addPlankCraftingFor(DeferredBlock<?> plank, DeferredBlock<?> log, DeferredBlock<?> wood, RecipeOutput recipeOutput)
    {
        String condition = "has_" + log.getId().getPath();
        String fromLogName = Seidra.MODID + ":" + plank.getId().getPath() + "_from_log";
        String fromWoodName = Seidra.MODID + ":" + plank.getId().getPath() + "_from_wood";

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plank, 4)
                .requires(log)
                .unlockedBy(condition, has(log))
                .save(recipeOutput, fromLogName);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plank, 4)
                .requires(wood)
                .unlockedBy(condition, has(log))
                .save(recipeOutput, fromWoodName);
    }

    private void addIngotSmeltingFor(DeferredItem<?> ingot, Pair<ResourceLocation, TagKey<Item>> raw, Pair<ResourceLocation, TagKey<Item>> oreBlock, float experience, RecipeOutput output)
    {
        String conditionPrefix = "has_";
        String fromSmeltingPrefix = Seidra.MODID + ":" + ingot.getId().getPath() + "_from_smelting_";
        String fromBlastingPrefix = Seidra.MODID + ":" + ingot.getId().getPath() + "_from_blasting_";

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw.getB()), RecipeCategory.MISC, ingot.get(), experience, 200)
                .unlockedBy(conditionPrefix + raw.getA().getPath(), has(raw.getB()))
                .save(output, fromSmeltingPrefix + raw.getA().getPath());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(oreBlock.getB()), RecipeCategory.MISC, ingot.get(), experience, 200)
                .unlockedBy(conditionPrefix + oreBlock.getA().getPath(), has(oreBlock.getB()))
                .save(output, fromSmeltingPrefix + oreBlock.getA().getPath());

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(raw.getB()), RecipeCategory.MISC, ingot.get(), experience, 100)
                .unlockedBy(conditionPrefix + raw.getA().getPath(), has(raw.getB()))
                .save(output, fromBlastingPrefix + raw.getA().getPath());
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(oreBlock.getB()), RecipeCategory.MISC, ingot.get(), experience, 100)
                .unlockedBy(conditionPrefix + oreBlock.getA().getPath(), has(oreBlock.getB()))
                .save(output, fromBlastingPrefix + oreBlock.getA().getPath());
    }
}
