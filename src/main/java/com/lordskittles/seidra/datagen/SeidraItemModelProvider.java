package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import api.lordskittles.seidra.interfaces.IItemModelDatagenProvider;
import com.lordskittles.seidra.common.registries.SeidraBlocks;
import com.lordskittles.seidra.common.registries.Items;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SeidraItemModelProvider extends ItemModelProvider
{
	public SeidraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, Seidra.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		Items.ITEMS.getEntries().stream().forEach(item ->
		{
			if (item.get() instanceof IItemModelDatagenProvider modelProvider)
			{
				modelProvider.modelBuilder(this, item.getId());
			}
		});

		saplingItem(SeidraBlocks.ASH_SAPLING);
		saplingItem(SeidraBlocks.PINE_SAPLING);
		saplingItem(SeidraBlocks.YEW_SAPLING);
	}

	private ItemModelBuilder saplingItem(DeferredBlock<Block> item)
	{
		return withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")
		).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "block/plants/" + item.getId().getPath())
		);
	}
}
