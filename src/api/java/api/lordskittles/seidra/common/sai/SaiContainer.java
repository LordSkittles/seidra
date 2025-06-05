package api.lordskittles.seidra.common.sai;

import net.minecraft.nbt.CompoundTag;

public class SaiContainer
{
	public int currentSai;
	public int maxSai;
	public float regenerationRate;
	public long lastRegenerationTime;

	public SaiContainer(int maxSai, float regenerationRate)
	{
		this.currentSai = maxSai;
		this.maxSai = maxSai;
		this.regenerationRate = regenerationRate;
		this.lastRegenerationTime = System.currentTimeMillis();
	}

	public void tick()
	{
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastRegenerationTime >= 1000 / regenerationRate)
		{
			int regenerationAmount = (int) ((currentTime - lastRegenerationTime) * regenerationRate / 1000);
			currentSai = Math.min(currentSai + regenerationAmount, maxSai);
			lastRegenerationTime = currentTime;
		}
	}

	public CompoundTag serialize()
	{
		CompoundTag tag = new CompoundTag();
		tag.putInt("currentSai", currentSai);
		tag.putInt("maxSai", maxSai);
		tag.putFloat("regenerationRate", regenerationRate);
		return tag;
	}

	public void deserialize(CompoundTag tag)
	{
		this.currentSai = tag.getInt("currentSai");
		this.maxSai = tag.getInt("maxSai");
		this.regenerationRate = tag.getFloat("regenerationRate");
	}
}
