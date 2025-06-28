package com.lordskittles.seidra.client;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.client.screen.ArcaneCraftingBlockScreen;
import com.lordskittles.seidra.common.registries.MenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Seidra.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {

    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event)
    {
        event.register(MenuTypes.ARCANE_CRAFTING_BLOCK.get(), ArcaneCraftingBlockScreen::new);
    }
}
