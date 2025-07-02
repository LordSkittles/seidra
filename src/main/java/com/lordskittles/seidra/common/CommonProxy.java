package com.lordskittles.seidra.common;

import api.lordskittles.seidra.common.registry.SeidraRegistries;
import api.lordskittles.seidra.common.sai.schools.BuildSchoolSpellContentsEvent;
import api.lordskittles.seidra.common.sai.schools.School;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.menu.SeidraMenuTypes;
import com.lordskittles.seidra.common.entities.BlockEntityTypes;
import com.lordskittles.seidra.common.item.SeidraCreativeModeTabs;
import com.lordskittles.seidra.common.item.SeidraItems;
import com.lordskittles.seidra.common.sai.schools.SeidraSchools;
import com.lordskittles.seidra.common.sai.spells.SeidraSpells;
import com.lordskittles.seidra.common.worldgen.structure.SeidraStructureTypes;
import com.lordskittles.seidra.common.worldgen.structure.pieces.SeidraStructurePieceTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = Seidra.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonProxy
{
	public static void initialiseRegistries(IEventBus eventBus)
	{
		SeidraBlocks.BLOCKS.register(eventBus);
		SeidraItems.ITEMS.register(eventBus);
		SeidraCreativeModeTabs.TABS.register(eventBus);
		SeidraSpells.SPELLS.register(eventBus);
		SeidraSchools.SCHOOLS.register(eventBus);
		SeidraStructureTypes.STRUCTURE_TYPES.register(eventBus);
		SeidraStructurePieceTypes.STRUCTURE_PIECE_TYPES.register(eventBus);
		BlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
		SeidraMenuTypes.MENU_TYPES.register(eventBus);
	}

	@SubscribeEvent
	public static void commonSetup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() ->
		{
			IEventBus bus = ModLoadingContext.get().getActiveContainer().getEventBus();

			if (bus == null)
			{
				throw new IllegalStateException("Mod loading failed");
			}

			for (School school : SeidraRegistries.SCHOOL_REGISTRY.stream().toList())
			{
				bus.post(new BuildSchoolSpellContentsEvent(school));
			}
		});
	}

	@SubscribeEvent
	public static void buildSchoolContents(BuildSchoolSpellContentsEvent event)
	{
		if(event.getSchool() == SeidraSchools.DEEPCALLING.getSchool())
		{

		}

		if(event.getSchool() == SeidraSchools.EMBERCRAFT.getSchool())
		{
			event.accept(SeidraSpells.FIREBOLT);
		}

		if(event.getSchool() == SeidraSchools.FROSTWEAVING.getSchool())
		{

		}

		if(event.getSchool() == SeidraSchools.SKYREND.getSchool())
		{
			event.accept(SeidraSpells.HEAL);
		}

		if(event.getSchool() == SeidraSchools.SPIRITGUARD.getSchool())
		{

		}

		if(event.getSchool() == SeidraSchools.FELLWAKE.getSchool())
		{

		}
	}

	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent event)
	{
		/*if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
		{
			event.accept(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get());
			event.accept(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get());
		}*/
	}
}
