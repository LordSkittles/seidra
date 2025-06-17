package com.lordskittles.seidra.datagen.book.entries.introduction;

import com.klikli_dev.modonomicon.api.datagen.CategoryProvider;
import com.klikli_dev.modonomicon.api.datagen.EntryBackground;
import com.klikli_dev.modonomicon.api.datagen.EntryProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookIconModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel;
import com.lordskittles.seidra.common.registries.Blocks;
import com.mojang.datafixers.util.Pair;

public class FirstStepsEntry extends EntryProvider
{
	public static final String ID = "first_steps";

	public FirstStepsEntry(CategoryProvider parent)
	{
		super(parent);
	}

	@Override
	protected void generatePages()
	{
		this.page("intro", () -> BookTextPageModel.create()
												  .withTitle(this.context().pageTitle())
												  .withText(this.context().pageText())
		);
		this.pageText("First Steps");
		this.pageTitle("First Steps");
	}

	@Override
	protected String entryName()
	{
		return "First Steps";
	}

	@Override
	protected String entryDescription()
	{
		return "The first steps into the world of Seidra magic are often the most daunting. This entry will guide you through the basics, helping you to understand the fundamental concepts and practices that will set you on your path as a Seidra practitioner.";
	}

	@Override
	protected Pair<Integer, Integer> entryBackground()
	{
		return EntryBackground.DEFAULT;
	}

	@Override
	protected BookIconModel entryIcon()
	{
		return BookIconModel.create(Blocks.BISMUTH_ORE.asItem());
	}

	@Override
	protected String entryId()
	{
		return ID;
	}
}
