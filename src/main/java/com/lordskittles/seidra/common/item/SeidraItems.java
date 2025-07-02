package com.lordskittles.seidra.common.item;

import com.lordskittles.seidra.Seidra;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SeidraItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Seidra.MODID);
    
    public static final DeferredItem<Item> AMBER_GEM = register("amber_gem");
    public static final DeferredItem<Item> LABRADORITE_GEM = register("labradorite_gem");
    public static final DeferredItem<Item> THULITE_GEM = register("thulite_gem");

    public static final DeferredItem<Item> BISMUTH_INGOT = register("bismuth_ingot");
    public static final DeferredItem<Item> SILVER_INGOT = register("silver_ingot");
    public static final DeferredItem<Item> TUNGSTEN_INGOT = register("tungsten_ingot");
    
    public static final DeferredItem<Item> RAW_BISMUTH = register("raw_bismuth");
    public static final DeferredItem<Item> RAW_SILVER = register("raw_silver");
    public static final DeferredItem<Item> RAW_TUNGSTEN = register("raw_tungsten");

    private static DeferredItem<Item> register(String id)
    {
        return register(id, new Item.Properties());
    }
    
    private static DeferredItem<Item> register(String id, Item.Properties properties)
    {
        return ITEMS.register(id, () -> new Item(properties));
    }
}
