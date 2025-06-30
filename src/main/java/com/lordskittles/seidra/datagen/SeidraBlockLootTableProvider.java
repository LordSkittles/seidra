package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.common.item.SeidraItem;
import com.lordskittles.seidra.common.registries.SeidraBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
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
        /*SeidraBlocks.BLOCKS.getEntries().forEach(block ->
        {
            //noinspection rawtypes
            if (block.get() instanceof ILootTableDatagenProvider provider)
            {
                provider.drop(this).run();
            }
        });*/

        dropSelf(SeidraBlocks.ASH_SAPLING);
        dropSelf(SeidraBlocks.PINE_SAPLING);
        dropSelf(SeidraBlocks.YEW_SAPLING);

        dropSelf(SeidraBlocks.ASH_PLANKS);
        dropSelf(SeidraBlocks.PINE_PLANKS);
        dropSelf(SeidraBlocks.YEW_PLANKS);

        dropSelf(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);
        dropSelf(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);

        leafDrop(SeidraBlocks.ASH_LEAVES, SeidraBlocks.ASH_SAPLING);
        leafDrop(SeidraBlocks.PINE_LEAVES, SeidraBlocks.PINE_SAPLING);
        leafDrop(SeidraBlocks.YEW_LEAVES, SeidraBlocks.YEW_SAPLING);
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
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return SeidraBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    public void dropSelf(@NotNull DeferredBlock<Block> block)
    {
        super.dropSelf(block.get());
    }

    public void dropOre(@NotNull DeferredBlock<Block> block, @NotNull DeferredItem<Item> drop)
    {
        add(block.get(), this.createOreDrop(block.get(), drop.get()));
    }

    public void leafDrop(@NotNull DeferredBlock<Block> block, @NotNull DeferredBlock<Block> drop)
    {
        add(block.get(), this.createLeavesDrops(block.get(), drop.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }
}
