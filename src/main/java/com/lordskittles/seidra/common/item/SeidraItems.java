package com.lordskittles.seidra.common.item;

import com.lordskittles.seidra.Seidra;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lordskittles.seidra.Names.*;

public class SeidraItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Seidra.MODID);
    
    public static final DeferredItem<Item> AMBER_GEM = register(buildName(Types.AMBER, Suffixes.GEM));
    public static final DeferredItem<Item> LABRADORITE_GEM = register(buildName(Types.LABRADORITE, Suffixes.GEM));
    public static final DeferredItem<Item> THULITE_GEM = register(buildName(Types.THULITE, Suffixes.GEM));

    public static final DeferredItem<Item> BISMUTH_INGOT = register(buildName(Types.BISMUTH, Suffixes.INGOT));
    public static final DeferredItem<Item> SILVER_INGOT = register(buildName(Types.SILVER, Suffixes.INGOT));
    public static final DeferredItem<Item> TUNGSTEN_INGOT = register(buildName(Types.TUNGSTEN, Suffixes.INGOT));
    
    public static final DeferredItem<Item> RAW_BISMUTH = register(buildName(Prefixes.RAW, Types.BISMUTH));
    public static final DeferredItem<Item> RAW_SILVER = register(buildName(Prefixes.RAW, Types.SILVER));
    public static final DeferredItem<Item> RAW_TUNGSTEN = register(buildName(Prefixes.RAW, Types.TUNGSTEN));

    private static DeferredItem<Item> register(String id)
    {
        return register(id, new Item.Properties());
    }
    
    private static DeferredItem<Item> register(String id, Item.Properties properties)
    {
        return ITEMS.register(id, () -> new Item(properties));
    }
}
