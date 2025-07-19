package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.item.SeidraItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SeidraBlockLootTableProvider extends BlockLootSubProvider
{
	protected SeidraBlockLootTableProvider(HolderLookup.Provider registries)
	{
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
	}
	
	@Override
	protected void generate()
	{
		dropSelf(SeidraBlocks.ASH_LOG);
		dropSelf(SeidraBlocks.PINE_LOG);
		dropSelf(SeidraBlocks.YEW_LOG);
		
		dropSelf(SeidraBlocks.ASH_WOOD);
		dropSelf(SeidraBlocks.PINE_WOOD);
		dropSelf(SeidraBlocks.YEW_WOOD);
		
		dropSelf(SeidraBlocks.STRIPPED_ASH_LOG);
		dropSelf(SeidraBlocks.STRIPPED_PINE_LOG);
		dropSelf(SeidraBlocks.STRIPPED_YEW_LOG);
		
		dropSelf(SeidraBlocks.STRIPPED_ASH_WOOD);
		dropSelf(SeidraBlocks.STRIPPED_PINE_WOOD);
		dropSelf(SeidraBlocks.STRIPPED_YEW_WOOD);
		
		dropSelf(SeidraBlocks.ASH_PLANKS);
		dropSelf(SeidraBlocks.PINE_PLANKS);
		dropSelf(SeidraBlocks.YEW_PLANKS);
		
		dropSelf(SeidraBlocks.ASH_SAPLING.get());
		dropSelf(SeidraBlocks.PINE_SAPLING.get());
		dropSelf(SeidraBlocks.YEW_SAPLING.get());
		
		leafDrop(SeidraBlocks.ASH_LEAVES, SeidraBlocks.ASH_SAPLING);
		leafDrop(SeidraBlocks.PINE_LEAVES, SeidraBlocks.PINE_SAPLING);
		leafDrop(SeidraBlocks.YEW_LEAVES, SeidraBlocks.YEW_SAPLING);
		
		dropSelf(SeidraBlocks.BISMUTH_BLOCK);
		dropSelf(SeidraBlocks.SILVER_BLOCK);
		dropSelf(SeidraBlocks.TUNGSTEN_BLOCK);
		dropSelf(SeidraBlocks.RAW_BISMUTH_BLOCK);
		dropSelf(SeidraBlocks.RAW_SILVER_BLOCK);
		dropSelf(SeidraBlocks.RAW_TUNGSTEN_BLOCK);
		dropSelf(SeidraBlocks.AMBER_BLOCK);
		dropSelf(SeidraBlocks.LABRADORITE_BLOCK);
		dropSelf(SeidraBlocks.THULITE_BLOCK);
		
		createMultipleOreDrops(SeidraBlocks.BISMUTH_ORE, SeidraItems.RAW_BISMUTH, 2, 5);
		createOreDrops(SeidraBlocks.SILVER_ORE, SeidraItems.RAW_SILVER);
		createOreDrops(SeidraBlocks.TUNGSTEN_ORE, SeidraItems.RAW_TUNGSTEN);
		
		createMultipleOreDrops(SeidraBlocks.DEEPSLATE_BISMUTH_ORE, SeidraItems.RAW_BISMUTH, 2, 5);
		createOreDrops(SeidraBlocks.DEEPSLATE_SILVER_ORE, SeidraItems.RAW_SILVER);
		createOreDrops(SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE, SeidraItems.RAW_TUNGSTEN);
		
		createMultipleOreDrops(SeidraBlocks.AMBER_ORE, SeidraItems.AMBER_GEM, 4, 5);
		createOreDrops(SeidraBlocks.LABRADORITE_ORE, SeidraItems.LABRADORITE_GEM);
		createOreDrops(SeidraBlocks.THULITE_ORE, SeidraItems.THULITE_GEM);
		
		createMultipleOreDrops(SeidraBlocks.DEEPSLATE_AMBER_ORE, SeidraItems.AMBER_GEM, 4, 5);
		createOreDrops(SeidraBlocks.DEEPSLATE_LABRADORITE_ORE, SeidraItems.LABRADORITE_GEM);
		createOreDrops(SeidraBlocks.DEEPSLATE_THULITE_ORE, SeidraItems.THULITE_GEM);
		
		dropSelf(SeidraBlocks.FELDSPAR);
		dropSelf(SeidraBlocks.FELDSPAR_BRICK);
		dropSelf(SeidraBlocks.POLISHED_FELDSPAR);
		dropSelf(SeidraBlocks.CRACKED_FELDSPAR);
		dropSelf(SeidraBlocks.CRACKED_FELDSPAR_BRICK);
		dropSelf(SeidraBlocks.CRACKED_POLISHED_FELDSPAR);
		dropSelf(SeidraBlocks.CHISELED_FELDSPAR_BRICK);
		dropSelf(SeidraBlocks.FELDSPAR_PILLAR);
		
		dropSelf(SeidraBlocks.WAKESTONE.get());
		dropSelf(SeidraBlocks.SINDRI_WORKBENCH.get());
		
		add(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), this::createSlabItemTable);
		dropSelf(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);

		woodGroup(SeidraBlocks.ASH_STAIRS, SeidraBlocks.ASH_SLAB, SeidraBlocks.ASH_FENCE, SeidraBlocks.ASH_FENCE_GATE, SeidraBlocks.ASH_BUTTON, SeidraBlocks.ASH_PRESSURE_PLATE);
		woodGroup(SeidraBlocks.PINE_STAIRS, SeidraBlocks.PINE_SLAB, SeidraBlocks.PINE_FENCE, SeidraBlocks.PINE_FENCE_GATE, SeidraBlocks.PINE_BUTTON, SeidraBlocks.PINE_PRESSURE_PLATE);
		woodGroup(SeidraBlocks.YEW_STAIRS, SeidraBlocks.YEW_SLAB, SeidraBlocks.YEW_FENCE, SeidraBlocks.YEW_FENCE_GATE, SeidraBlocks.YEW_BUTTON, SeidraBlocks.YEW_PRESSURE_PLATE);

		stoneGroup(SeidraBlocks.FELDSPAR_STAIRS, SeidraBlocks.FELDSPAR_SLAB, SeidraBlocks.FELDSPAR_WALL);
		stoneGroup(SeidraBlocks.FELDSPAR_BRICK_STAIRS, SeidraBlocks.FELDSPAR_BRICK_SLAB, SeidraBlocks.FELDSPAR_BRICK_WALL);
		stoneGroup(SeidraBlocks.POLISHED_FELDSPAR_STAIRS, SeidraBlocks.POLISHED_FELDSPAR_SLAB, SeidraBlocks.POLISHED_FELDSPAR_WALL);

		dropSelf(SeidraBlocks.FELDSPAR_BUTTON);
		dropSelf(SeidraBlocks.FELDSPAR_PRESSURE_PLATE);
	}
	
	protected void createOreDrops(DeferredBlock<?> block, DeferredItem<?> drop)
	{
		HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(block.get(), this.createSilkTouchDispatchTable(
				block.get(),
				this.applyExplosionDecay(drop.get(), LootItem.lootTableItem(drop.get())
						.apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
				)
		));
	}
	
	protected void createMultipleOreDrops(DeferredBlock<?> block, DeferredItem<?> drop, float minDrops, float maxDrops)
	{
		HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		add(block.get(), this.createSilkTouchDispatchTable(
				block.get(),
				this.applyExplosionDecay(block.get(), LootItem.lootTableItem(drop.get())
						.apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
						.apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
				)
		));
	}
	
	protected void dropSelf(@NotNull DeferredBlock<Block> block)
	{
		super.dropSelf(block.get());
	}
	
	protected void dropOre(@NotNull DeferredBlock<Block> block, @NotNull DeferredItem<Item> drop)
	{
		add(block.get(), this.createOreDrop(block.get(), drop.get()));
	}
	
	protected void leafDrop(@NotNull DeferredBlock<Block> block, @NotNull DeferredBlock<?> drop)
	{
		add(block.get(), this.createLeavesDrops(block.get(), drop.get(), NORMAL_LEAVES_SAPLING_CHANCES));
	}

	private void woodGroup(DeferredBlock<Block> stair, DeferredBlock<Block> slab, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> button, DeferredBlock<Block> pressurePlate)
	{
		dropSelf(stair);
		add(slab.get(), this::createSlabItemTable);
		dropSelf(fence);
		dropSelf(fenceGate);
		dropSelf(button);
		dropSelf(pressurePlate);
	}

	private void stoneGroup(DeferredBlock<Block> stair, DeferredBlock<Block> slab, DeferredBlock<Block> wall)
	{
		dropSelf(stair);
		add(slab.get(), this::createSlabItemTable);
		dropSelf(wall);
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks()
	{
		return SeidraBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
	}
}
