package api.lordskittles.seidra.common.sai.capabilities;

import api.lordskittles.seidra.common.sai.interfaces.ISaiContainer;
import net.minecraft.nbt.CompoundTag;

public interface ISaiCapability
{
	ISaiContainer getContainer();

	void tick();
	void syncToClient();

	CompoundTag serialize();
	void deserialize(CompoundTag tag);
}
