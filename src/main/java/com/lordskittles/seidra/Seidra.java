package com.lordskittles.seidra;

import com.lordskittles.seidra.common.CommonProxy;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(Seidra.MODID)
public class Seidra
{
    public static final String MODID = "seidra";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Seidra(IEventBus modEventBus, ModContainer modContainer)
    {
        CommonProxy.initialiseRegistries(modEventBus);

        /*NeoForge.EVENT_BUS.register(SeidraCommon.INSTANCE);*/

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
