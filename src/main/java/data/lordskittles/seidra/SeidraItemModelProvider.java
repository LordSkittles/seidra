package data.lordskittles.seidra;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.registries.Blocks;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class SeidraItemModelProvider extends ItemModelProvider
{
    public SeidraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Seidra.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        blockGroup(new DeferredBlock[]{ Blocks.JUNIPER_LOG, Blocks.JUNIPER_PLANKS, Blocks.STRIPPED_JUNIPER_LOG });
        blockGroup(new DeferredBlock[]{ Blocks.PINE_LOG, Blocks.PINE_PLANKS, Blocks.STRIPPED_PINE_LOG });
        blockGroup(new DeferredBlock[]{ Blocks.YEW_LOG, Blocks.YEW_PLANKS, Blocks.STRIPPED_YEW_LOG });

        blockGroup(new DeferredBlock[]{ Blocks.BISMUTH_ORE, Blocks.COBALT_ORE, Blocks.TUNGSTEN_ORE, Blocks.IOLITE_ORE, Blocks.THULITE_ORE, Blocks.ZOISITE_ORE });
        blockGroup(new DeferredBlock[]{ Blocks.DEEPSLATE_BISMUTH_ORE, Blocks.DEEPSLATE_COBALT_ORE, Blocks.DEEPSLATE_TUNGSTEN_ORE, Blocks.DEEPSLATE_IOLITE_ORE, Blocks.DEEPSLATE_THULITE_ORE, Blocks.DEEPSLATE_ZOISITE_ORE });
    }

    private void blockGroup(DeferredBlock<Block>[] blocks)
    {
        for (DeferredBlock<Block> block : blocks)
        {
            simpleBlock(block.getId());
        }
    }

    private void simpleBlock(ResourceLocation resource)
    {
        getBuilder(Objects.requireNonNull(resource).getPath())
                .parent(new ModelFile.UncheckedModelFile(modid + ":block/" + resource.getPath()));
    }
}
