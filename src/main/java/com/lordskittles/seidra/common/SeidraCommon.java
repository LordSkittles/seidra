package com.lordskittles.seidra.common;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.*;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Seidra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeidraCommon
{
    private static final SeidraCommon INSTANCE = new SeidraCommon();

    public static SeidraCommon initialise(IEventBus eventBus)
    {
        Blocks.BLOCKS.register(eventBus);
        Items.ITEMS.register(eventBus);

        return INSTANCE;
    }

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
}
