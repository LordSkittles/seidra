package com.lordskittles.seidra.registries;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.item.SeidraGem;
import com.lordskittles.seidra.item.SeidraIngot;
import com.lordskittles.seidra.item.SeidraRawOre;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.IntStream;

public class Items
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Seidra.MODID);

    public static final DeferredItem<SeidraRawOre> RAW_BISMUTH = registerItem("raw_bismuth", "Raw Bismuth", SeidraRawOre.class);
    public static final DeferredItem<SeidraRawOre> RAW_COBALT = registerItem("raw_cobalt", "Raw Cobalt", SeidraRawOre.class);
    public static final DeferredItem<SeidraRawOre> RAW_TUNGSTEN = registerItem("raw_tungsten", "Raw Tungsten", SeidraRawOre.class);

    public static final DeferredItem<SeidraGem> IOLITE_GEM = registerItem("iolite_gem", "Iolite", SeidraGem.class);
    public static final DeferredItem<SeidraGem> THULITE_GEM = registerItem("thulite_gem", "Thulite", SeidraGem.class);
    public static final DeferredItem<SeidraGem> ZOISITE_GEM = registerItem("zoisite_gem", "Zoisite", SeidraGem.class);

    public static final DeferredItem<SeidraIngot> BISMUTH_INGOT = registerItem("bismuth_ingot", "Bismuth Ingot", SeidraIngot.class);
    public static final DeferredItem<SeidraIngot> COBALT_INGOT = registerItem("cobalt_ingot", "Cobalt Ingot", SeidraIngot.class);
    public static final DeferredItem<SeidraIngot> TUNGSTEN_INGOT = registerItem("tungsten_ingot", "Tungsten Ingot", SeidraIngot.class);

    private static <ITEM extends Item> DeferredItem<ITEM> registerItem(String id, String prettyName, Class<ITEM> clazz, Object... params)
    {
		return ITEMS.register(id, () -> instantiateItem(clazz, prettyName, params));
    }

    private static <ITEM> ITEM instantiateItem(Class<ITEM> clazz, String prettyName, Object... params)
    {
        try
        {
            if (params.length > 0)
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
