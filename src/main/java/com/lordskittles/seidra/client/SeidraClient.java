package com.lordskittles.seidra.client;

import com.lordskittles.seidra.Seidra;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Seidra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SeidraClient
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {

    }
}
