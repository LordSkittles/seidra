package com.lordskittles.seidra.common;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.interfaces.ICreativeTabProvider;
import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.Items;
import com.lordskittles.seidra.common.registries.CreativeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

@EventBusSubscriber(modid = Seidra.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SeidraCommon
{
    public static void initialiseRegistries(IEventBus eventBus)
    {
        Blocks.BLOCKS.register(eventBus);
        Items.ITEMS.register(eventBus);
        CreativeTabs.TABS.register(eventBus);
    }

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event)
    {
        Blocks.BLOCKS.getEntries().forEach(block ->
                                           {
                                               if (block.get() instanceof ICreativeTabProvider provider)
                                               {
                                                   if (provider.getTab().get() == event.getTab())
                                                   {
                                                       event.accept(block.get());
                                                   }
                                               }
                                           });

        Items.ITEMS.getEntries().forEach(item ->
                                           {
                                               if (item.get() instanceof ICreativeTabProvider provider)
                                               {
                                                   if (provider.getTab().get() == event.getTab())
                                                   {
                                                       event.accept(item.get());
                                                   }
                                               }
                                           });
    }

    /*@SubscribeEvent
    public void onServerStarting(final ServerStartingEvent event)
    {

    }*/
}
