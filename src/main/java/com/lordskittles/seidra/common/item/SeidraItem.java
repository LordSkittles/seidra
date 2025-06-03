package com.lordskittles.seidra.common.item;

import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import api.lordskittles.seidra.interfaces.IItemModelProvider;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;

public abstract class SeidraItem extends Item implements IPrettyNameProvider, ICreativeTabProvider, IItemModelProvider
{
	private final String prettyName;

	public SeidraItem(String prettyName, Properties properties)
	{
		super(properties);

		this.prettyName = prettyName;
	}

	@Override
	public String getPrettyName()
	{
		return prettyName;
	}

	public ItemModelBuilder modelBuilder(ItemModelProvider modelProvider, ResourceLocation key)
	{
		return modelProvider.basicItem(this);
	}
}
