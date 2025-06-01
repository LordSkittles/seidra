package com.lordskittles.seidra;

import com.lordskittles.seidra.common.SeidraCommon;
import com.mojang.logging.LogUtils;
import data.lordskittles.seidra.SeidraData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Seidra.MODID)
public class Seidra
{
    public static final String MODID = "seidra";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Seidra(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(SeidraData::gatherData);

        MinecraftForge.EVENT_BUS.register(SeidraCommon.initialise(modEventBus));

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
