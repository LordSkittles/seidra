package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
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
	
	}
}
