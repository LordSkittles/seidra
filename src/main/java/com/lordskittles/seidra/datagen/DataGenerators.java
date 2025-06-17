package com.lordskittles.seidra.datagen;

import com.klikli_dev.modonomicon.api.datagen.LanguageProviderCache;
import com.klikli_dev.modonomicon.api.datagen.NeoBookProvider;
import com.klikli_dev.modonomicon.datagen.EnUsProvider;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.datagen.book.SeidraBook;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Seidra.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(packOutput, Collections.emptySet(),
                                      List.of(new LootTableProvider.SubProviderEntry(SeidraBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                                      lookupProvider
                )
        );
        generator.addProvider(event.includeServer(), new SeidraRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new SeidraDatapackProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new SeidraBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new SeidraItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new SeidraBiomeTagProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new SeidraItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new SeidraBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new SeidraLanguageProvider(packOutput, "en_us"));

        var enUsCache = new LanguageProviderCache("en_us");

        generator.addProvider(event.includeServer(), NeoBookProvider.of(event, new SeidraBook(enUsCache)));

        generator.addProvider(event.includeClient(), new EnUsProvider(generator.getPackOutput(), enUsCache));
    }
}
