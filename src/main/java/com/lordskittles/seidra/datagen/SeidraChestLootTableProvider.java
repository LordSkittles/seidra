package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class SeidraChestLootTableProvider implements LootTableSubProvider
{
	public SeidraChestLootTableProvider(HolderLookup.Provider provider)
	{

	}

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output)
	{
		add(output, "crumbled_pillar", LootTable.lootTable()
													  .withPool(LootPool.lootPool()
																		.setRolls(ConstantValue.exactly(3))
																		.add(LootItem.lootTableItem(Items.BONE)
																					 .setWeight(5)
																					 .apply(SetItemCountFunction.setCount(
																									 UniformGenerator.between(3, 10)
																							 )
																					 )
																		)
													  )
		);
	}

	private void add(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output, String name, LootTable.Builder builder)
	{
		ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "chest/" + name));
		output.accept(key, builder);
	}
}
