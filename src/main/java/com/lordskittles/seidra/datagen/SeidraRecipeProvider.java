package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SeidraRecipeProvider extends RecipeProvider implements IConditionBuilder
{
	public SeidraRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
	{
		super(output, registries);
	}

	@Override
	protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
	{
		addPlankCraftingFor(Blocks.ASH_PLANKS, Blocks.ASH_LOG, Blocks.ASH_WOOD, recipeOutput);
		addPlankCraftingFor(Blocks.PINE_PLANKS, Blocks.PINE_LOG, Blocks.PINE_WOOD, recipeOutput);
		addPlankCraftingFor(Blocks.YEW_PLANKS, Blocks.YEW_LOG, Blocks.YEW_WOOD, recipeOutput);

		addIngotSmeltingFor(Items.BISMUTH_INGOT, Items.RAW_BISMUTH, Blocks.BISMUTH_ORE, Blocks.DEEPSLATE_BISMUTH_ORE, .7f, 200, recipeOutput);
		addIngotSmeltingFor(Items.SILVER_INGOT, Items.RAW_SILVER, Blocks.SILVER_ORE, Blocks.DEEPSLATE_SILVER_ORE, .7f, 200, recipeOutput);
		addIngotSmeltingFor(Items.TUNGSTEN_INGOT, Items.RAW_TUNGSTEN, Blocks.TUNGSTEN_ORE, Blocks.DEEPSLATE_TUNGSTEN_ORE, 1f, 200, recipeOutput);

		storageBlockRecipe(Blocks.BISMUTH_BLOCK, Items.BISMUTH_INGOT, recipeOutput);
		storageBlockRecipe(Blocks.SILVER_BLOCK, Items.SILVER_INGOT, recipeOutput);
		storageBlockRecipe(Blocks.TUNGSTEN_BLOCK, Items.TUNGSTEN_INGOT, recipeOutput);
		storageBlockRecipe(Blocks.AMBER_BLOCK, Items.AMBER_GEM, recipeOutput);
		storageBlockRecipe(Blocks.THULITE_BLOCK, Items.THULITE_GEM, recipeOutput);
		storageBlockRecipe(Blocks.LABRADORITE_BLOCK, Items.LABRADORITE_GEM, recipeOutput);
	}

	private void storageBlockRecipe(DeferredBlock<?> block, DeferredItem<?> stored, RecipeOutput recipeOutput)
	{
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block.get())
						  .define('I', stored.get())
						  .pattern("III")
						  .pattern("III")
						  .pattern("III")
						  .unlockedBy("has_" + stored.getId().getPath(), has(stored.get()))
						  .save(recipeOutput);

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

	private void addIngotSmeltingFor(DeferredItem<?> ingot, DeferredItem<?> raw, DeferredBlock<?> oreBlock, DeferredBlock<?> deepslateOreBlock, float experience, int baseCookTime, RecipeOutput output)
	{
		String conditionPrefix = "has_";
		String fromSmeltingPrefix = Seidra.MODID + ":" + ingot.getId().getPath() + "_from_smelting_";
		String fromBlastingPrefix = Seidra.MODID + ":" + ingot.getId().getPath() + "_from_blasting_";

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw.get()), RecipeCategory.MISC, ingot.get(), experience, baseCookTime)
								  .unlockedBy(conditionPrefix + raw.getId().getPath(), has(raw.get()))
								  .save(output, fromSmeltingPrefix + raw.getId().getPath());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(oreBlock.get()), RecipeCategory.MISC, ingot.get(), experience, baseCookTime)
								  .unlockedBy(conditionPrefix + oreBlock.getId().getPath(), has(oreBlock.get()))
								  .save(output, fromSmeltingPrefix + oreBlock.getId().getPath());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(deepslateOreBlock.get()), RecipeCategory.MISC, ingot.get(), experience, baseCookTime)
								  .unlockedBy(conditionPrefix + deepslateOreBlock.getId().getPath(), has(deepslateOreBlock.get()))
								  .save(output, fromSmeltingPrefix + deepslateOreBlock.getId().getPath());

		SimpleCookingRecipeBuilder.blasting(Ingredient.of(raw.get()), RecipeCategory.MISC, ingot.get(), experience, baseCookTime / 2)
								  .unlockedBy(conditionPrefix + raw.getId().getPath(), has(raw.get()))
								  .save(output, fromBlastingPrefix + raw.getId().getPath());
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(oreBlock.get()), RecipeCategory.MISC, ingot.get(), experience, baseCookTime / 2)
								  .unlockedBy(conditionPrefix + oreBlock.getId().getPath(), has(oreBlock.get()))
								  .save(output, fromBlastingPrefix + oreBlock.getId().getPath());
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(deepslateOreBlock.get()), RecipeCategory.MISC, ingot.get(), experience, baseCookTime / 2)
								  .unlockedBy(conditionPrefix + deepslateOreBlock.getId().getPath(), has(deepslateOreBlock.get()))
								  .save(output, fromBlastingPrefix + deepslateOreBlock.getId().getPath());
	}
}
