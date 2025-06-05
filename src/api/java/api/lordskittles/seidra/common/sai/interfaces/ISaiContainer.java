package api.lordskittles.seidra.common.sai.interfaces;

public interface ISaiContainer
{
	int getCurrentSai();
	int getMaxSai();

	boolean addSai(int amount);
	boolean consumeSai(int amount);

	void setSai(int amount);

	boolean canConsumeSai(int amount);
}
