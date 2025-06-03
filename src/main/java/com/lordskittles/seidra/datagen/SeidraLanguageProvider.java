package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.registries.Blocks;
import com.lordskittles.seidra.registries.CreativeTabs;
import com.lordskittles.seidra.registries.Items;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class SeidraLanguageProvider extends LanguageProvider
{
	public SeidraLanguageProvider(PackOutput output, String locale)
	{
		super(output, Seidra.MODID, locale);
	}

	@Override
	protected void addTranslations()
	{
		Blocks.BLOCKS.getEntries().stream().forEach(block ->
		{
			if (block.get() instanceof IPrettyNameProvider provider)
			{
				add(block.get(), provider.getPrettyName());
			}
		});

		Items.ITEMS.getEntries().stream().forEach(item ->
		{
			if (item.get() instanceof IPrettyNameProvider provider)
			{
				add(item.get(), provider.getPrettyName());
			}
		});

		add(CreativeTabs.WORLD.get().getDisplayName().getString(), "Seidra: World");
	}
}
