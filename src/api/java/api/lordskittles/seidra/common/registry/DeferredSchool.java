package api.lordskittles.seidra.common.registry;

import api.lordskittles.seidra.common.sai.schools.School;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DeferredSchool<T extends School> extends DeferredHolder<School, T>
{
	protected DeferredSchool(DeferredHolder<School, T> holder)
	{
		super(holder.getKey());
	}

	protected DeferredSchool(ResourceKey<School> key)
	{
		super(key);
	}

	public T getSchool()
	{
		return get();
	}
}
