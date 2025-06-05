package com.lordskittles.seidra.common.sai.spells;

import api.lordskittles.seidra.common.sai.spells.Spell;
import com.lordskittles.seidra.common.registries.Schools;

public class TestSpell extends Spell
{
	public TestSpell()
	{
		super(5, Schools.TEST_SCHOOL.get());
	}
}
