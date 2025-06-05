package api.lordskittles.seidra.common.sai.capabilities;

import api.lordskittles.seidra.SeidraAPI;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = SeidraAPI.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SaiCapabilities
{
	// This token is used for capability lookups - this is what you actually register
	public static final EntityCapability<ISaiCapability, Direction> SAI_CAPABILITY =
			EntityCapability.createSided(ResourceLocation.fromNamespaceAndPath(SeidraAPI.MODID, "sai_capability"), ISaiCapability.class);

	/**
	 * Register the SAI capability with supported entity types
	 */
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event)
	{
		for(EntityType<?> entityType : BuiltInRegistries.ENTITY_TYPE)
		{
			event.registerEntity(SAI_CAPABILITY, entityType, (entity, ctx) -> entity instanceof LivingEntity living ? new EntitySaiCapability(living) : null);
		}
	}

	/**
	 * Helper method to get the capability from an entity
	 */
	public static ISaiCapability getSaiCapability(LivingEntity entity, Direction side)
	{
		return entity.getCapability(SAI_CAPABILITY, side);
	}

	/**
	 * Helper method to get the capability from an entity (unsided)
	 */
	public static ISaiCapability getSaiCapability(LivingEntity entity)
	{
		return getSaiCapability(entity, null);
	}
}
