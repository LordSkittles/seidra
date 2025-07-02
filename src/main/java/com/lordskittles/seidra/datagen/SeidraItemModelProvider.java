package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.item.SeidraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class SeidraItemModelProvider extends ItemModelProvider
{
	public SeidraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, Seidra.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		simpleItem(SeidraItems.AMBER_GEM, "gems");
		simpleItem(SeidraItems.LABRADORITE_GEM, "gems");
		simpleItem(SeidraItems.THULITE_GEM, "gems");
		
		simpleItem(SeidraItems.BISMUTH_INGOT, "metals");
		simpleItem(SeidraItems.SILVER_INGOT, "metals");
		simpleItem(SeidraItems.TUNGSTEN_INGOT, "metals");
		
		simpleItem(SeidraItems.RAW_BISMUTH, "metals");
		simpleItem(SeidraItems.RAW_SILVER, "metals");
		simpleItem(SeidraItems.RAW_TUNGSTEN, "metals");

		saplingItem(SeidraBlocks.ASH_SAPLING);
		saplingItem(SeidraBlocks.PINE_SAPLING);
		saplingItem(SeidraBlocks.YEW_SAPLING);
	}

	private void saplingItem(DeferredBlock<?> item)
	{
		this.withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")
		).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "block/plants/" + item.getId().getPath())
		);
	}
	
	private void simpleItem(DeferredItem<?> item)
	{
		simpleItem(item, "");
	}
	
	private void simpleItem(DeferredItem<?> item, String subFolder)
	{
		this.withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")
		).texture("layer0",
				ResourceLocation.fromNamespaceAndPath(Seidra.MODID, "item/" + subFolder + "/" + item.getId().getPath())
		);
	}
}
