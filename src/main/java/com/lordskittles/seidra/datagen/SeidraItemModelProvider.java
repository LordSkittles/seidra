package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.item.SeidraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.lordskittles.seidra.Names.*;

public class SeidraItemModelProvider extends ItemModelProvider
{
	public SeidraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, Seidra.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		simpleItem(SeidraItems.AMBER_GEM, Suffixes.GEM);
		simpleItem(SeidraItems.LABRADORITE_GEM, Suffixes.GEM);
		simpleItem(SeidraItems.THULITE_GEM, Suffixes.GEM);
		
		simpleItem(SeidraItems.BISMUTH_INGOT, Groups.METAL);
		simpleItem(SeidraItems.SILVER_INGOT, Groups.METAL);
		simpleItem(SeidraItems.TUNGSTEN_INGOT, Groups.METAL);
		
		simpleItem(SeidraItems.RAW_BISMUTH, Groups.METAL);
		simpleItem(SeidraItems.RAW_SILVER, Groups.METAL);
		simpleItem(SeidraItems.RAW_TUNGSTEN, Groups.METAL);

		saplingItem(SeidraBlocks.ASH_SAPLING);
		saplingItem(SeidraBlocks.PINE_SAPLING);
		saplingItem(SeidraBlocks.YEW_SAPLING);
	}

	private void saplingItem(DeferredBlock<?> item)
	{
		this.withExistingParent(item.getId().getPath(),
				ResourceLocation.parse("item/generated")
		).texture("layer0",
				modRes(buildName('/', Groups.BLOCK, Groups.PLANT, item.getId().getPath()))
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
				modRes("item/" + subFolder + "/" + item.getId().getPath())
		);
	}
}
