package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SeidraItemModelProvider extends ItemModelProvider
{
    public SeidraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Seidra.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {

    }
}
