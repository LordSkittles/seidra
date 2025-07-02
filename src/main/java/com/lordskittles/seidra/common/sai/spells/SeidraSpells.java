package com.lordskittles.seidra.common.sai.spells;

import api.lordskittles.seidra.common.registry.DeferredSpell;
import api.lordskittles.seidra.common.registry.SeidraRegistries;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.sai.spells.embercraft.FireboltSpell;
import com.lordskittles.seidra.common.sai.spells.spiritguard.HealSpell;

public class SeidraSpells
{
	public static final SeidraRegistries.Spells SPELLS = SeidraRegistries.createSpells(Seidra.MODID);

	public static final DeferredSpell<FireboltSpell> FIREBOLT =  SPELLS.register("firebolt", FireboltSpell::new);

	public static final DeferredSpell<HealSpell> HEAL =  SPELLS.register("heal", HealSpell::new);
}