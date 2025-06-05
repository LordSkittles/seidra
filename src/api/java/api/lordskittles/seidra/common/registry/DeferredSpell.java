package api.lordskittles.seidra.common.registry;

import api.lordskittles.seidra.common.sai.spells.Spell;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DeferredSpell<T extends Spell> extends DeferredHolder<Spell, T>
{
	protected DeferredSpell(DeferredHolder<Spell, T> holder)
	{
		super(holder.getKey());
	}

	protected DeferredSpell(ResourceKey<Spell> key)
	{
		super(key);
	}

	public T getSpell()
	{
		return get();
	}
}
