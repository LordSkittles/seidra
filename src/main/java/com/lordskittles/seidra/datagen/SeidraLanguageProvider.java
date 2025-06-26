package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.common.registries.Items;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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

		add(Blocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), "Cracked Deepslate Brick Slab");
		add(Blocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), "Cracked Deepslate Brick Stairs");

		add(CreativeTabs.WORLD.get().getDisplayName().getString(), "Seidra: World");
		add(CreativeTabs.MAIN.get().getDisplayName().getString(), "Seidra");
	}
}
