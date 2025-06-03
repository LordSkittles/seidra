package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.registries.Blocks;
import com.lordskittles.seidra.registries.Items;
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
		addPlankCraftingFor(Blocks.JUNIPER_PLANKS, Blocks.JUNIPER_LOG, Blocks.JUNIPER_WOOD, recipeOutput);
		addPlankCraftingFor(Blocks.PINE_PLANKS, Blocks.PINE_LOG, Blocks.PINE_WOOD, recipeOutput);
		addPlankCraftingFor(Blocks.YEW_PLANKS, Blocks.YEW_LOG, Blocks.YEW_WOOD, recipeOutput);

		addIngotSmeltingFor(Items.BISMUTH_INGOT, Items.RAW_BISMUTH, Blocks.BISMUTH_ORE, Blocks.DEEPSLATE_BISMUTH_ORE, .7f, 200, recipeOutput);
		addIngotSmeltingFor(Items.COBALT_INGOT, Items.RAW_COBALT, Blocks.COBALT_ORE, Blocks.DEEPSLATE_COBALT_ORE, .7f, 200, recipeOutput);
		addIngotSmeltingFor(Items.TUNGSTEN_INGOT, Items.RAW_TUNGSTEN, Blocks.TUNGSTEN_ORE, Blocks.DEEPSLATE_TUNGSTEN_ORE, 1f, 200, recipeOutput);
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
