package com.lordskittles.seidra.common;

import com.lordskittles.seidra.common.registries.Blocks;
import com.lordskittles.seidra.common.registries.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

/*@EventBusSubscriber(modid = Seidra.MODID, bus = EventBusSubscriber.Bus.MOD)*/
public class SeidraCommon
{
    public static final SeidraCommon INSTANCE = new SeidraCommon();

    public void initialiseRegistries(IEventBus eventBus)
    {
        Blocks.BLOCKS.register(eventBus);
        Items.ITEMS.register(eventBus);
    }

    public void onCommonSetup(final FMLCommonSetupEvent event)
    {

    }

    /*@SubscribeEvent
    public void onServerStarting(final ServerStartingEvent event)
    {

    }*/
}
