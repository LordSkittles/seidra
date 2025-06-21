package com.lordskittles.seidra.datagen;

import api.lordskittles.seidra.interfaces.IBlockStateDatagenProvider;
import api.lordskittles.seidra.interfaces.ILootTableDatagenProvider;
import com.lordskittles.seidra.common.block.*;
import com.lordskittles.seidra.common.item.SeidraItem;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SeidraBlockLootTableProvider extends BlockLootSubProvider
{
    protected SeidraBlockLootTableProvider(HolderLookup.Provider registries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate()
    {
        Blocks.BLOCKS.getEntries().forEach(block ->
        {
            //noinspection rawtypes
            if (block.get() instanceof ILootTableDatagenProvider provider)
            {
                provider.drop(this).run();
            }
        });

        dropSelf(Blocks.CRACKED_DEEPSLATE_BRICK_SLAB.get());
        dropSelf(Blocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get());
    }

    /*protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops)
    {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
        );
    }*/

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    public void dropSelf(@NotNull Block block)
    {
        super.dropSelf(block);
    }

    public void dropOre(@NotNull Block block, @NotNull DeferredItem<SeidraItem> drop)
    {
        add(block, this.createOreDrop(block, drop.get()));
    }

    public void leafDrop(@NotNull Block block, @NotNull DeferredBlock<SeidraSaplingBlock> drop)
    {
        add(block, this.createLeavesDrops(block, drop.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }
}
