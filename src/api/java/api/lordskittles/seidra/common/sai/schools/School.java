package api.lordskittles.seidra.common.sai.schools;

import api.lordskittles.seidra.common.registry.DeferredSpell;
import api.lordskittles.seidra.common.sai.spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class School
{
	public final String name;

	private final ArrayList<DeferredSpell<?>> spells;

	public School(String name)
	{
		this.name = name;
		this.spells = new ArrayList<>();
	}

	final <T extends Spell> void accept(DeferredSpell<T> spell)
	{
		this.spells.add(spell);
	}

	@SafeVarargs
	final <T extends Spell> void accept(DeferredSpell<T>... spells)
	{
		for (DeferredSpell<T> spell : spells)
		{
			this.accept(spell);
		}
	}

	public List<DeferredSpell<?>> getSpells()
	{
		return this.spells;
	}
}
