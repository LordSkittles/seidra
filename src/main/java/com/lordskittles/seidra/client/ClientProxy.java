package com.lordskittles.seidra.client;

import com.lordskittles.seidra.Seidra;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Seidra.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {

    }
}
