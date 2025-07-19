package com.lordskittles.seidra;

import net.minecraft.resources.ResourceLocation;

public class Constants
{
	public enum ERenderType
	{
		Cutout;
		
		@Override
		public String toString()
		{
			return super.toString().toLowerCase();
		}
	}
	
	public static class Types
	{
		public static final String ASH = "ash";
		public static final String PINE = "pine";
		public static final String YEW = "yew";
		
		public static final String BISMUTH = "bismuth";
		public static final String SILVER = "silver";
		public static final String TUNGSTEN = "tungsten";
		public static final String AMBER = "amber";
		public static final String LABRADORITE = "labradorite";
		public static final String THULITE = "thulite";
		public static final String FELDSPAR = "feldspar";
		
		public static final String ARCANE_CRAFTING = "arcane_crafting";
		public static final String SINDRI = "sindri_workbench";
		public static final String WAKESTONE = "wakestone";
	}
	
	public static class Prefixes
	{
		public static final String RAW = "raw";
		public static final String STRIPPED = "stripped";
		public static final String DEEPSLATE = "deepslate";
		public static final String CRACKED = "cracked";
		public static final String CRUMBLED = "crumbled";
		public static final String CHISELED = "chiseled";
	}
	
	public static class Suffixes
	{
		public static final String POLISHED = "polished";
		public static final String BRICK = "brick";
		public static final String LOG = "log";
		public static final String WOOD = "wood";
		public static final String PLANKS = "planks";
		public static final String SAPLING = "sapling";
		public static final String LEAVES = "leaves";
		public static final String ORE = "ore";
		public static final String GEM = "gem";
		public static final String INGOT = "ingot";
		public static final String PILLAR = "pillar";
		public static final String SLAB = "slab";
		public static final String STAIRS = "stairs";
		public static final String FENCE = "fence";
		public static final String WALL = "wall";
		public static final String FENCE_GATE = "fence_gate";
		public static final String BUTTON = "button";
		public static final String PRESSURE_PLATE = "pressure_plate";
		public static final String TREE = "tree";
		public static final String PIECE = "piece";
		public static final String STONE = "stone";
	}
	
	public static class Groups
	{
		public static final String BLOCK = "block";
		public static final String ITEM = "item";

		public static final String ENTITY = "entity";
		public static final String METAL = "metal";
		public static final String PLANT = "plant";
		public static final String TEXTURES = "textures";
		public static final String GUI = "gui";
		public static final String STORAGE_BLOCK = "storage_block";
	}
	
	public static class Misc
	{
		public static final String ADD = "add";
		public static final String ACTIVE = "active";
		public static final String DORMANT = "dormant";
		public static final String ACTIVATED = "activated";
		public static final String TOP = "top";
		public static final String END = "end";
	}
	
	public static String buildName(String... parts)
	{
		return buildName('_', parts);
	}
	
	public static String buildName(Character separator, String... parts)
	{
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < parts.length; i++)
		{
			boolean didSet = false;
			String part = parts[i];
			if(part.length() > 1)
			{
				builder.append(part);
				didSet = true;
			}
			
			if (i + 1 < parts.length && didSet)
			{
				builder.append(separator);
			}
		}
		
		return builder.toString();
	}
	
	public static ResourceLocation modRes(String path)
	{
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
	
	public static ResourceLocation commonRes(String path)
	{
		return ResourceLocation.fromNamespaceAndPath("c", path);
	}
	
	static final String MOD_ID = "seidra";
}
