package com.lordskittles.seidra.common.item;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;

import java.util.function.Supplier;

public class SeidraRawOre extends SeidraItem
{
	public SeidraRawOre(String prettyName)
	{
		super(prettyName, new Item.Properties());
	}

	@Override
	public ItemModelBuilder modelBuilder(ItemModelProvider modelProvider, ResourceLocation key)
	{
		return modelProvider.withExistingParent(
				key.getPath(), ResourceLocation.parse("item/generated")
		).texture(
				"layer0", ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "item/metals/" + key.getPath())
		);
	}

	@Override
	public Supplier<CreativeModeTab> getTab()
	{
		return CreativeTabs.WORLD;
	}
}
