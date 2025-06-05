package api.lordskittles.seidra.common.sai.capabilities;

import api.lordskittles.seidra.common.network.packets.SaiSyncPacket;
import api.lordskittles.seidra.common.sai.SaiContainer;
import api.lordskittles.seidra.common.sai.interfaces.ISaiContainer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;

public class EntitySaiCapability implements ISaiCapability
{
	private final SaiContainer container;
	private final LivingEntity entity;
	private boolean isDirty = false;

	public EntitySaiCapability(LivingEntity entity)
	{
		this.entity = entity;
		// Different entities might have different max Sai
		int maxSai = calculateMaxSaiForEntity(entity);
		float regenRate = calculateRegenRateForEntity(entity);
		this.container = new SaiContainer(maxSai, regenRate);
	}

	@Override
	public ISaiContainer getContainer()
	{
		return container;
	}

	@Override
	public void tick()
	{
		int oldSai = container.getCurrentSai();
		container.tick();

		// Mark as dirty if Sai changed (for syncing)
		if (oldSai != container.getCurrentSai())
		{
			isDirty = true;
		}
	}

	@Override
	public void syncToClient()
	{
		if (isDirty && !entity.level().isClientSide())
		{
			// Send packet to client
			SaiSyncPacket packet = new SaiSyncPacket(
					entity.getUUID().toString(),
					container.getCurrentSai(),
					container.getMaxSai(),
					container.getRegenRate()
			);

			PacketDistributor.sendToServer(packet);

			isDirty = false;
		}
	}

	// this is a set of temporary methods to determine max Sai and regen rate based on entity type
	private int calculateMaxSaiForEntity(LivingEntity entity)
	{
		if (entity instanceof Player)
		{
			return 100;
		}

		if (entity instanceof Villager)
		{
			return 50;
		}

		if (entity instanceof Monster)
		{
			return 25;
		}

		return 10; // Default for other entities
	}

	private float calculateRegenRateForEntity(LivingEntity entity)
	{
		if (entity instanceof Player)
		{
			return 2.0f; // 2 Sai per second
		}

		return 1.0f; // 1 Sai per second for others
	}

	@Override
	public CompoundTag serialize()
	{
		return container.serialize();
	}

	@Override
	public void deserialize(CompoundTag tag)
	{
		container.deserialize(tag);
	}
}
