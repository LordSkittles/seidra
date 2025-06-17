package api.lordskittles.seidra.common.sai.spells;

import api.lordskittles.seidra.common.sai.ConsumtionType;
import api.lordskittles.seidra.common.sai.interfaces.ISaiConsumer;
import api.lordskittles.seidra.common.sai.interfaces.ISaiContainer;

public class Spell implements ISaiConsumer
{
	private final int saiCost;
	private final String name;

	public Spell(int saiCost, String name)
	{
		this.saiCost = saiCost;
		this.name = name;
	}

	public String getName()
	{
		return name;
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
}
