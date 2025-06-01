package com.lordskittles.seidra.common.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.IntStream;

public class Blocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Seidra.MODID);

    public static final RegistryObject<SeidraLogBlock> JUNIPER_LOG = registerColumnBlock("juniper_log", "Juniper Log", SeidraLogBlock.class);
    public static final RegistryObject<SeidraLogBlock> PINE_LOG = registerColumnBlock("pine_log", "Pine Log", SeidraLogBlock.class);
    public static final RegistryObject<SeidraLogBlock> YEW_LOG = registerColumnBlock("yew_log", "Yew Log", SeidraLogBlock.class);

    public static final RegistryObject<SeidraLogBlock> STRIPPED_JUNIPER_LOG = registerColumnBlock("stripped_juniper_log", "Stripped Juniper Log", SeidraLogBlock.class);
    public static final RegistryObject<SeidraLogBlock> STRIPPED_PINE_LOG = registerColumnBlock("stripped_pine_log", "Stripped Pine Log", SeidraLogBlock.class);
    public static final RegistryObject<SeidraLogBlock> STRIPPED_YEW_LOG = registerColumnBlock("stripped_yew_log", "Stripped Yew Log", SeidraLogBlock.class);

    public static final RegistryObject<SeidraPlankBlock> JUNIPER_PLANKS = registerBlock("juniper_planks", "Juniper Planks", SeidraPlankBlock.class);
    public static final RegistryObject<SeidraPlankBlock> PINE_PLANKS = registerBlock("pine_planks", "Pine Planks", SeidraPlankBlock.class);
    public static final RegistryObject<SeidraPlankBlock> YEW_PLANKS = registerBlock("yew_planks", "Yew Planks", SeidraPlankBlock.class);

    public static final RegistryObject<SeidraOreBlock> BISMUTH_ORE = registerBlock("bismuth_ore", "Bismuth Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> COBALT_ORE = registerBlock("cobalt_ore", "Cobalt Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> TUNGSTEN_ORE = registerBlock("tungsten_ore", "Tungsten Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> IOLITE_ORE = registerBlock("iolite_ore", "Iolite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> THULITE_ORE = registerBlock("thulite_ore", "Thulite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> ZOISITE_ORE = registerBlock("zoisite_ore", "Zoisite Ore", SeidraOreBlock.class, 3.0F, 3.0F);

    public static final RegistryObject<SeidraOreBlock> DEEPSLATE_BISMUTH_ORE = registerBlock("deepslate_bismuth_ore", "Deepslate Bismuth Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", "Deepslate Cobalt Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore", "Deepslate Tungsten Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> DEEPSLATE_IOLITE_ORE = registerBlock("deepslate_iolite_ore", "Deepslate Iolite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> DEEPSLATE_THULITE_ORE = registerBlock("deepslate_thulite_ore", "Deepslate Thulite Ore", SeidraOreBlock.class, 3.0F, 3.0F);
    public static final RegistryObject<SeidraOreBlock> DEEPSLATE_ZOISITE_ORE = registerBlock("deepslate_zoisite_ore", "Deepslate Zoisite Ore", SeidraOreBlock.class, 3.0F, 3.0F);

    private static <BLOCK extends Block> RegistryObject<BLOCK> registerBlock(String registryName, String prettyName, Class<BLOCK> clazz, Object... params)
    {
        return BLOCKS.register(registryName, () -> instantiateBlock(clazz, prettyName, params));
    }

    private static <BLOCK extends SeidraColumnBlock> RegistryObject<BLOCK> registerColumnBlock(String registryName, String prettyName, Class<BLOCK> clazz, Object... params)
    {
        return registerBlock(registryName, prettyName, clazz, params);
    }

    private static <BLOCK> BLOCK instantiateBlock(Class<BLOCK> clazz, String prettyName, Object... params)
    {
        try
        {
            if(params.length > 0)
            {
                Class<?>[] paramTypes = new Class<?>[params.length + 1];
                paramTypes[0] = String.class;
                IntStream.range(0, params.length).forEach(i -> paramTypes[i + 1] = params[i].getClass());

                Object[] paramValues = new Object[params.length + 1];
                paramValues[0] = prettyName;
                System.arraycopy(params, 0, paramValues, 1, params.length);

                return clazz.getConstructor(paramTypes).newInstance(paramValues);
            }

            return clazz.getConstructor(String.class).newInstance(prettyName);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }
}
