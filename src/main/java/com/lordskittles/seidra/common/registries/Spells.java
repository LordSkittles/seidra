package com.lordskittles.seidra.common.registries;

import api.lordskittles.seidra.common.registry.DeferredSpell;
import api.lordskittles.seidra.common.registry.SeidraRegistries;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.sai.spells.ExampleSpell;

public class Spells
{
	public static final SeidraRegistries.Spells SPELLS = SeidraRegistries.createSpells(Seidra.MODID);

	public static final DeferredSpell<ExampleSpell> EXAMPLE_SPELL = SPELLS.register("example_spell", ExampleSpell::new);
}
