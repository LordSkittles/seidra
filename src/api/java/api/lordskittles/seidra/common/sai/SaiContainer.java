package api.lordskittles.seidra.common.sai;

import api.lordskittles.seidra.common.sai.interfaces.ISaiContainer;
import net.minecraft.nbt.CompoundTag;

public class SaiContainer implements ISaiContainer
{
	private int currentSai;
	private int maxSai;
	private float regenRate; // Sai per second
	private long lastRegenTime;
	private boolean canRegenerate;
	private int regenDelay; // Ticks to wait after consumption before regen starts
	private int ticksSinceLastConsumption;

	public SaiContainer(int maxSai, float regenRate)
	{
		this.maxSai = maxSai;
		this.currentSai = maxSai;
		this.regenRate = regenRate;
		this.lastRegenTime = System.currentTimeMillis();
		this.canRegenerate = true;
		this.regenDelay = 60; // 3 seconds at 20 TPS
		this.ticksSinceLastConsumption = regenDelay;
	}

	/**
	 * Called every game tick (20 times per second)
	 * Handles automatic Sai regeneration
	 */
	public void tick()
	{
		// Only regenerate if we're not at max capacity and regeneration is enabled
		if (currentSai >= maxSai || !canRegenerate)
		{
			return;
		}

		// Increment the counter for ticks since last consumption
		if (ticksSinceLastConsumption < regenDelay)
		{
			ticksSinceLastConsumption++;
			return; // Still in cooldown period
		}

		// Calculate time-based regeneration
		long currentTime = System.currentTimeMillis();
		long deltaTime = currentTime - lastRegenTime;

		// Convert milliseconds to seconds for calculation
		float deltaSeconds = deltaTime / 1000.0f;

		// Calculate how much Sai to regenerate
		float saiToRegen = regenRate * deltaSeconds;

		// Only regenerate if enough time has passed (prevents micro-regeneration)
		if (saiToRegen >= 0.1f)
		{
			int saiAmount = (int) Math.floor(saiToRegen);
			if (saiAmount > 0)
			{
				addSai(saiAmount);
				lastRegenTime = currentTime;
			}
		}
	}

	@Override
	public int getCurrentSai()
	{
		return currentSai;
	}

	@Override
	public int getMaxSai()
	{
		return maxSai;
	}

	@Override
	public boolean addSai(int amount)
	{
		if (amount <= 0)
		{
			return false;
		}

		int newSai = Math.min(currentSai + amount, maxSai);
		boolean changed = newSai != currentSai;
		currentSai = newSai;

		return changed;
	}

	@Override
	public boolean consumeSai(int amount)
	{
		if (amount <= 0 || currentSai < amount)
		{
			return false;
		}

		currentSai -= amount;

		// Reset regeneration delay when Sai is consumed
		ticksSinceLastConsumption = 0;
		lastRegenTime = System.currentTimeMillis();

		return true;
	}

	@Override
	public void setSai(int amount)
	{
		currentSai = Math.max(0, Math.min(amount, maxSai));
		lastRegenTime = System.currentTimeMillis();
	}

	@Override
	public boolean canConsumeSai(int amount)
	{
		return amount > 0 && currentSai >= amount;
	}

	// Additional utility methods
	public void setRegenRate(float newRate)
	{
		this.regenRate = Math.max(0, newRate);
	}

	public float getRegenRate()
	{
		return regenRate;
	}

	public void setCanRegenerate(boolean canRegen)
	{
		this.canRegenerate = canRegen;
	}

	public boolean canRegenerate()
	{
		return canRegenerate;
	}

	public void setRegenDelay(int ticks)
	{
		this.regenDelay = Math.max(0, ticks);
	}

	public int getTicksUntilRegen()
	{
		return Math.max(0, regenDelay - ticksSinceLastConsumption);
	}

	public float getRegenPercentage()
	{
		return maxSai > 0 ? (float) currentSai / maxSai : 0.0f;
	}

	// Serialization for saving/loading
	public CompoundTag serialize()
	{
		CompoundTag tag = new CompoundTag();
		tag.putInt("currentSai", currentSai);
		tag.putInt("maxSai", maxSai);
		tag.putFloat("regenRate", regenRate);
		tag.putLong("lastRegenTime", lastRegenTime);
		tag.putBoolean("canRegenerate", canRegenerate);
		tag.putInt("regenDelay", regenDelay);
		tag.putInt("ticksSinceLastConsumption", ticksSinceLastConsumption);
		return tag;
	}

	public void deserialize(CompoundTag tag)
	{
		currentSai = tag.getInt("currentSai");
		maxSai = tag.getInt("maxSai");
		regenRate = tag.getFloat("regenRate");
		lastRegenTime = tag.getLong("lastRegenTime");
		canRegenerate = tag.getBoolean("canRegenerate");
		regenDelay = tag.getInt("regenDelay");
		ticksSinceLastConsumption = tag.getInt("ticksSinceLastConsumption");
	}
}