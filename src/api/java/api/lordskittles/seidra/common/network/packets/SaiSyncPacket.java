package api.lordskittles.seidra.common.network.packets;

import api.lordskittles.seidra.SeidraAPI;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record SaiSyncPacket(String entityId, int currentSai, int maxSai, float regenRate) implements CustomPacketPayload
{
	public static final CustomPacketPayload.Type<SaiSyncPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(SeidraAPI.MODID, "sai_sync"));

	public static final StreamCodec<ByteBuf, SaiSyncPacket> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.STRING_UTF8,
			SaiSyncPacket::entityId,
			ByteBufCodecs.VAR_INT,
			SaiSyncPacket::currentSai,
			ByteBufCodecs.VAR_INT,
			SaiSyncPacket::maxSai,
			ByteBufCodecs.FLOAT,
			SaiSyncPacket::regenRate,
			SaiSyncPacket::new
	);

	@Override
	public CustomPacketPayload.Type<? extends CustomPacketPayload> type()
	{
		return TYPE;
	}
}
