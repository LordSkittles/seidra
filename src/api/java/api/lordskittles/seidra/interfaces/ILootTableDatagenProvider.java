package api.lordskittles.seidra.interfaces;

import net.minecraft.data.loot.LootTableSubProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ILootTableDatagenProvider<LOOT_PROVIDER extends LootTableSubProvider>
{
    public Runnable drop(LOOT_PROVIDER provider);
}
