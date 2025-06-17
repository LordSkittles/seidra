package api.lordskittles.seidra.common.events;

import api.lordskittles.seidra.common.sai.schools.School;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

public class SpellSchoolAssignmentEvent extends Event implements IModBusEvent
{
	public final School school;

	public SpellSchoolAssignmentEvent(School school)
	{
		this.school = school;
	}
}
