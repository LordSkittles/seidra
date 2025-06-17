package com.lordskittles.seidra.datagen.book.categories;

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider;
import com.klikli_dev.modonomicon.api.datagen.SingleBookSubProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookIconModel;
import com.klikli_dev.modonomicon.registry.ItemRegistry;
import com.lordskittles.seidra.datagen.book.entries.introduction.FirstStepsEntry;

public class IntroductionCategory extends CategoryProvider
{
	public static final String ID = "introduction";

	public IntroductionCategory(SingleBookSubProvider parent)
	{
		super(parent);
	}

	@Override
	protected String[] generateEntryMap()
	{
		return new String[]{
				"_____________________",
				"_____________________",
				"__________l__________",
				"_____________________",
				"_____________________"
		};
	}

	@Override
	protected void generateEntries()
	{
		this.add(new FirstStepsEntry(this).generate('l'));
	}

	@Override
	protected String categoryName()
	{
		return "Introduction";
	}

	@Override
	protected BookIconModel categoryIcon()
	{
		return BookIconModel.create(ItemRegistry.MODONOMICON_BLUE.get());
	}

	@Override
	public String categoryId()
	{
		return ID;
	}
}
