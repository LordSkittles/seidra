package com.lordskittles.seidra.common.item;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class SeidraCreativeModeTabs
{
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Seidra.MODID);
	
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = register("main", () -> SeidraBlocks.ARCANE_CRAFTING_BLOCK, List.of(
			SeidraBlocks.ARCANE_CRAFTING_BLOCK,
			SeidraBlocks.WAKESTONE
	));
	
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WORLD = register("world", () -> SeidraBlocks.BISMUTH_ORE, MAIN, List.of(
			SeidraBlocks.ASH_LOG,
			SeidraBlocks.PINE_LOG,
			SeidraBlocks.YEW_LOG,
			SeidraBlocks.ASH_WOOD,
			SeidraBlocks.PINE_WOOD,
			SeidraBlocks.YEW_WOOD,
			
			SeidraBlocks.STRIPPED_ASH_LOG,
			SeidraBlocks.STRIPPED_PINE_LOG,
			SeidraBlocks.STRIPPED_YEW_LOG,
			SeidraBlocks.STRIPPED_ASH_WOOD,
			SeidraBlocks.STRIPPED_PINE_WOOD,
			SeidraBlocks.STRIPPED_YEW_WOOD,
			
			SeidraBlocks.ASH_PLANKS,
			SeidraBlocks.PINE_PLANKS,
			SeidraBlocks.YEW_PLANKS,

			SeidraBlocks.ASH_STAIRS,
			SeidraBlocks.ASH_SLAB,
			SeidraBlocks.ASH_FENCE,
			SeidraBlocks.ASH_FENCE_GATE,
			SeidraBlocks.ASH_BUTTON,
			SeidraBlocks.ASH_PRESSURE_PLATE,

			SeidraBlocks.PINE_STAIRS,
			SeidraBlocks.PINE_SLAB,
			SeidraBlocks.PINE_FENCE,
			SeidraBlocks.PINE_FENCE_GATE,
			SeidraBlocks.PINE_BUTTON,
			SeidraBlocks.PINE_PRESSURE_PLATE,

			SeidraBlocks.YEW_STAIRS,
			SeidraBlocks.YEW_SLAB,
			SeidraBlocks.YEW_FENCE,
			SeidraBlocks.YEW_FENCE_GATE,
			SeidraBlocks.YEW_BUTTON,
			SeidraBlocks.YEW_PRESSURE_PLATE,

			SeidraBlocks.ASH_SAPLING,
			SeidraBlocks.PINE_SAPLING,
			SeidraBlocks.YEW_SAPLING,
			SeidraBlocks.ASH_LEAVES,
			SeidraBlocks.PINE_LEAVES,
			SeidraBlocks.YEW_LEAVES,
			
			SeidraBlocks.BISMUTH_BLOCK,
			SeidraBlocks.SILVER_BLOCK,
			SeidraBlocks.TUNGSTEN_BLOCK,
			SeidraBlocks.RAW_BISMUTH_BLOCK,
			SeidraBlocks.RAW_SILVER_BLOCK,
			SeidraBlocks.RAW_TUNGSTEN_BLOCK,
			SeidraBlocks.AMBER_BLOCK,
			SeidraBlocks.LABRADORITE_BLOCK,
			SeidraBlocks.THULITE_BLOCK,
			
			SeidraBlocks.BISMUTH_ORE,
			SeidraBlocks.SILVER_ORE,
			SeidraBlocks.TUNGSTEN_ORE,
			SeidraBlocks.AMBER_ORE,
			SeidraBlocks.LABRADORITE_ORE,
			SeidraBlocks.THULITE_ORE,
			
			SeidraBlocks.DEEPSLATE_BISMUTH_ORE,
			SeidraBlocks.DEEPSLATE_SILVER_ORE,
			SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE,
			SeidraBlocks.DEEPSLATE_AMBER_ORE,
			SeidraBlocks.DEEPSLATE_LABRADORITE_ORE,
			SeidraBlocks.DEEPSLATE_THULITE_ORE,
			
			SeidraBlocks.FELDSPAR,
			SeidraBlocks.FELDSPAR_BRICK,
			SeidraBlocks.POLISHED_FELDSPAR,
			SeidraBlocks.CRACKED_FELDSPAR,
			SeidraBlocks.CRACKED_FELDSPAR_BRICK,
			SeidraBlocks.CRACKED_POLISHED_FELDSPAR,
			SeidraBlocks.CHISELED_FELDSPAR_BRICK,
			SeidraBlocks.FELDSPAR_PILLAR,
			
			SeidraItems.AMBER_GEM,
			SeidraItems.LABRADORITE_GEM,
			SeidraItems.THULITE_GEM,
			
			SeidraItems.BISMUTH_INGOT,
			SeidraItems.SILVER_INGOT,
			SeidraItems.TUNGSTEN_INGOT,
			
			SeidraItems.RAW_BISMUTH,
			SeidraItems.RAW_SILVER,
			SeidraItems.RAW_TUNGSTEN
	));
	
	private static DeferredHolder<CreativeModeTab, CreativeModeTab> register(String id, Supplier<ItemLike> icon, List<ItemLike> displayItems)
	{
		return TABS.register(id, () -> CreativeModeTab.builder()
				.title(Component.translatable("creativetab.seidra." + id))
				.icon(() -> new ItemStack(icon.get()))
				.displayItems((itemDisplayParameters, output) ->
				{
					for (ItemLike item : displayItems)
					{
						output.accept(item);
					}
				})
				.build()
		);
	}
	
	private static DeferredHolder<CreativeModeTab, CreativeModeTab> register(String id, Supplier<ItemLike> icon, DeferredHolder<CreativeModeTab, CreativeModeTab> after, List<ItemLike> displayItems)
	{
		return TABS.register(id, () -> CreativeModeTab.builder()
				.title(Component.translatable("creativetab.seidra." + id))
				.icon(() -> new ItemStack(icon.get()))
				.displayItems((itemDisplayParameters, output) ->
				{
					for (ItemLike item : displayItems)
					{
						Seidra.LOGGER.debug("Adding item: " + item.toString());
						output.accept(item);
					}
				})
				.withTabsBefore(after.getId())
				.build()
		);
	}
}
