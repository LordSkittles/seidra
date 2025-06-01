package data.lordskittles.seidra;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class SeidraData
{
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new SeidraBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new SeidraItemModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new SeidraLanguageProvider(generator, "en_us"));

        /*SeidraBlockTagsProvider blockTags = new SeidraBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new SeidraItemTagsProvider(generator, blockTags, fileHelper));
        generator.addProvider(event.includeServer(), new SeidraLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new SeidraRecipeProvider(generator));*/
    }
}
