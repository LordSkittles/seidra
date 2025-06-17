package api.lordskittles.seidra.common.sai.schools;

import api.lordskittles.seidra.common.sai.spells.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class School
{
	public final String name;

	private final ArrayList<Spell> spells;

	public School(String name)
	{
		this.name = name;
		this.spells = new ArrayList<>();
	}

	public void accept(Supplier<Spell> supplier)
	{
		if(supplier == null)
		{
			throw new IllegalArgumentException("Spell supplier cannot be null");
		}

		this.spells.add(supplier.get());
	}

	public List<Spell> getSpells()
	{
		return this.spells;
	}
}
