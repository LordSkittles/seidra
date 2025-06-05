package api.lordskittles.seidra.common.registry;

import api.lordskittles.seidra.SeidraAPI;
import api.lordskittles.seidra.common.sai.schools.School;
import api.lordskittles.seidra.common.sai.spells.Spell;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

@EventBusSubscriber(modid = SeidraAPI.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SeidraRegistries
{
	public static final ResourceKey<Registry<Spell>> SPELL_REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(SeidraAPI.MODID, "spells"));
	public static final ResourceKey<Registry<School>> SCHOOL_REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(SeidraAPI.MODID, "schools"));

	public static final Registry<Spell> SPELL_REGISTRY = new RegistryBuilder<>(SPELL_REGISTRY_KEY)
			.defaultKey(ResourceLocation.fromNamespaceAndPath(SeidraAPI.MODID, "empty"))
			.sync(true).maxId(256).create();

	public static final Registry<School> SCHOOL_REGISTRY = new RegistryBuilder<>(SCHOOL_REGISTRY_KEY)
			.defaultKey(ResourceLocation.fromNamespaceAndPath(SeidraAPI.MODID, "empty"))
			.sync(true).maxId(256).create();

	@SubscribeEvent
	public static void registerRegistries(NewRegistryEvent event)
	{
		event.register(SPELL_REGISTRY);
		event.register(SCHOOL_REGISTRY);
	}

	public static Spells createSpells(String modId)
	{
		return new Spells(modId);
	}

	public static Schools createSchools(String modId)
	{
		return new Schools(modId);
	}

	public static class Spells
	{
		private final DeferredRegister<Spell> deferredRegister;

		protected Spells(String modid)
		{
			this.deferredRegister = DeferredRegister.create(SPELL_REGISTRY_KEY, modid);
		}

		public void register(IEventBus eventBus)
		{
			deferredRegister.register(eventBus);
		}

		public <T extends Spell> DeferredSpell<T> register(String name, java.util.function.Supplier<T> supplier)
		{
			// Register with the deferred register
			var holder = deferredRegister.register(name, supplier);

			// Create and return your custom DeferredSpell
			return new DeferredSpell<>(holder);
		}

		// Method to get the DeferredRegister (needed for mod bus registration)
		public DeferredRegister<Spell> getDeferredRegister()
		{
			return deferredRegister;
		}
	}

	public static class Schools
	{
		private final DeferredRegister<School> deferredRegister;

		protected Schools(String modid)
		{
			this.deferredRegister = DeferredRegister.create(SCHOOL_REGISTRY_KEY, modid);
		}

		public void register(IEventBus eventBus)
		{
			deferredRegister.register(eventBus);
		}

		public <T extends School> DeferredSchool<T> register(String name, java.util.function.Supplier<T> supplier)
		{
			// Register with the deferred register
			var holder = deferredRegister.register(name, supplier);

			// Create and return your custom DeferredSpell
			return new DeferredSchool<>(holder);
		}

		// Method to get the DeferredRegister (needed for mod bus registration)
		public DeferredRegister<School> getDeferredRegister()
		{
			return deferredRegister;
		}
	}
}
