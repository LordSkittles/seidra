package api.lordskittles.seidra.common.network;

import api.lordskittles.seidra.SeidraAPI;
import api.lordskittles.seidra.common.network.packets.SaiSyncPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = SeidraAPI.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SeidraNetworkHandler
{
	public static final String PROTOCOL_VERSION = "1";

	@SubscribeEvent
	public static void register(final RegisterPayloadHandlersEvent event)
	{
		final PayloadRegistrar registrar = event.registrar(PROTOCOL_VERSION);

		registrar.playBidirectional(SaiSyncPacket.TYPE, SaiSyncPacket.STREAM_CODEC,
				new DirectionalPayloadHandler<>(
						ClientPayloadHandler::handleSaiSync,
						ServerPayloadHandler::handleSaiSync
				)
		);
	}
}
