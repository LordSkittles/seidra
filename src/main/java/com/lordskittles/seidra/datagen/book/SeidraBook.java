package com.lordskittles.seidra.datagen.book;

import com.klikli_dev.modonomicon.api.datagen.SingleBookSubProvider;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.datagen.book.categories.IntroductionCategory;

import java.util.function.BiConsumer;

public class SeidraBook extends SingleBookSubProvider
{
	public static final String ID = "skald_ledger";

	public SeidraBook(BiConsumer<String, String> defaultLang)
	{
		super(ID, Seidra.MODID, defaultLang);
	}

	@Override
	protected void registerDefaultMacros()
	{

	}

	@Override
	protected void generateCategories()
	{
		this.add(new IntroductionCategory(this).generate());
	}

	@Override
	protected String bookName()
	{
		return "Skald’s Ledger";
	}

	@Override
	protected String bookTooltip()
	{
		return "The Skalds kept more than tales. They kept the truths that shaped the spells.";
	}
}
