package api.lordskittles.seidra.common.sai.interfaces;

import api.lordskittles.seidra.common.sai.ConsumtionType;

public interface ISaiConsumer
{
	int getSaiCost();

	boolean canActivate(ISaiContainer saiContainer);
	boolean onActivate(ISaiContainer saiContainer);

	ConsumtionType getConsumtionType();
}
