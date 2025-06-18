package com.lordskittles.seidra.common;

import api.lordskittles.seidra.common.sai.schools.SpellSchoolAssignmentEvent;
import api.lordskittles.seidra.common.registry.SeidraRegistries;
import api.lordskittles.seidra.common.sai.schools.School;
import api.lordskittles.seidra.interfaces.ICreativeTabProvider;
import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.*;
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
		Blocks.BLOCKS.register(eventBus);
		Items.ITEMS.register(eventBus);
		CreativeTabs.TABS.register(eventBus);
		Spells.SPELLS.register(eventBus);
		Schools.SCHOOLS.register(eventBus);
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
				bus.post(new SpellSchoolAssignmentEvent(school));
			}
		});
	}

	@SubscribeEvent
	public static void spellSchoolAssignmentEvent(SpellSchoolAssignmentEvent event)
	{
		if (event.getSchool() == Schools.EXAMPLE_SCHOOL.get())
		{
			event.accept(Spells.EXAMPLE_SPELL);
		}
	}

	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent event)
	{
		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
		{
			event.accept(Blocks.CRACKED_DEEPSLATE_BRICK_SLAB.get());
			event.accept(Blocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get());
		}

		Blocks.BLOCKS.getEntries().forEach(block ->
		{
			if (block.get() instanceof ICreativeTabProvider provider)
			{
				if (provider.getTab().get() == event.getTab())
				{
					event.accept(block.get());
				}
			}
		});

		Items.ITEMS.getEntries().forEach(item ->
		{
			if (item.get() instanceof ICreativeTabProvider provider)
			{
				if (provider.getTab().get() == event.getTab())
				{
					event.accept(item.get());
				}
			}
		});
	}
}
