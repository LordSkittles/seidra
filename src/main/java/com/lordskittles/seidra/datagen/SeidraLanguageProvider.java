package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import api.lordskittles.seidra.interfaces.IPrettyNameProvider;
import com.lordskittles.seidra.common.block.functional.SeidraEntityBlock;
import com.lordskittles.seidra.common.registries.SeidraBlocks;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import com.lordskittles.seidra.common.registries.Items;
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
		SeidraBlocks.BLOCKS.getEntries().stream().forEach(block ->
		{
			if (block.get() instanceof IPrettyNameProvider provider)
			{
				add(block.get(), provider.getPrettyName());

				if(block.get() instanceof SeidraEntityBlock<?> be)
				{
					add(Seidra.MODID + ".blockentity." + block.getId().getPath(), provider.getPrettyName());
				}
			}
		});

		Items.ITEMS.getEntries().stream().forEach(item ->
		{
			if (item.get() instanceof IPrettyNameProvider provider)
			{
				add(item.get(), provider.getPrettyName());
			}
		});

		add(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), "Cracked Deepslate Brick Slab");
		add(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), "Cracked Deepslate Brick Stairs");

		add(CreativeTabs.WORLD.get().getDisplayName().getString(), "Seidra: World");
		add(CreativeTabs.MAIN.get().getDisplayName().getString(), "Seidra");
	}
}
