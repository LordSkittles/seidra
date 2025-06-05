package api.lordskittles.seidra.common.sai.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class SaiCapabilityEvents
{
	/**
	 * Handle entity tick events to tick the SAI capability
	 */
	@SubscribeEvent
	public static void onLivingUpdate(EntityTickEvent.Post event)
	{
		if(event.getEntity() instanceof LivingEntity living)
		{
			if (!living.level().isClientSide())
			{
				ISaiCapability capability = SaiCapabilities.getSaiCapability(living);
				if (capability != null)
				{
					capability.tick();
					capability.syncToClient();
				}
			}
		}
	}

	/**
	 * Save capability data when player clones (like respawning or returning from End)
	 */
	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event)
	{
		if (!event.getEntity().level().isClientSide())
		{
			Player oldPlayer = event.getOriginal();
			Player newPlayer = event.getEntity();

			ISaiCapability oldCap = SaiCapabilities.getSaiCapability(oldPlayer);
			ISaiCapability newCap = SaiCapabilities.getSaiCapability(newPlayer);

			if (oldCap != null && newCap != null)
			{
				// Copy data from old player to new player
				CompoundTag data = oldCap.serialize();
				newCap.deserialize(data);
			}
		}
	}

	/**
	 * Handle entity joining the level to sync capability data to clients
	 */
	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinLevelEvent event)
	{
		Entity entity = event.getEntity();
		if (!entity.level().isClientSide() && entity instanceof LivingEntity living)
		{
			ISaiCapability capability = SaiCapabilities.getSaiCapability(living);
			if (capability != null)
			{
				capability.syncToClient();
			}
		}
	}
}
