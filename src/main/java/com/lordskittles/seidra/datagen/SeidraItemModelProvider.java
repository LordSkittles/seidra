package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.blocks.SeidraSaplingBlock;
import com.lordskittles.seidra.registries.Blocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
		saplingItem(Blocks.JUNIPER_SAPLING);
		saplingItem(Blocks.PINE_SAPLING);
		saplingItem(Blocks.YEW_SAPLING);
	}

	private ItemModelBuilder saplingItem(DeferredBlock<SeidraSaplingBlock> item)
	{
		return withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")
		).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "block/plants/" + item.getId().getPath())
		);
	}
}
