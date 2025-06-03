package api.lordskittles.seidra.interfaces;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;

public interface IItemModelProvider
{
	ItemModelBuilder modelBuilder(ItemModelProvider modelProvider, ResourceLocation key);
}
