package api.lordskittles.seidra.common.sai.schools;

import api.lordskittles.seidra.common.registry.DeferredSpell;
import api.lordskittles.seidra.common.sai.spells.Spell;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

public class SpellSchoolAssignmentEvent extends Event implements IModBusEvent
{
	private final School school;

	public SpellSchoolAssignmentEvent(School school)
	{
		this.school = school;
	}

	public School getSchool()
	{
		return this.school;
	}

	public final <T extends Spell> void accept(DeferredSpell<T> spell)
	{
		this.school.accept(spell);
	}

	@SafeVarargs
	public final <T extends Spell> void accept(DeferredSpell<T>... spells)
	{
		this.school.accept(spells);
	}
}
