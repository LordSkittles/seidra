package com.lordskittles.seidra.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTags
{
    public static final TagKey<Item> RAW_BISMUTH = createCommon("raw_materials/bismuth");
    public static final TagKey<Item> RAW_SILVER = createCommon("raw_materials/silver");
    public static final TagKey<Item> RAW_TUNGSTEN = createCommon("raw_materials/tungsten");

    public static final TagKey<Item> BISMUTH_INGOT = createCommon("ingots/bismuth");
    public static final TagKey<Item> SILVER_INGOT = createCommon("ingots/silver");
    public static final TagKey<Item> TUNGSTEN_INGOT = createCommon("ingots/tungsten");

    public static final TagKey<Item> AMBER = createCommon("gems/amber");
    public static final TagKey<Item> LABRADORITE = createCommon("gems/labradorite");
    public static final TagKey<Item> THULITE = createCommon("gems/thulite");

    public static final TagKey<Item> BISMUTH_ORE = createCommon("ores/bismuth");
    public static final TagKey<Item> SILVER_ORE = createCommon("ores/silver");
    public static final TagKey<Item> TUNGSTEN_ORE = createCommon("ores/tungsten");
    public static final TagKey<Item> AMBER_ORE = createCommon("ores/amber");
    public static final TagKey<Item> LABRADORITE_ORE = createCommon("ores/labradorite");
    public static final TagKey<Item> THULITE_ORE = createCommon("ores/thulite");

    private static TagKey<Item> createCommon(String name)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
