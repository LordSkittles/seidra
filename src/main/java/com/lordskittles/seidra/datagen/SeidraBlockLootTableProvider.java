package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.common.block.*;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

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
        for (DeferredBlock<SeidraOreBlock> ore : Blocks.ORES)
        {
            add(ore.get(), block ->
            {
                if (block instanceof SeidraOreBlock oreBlock)
                {
                    return createOreDrop(ore.get(), oreBlock.getDrop().get());
                }

                return null;
            });
        }

        for (DeferredBlock<SeidraOreBlock> ore : Blocks.DEEPSLATE_ORES)
        {
            dropSelf(ore.get());
        }

        for (DeferredBlock<SeidraStorageBlock> storageBlock : Blocks.STORAGE_BLOCKS)
        {
            dropSelf(storageBlock.get());
        }

        for (DeferredBlock<SeidraLogBlock> log : Blocks.LOGS)
        {
            dropSelf(log.get());
        }

        for (DeferredBlock<SeidraLogBlock> log : Blocks.WOOD)
        {
            dropSelf(log.get());
        }

        for (DeferredBlock<SeidraPlankBlock> plank : Blocks.PLANKS)
        {
            dropSelf(plank.get());
        }

        for (DeferredBlock<SeidraLeafBlock> leaf : Blocks.LEAVES)
        {
            add(leaf.get(), block -> createLeavesDrops(block, leaf.get().getSapling().get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }

        for (DeferredBlock<SeidraSaplingBlock> sapling : Blocks.SAPLINGS)
        {
            dropSelf(sapling.get());
        }
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
}
