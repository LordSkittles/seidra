package api.lordskittles.seidra.common.sai.spells;

import api.lordskittles.seidra.common.sai.ConsumtionType;
import api.lordskittles.seidra.common.sai.interfaces.ISaiConsumer;
import api.lordskittles.seidra.common.sai.interfaces.ISaiContainer;
import api.lordskittles.seidra.common.sai.schools.School;

public class Spell implements ISaiConsumer
{
	private final int saiCost;
	private final School school;

	public Spell(int saiCost, School school)
	{
		this.saiCost = saiCost;
		this.school = school;
	}

	@Override
	public int getSaiCost()
	{
		return saiCost;
	}

	@Override
	public boolean canActivate(ISaiContainer saiContainer)
	{
		return saiContainer.canConsumeSai(saiCost);
	}

	@Override
	public boolean onActivate(ISaiContainer saiContainer)
	{
		return saiContainer.consumeSai(saiCost);
	}

	@Override
	public ConsumtionType getConsumtionType()
	{
		return ConsumtionType.ENTITY_ONLY;
	}

	public School getSchool()
	{
		return school;
	}
}
