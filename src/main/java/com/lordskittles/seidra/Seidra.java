package com.lordskittles.seidra;

import api.lordskittles.seidra.common.sai.capabilities.SaiCapabilities;
import api.lordskittles.seidra.common.sai.capabilities.SaiCapabilityEvents;
import com.lordskittles.seidra.common.CommonProxy;
import com.lordskittles.seidra.common.Config;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(Seidra.MODID)
public class Seidra
{
    public static final String MODID = "seidra";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Seidra(IEventBus modEventBus, ModContainer modContainer)
    {
        CommonProxy.initialiseRegistries(modEventBus);

        // Register capability events on the forge event bus
        NeoForge.EVENT_BUS.register(SaiCapabilityEvents.class);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
