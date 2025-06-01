package data.lordskittles.seidra;

import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SeidraData
{
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new SeidraBlockStateProvider(generator.getPackOutput(), fileHelper));
        generator.addProvider(event.includeClient(), new SeidraItemModelProvider(generator.getPackOutput(), fileHelper));
        generator.addProvider(event.includeClient(), new SeidraLanguageProvider(generator, "en_us"));

        /*SeidraBlockTagsProvider blockTags = new SeidraBlockTagsProvider(generator.getPackOutput(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new SeidraItemTagsProvider(generator.getPackOutput(), blockTags, fileHelper));
        generator.addProvider(event.includeServer(), new SeidraLootTableProvider(generator.getPackOutput()));
        generator.addProvider(event.includeServer(), new SeidraRecipeProvider(generator.getPackOutput()));*/
    }
}
