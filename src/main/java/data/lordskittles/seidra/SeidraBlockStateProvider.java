package data.lordskittles.seidra;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.blocks.SeidraBlock;
import com.lordskittles.seidra.common.blocks.SeidraLogBlock;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SeidraBlockStateProvider extends BlockStateProvider
{
    public SeidraBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Seidra.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        registerColumnBlockInFolder(Blocks.JUNIPER_LOG, "wood");
        registerColumnBlockInFolder(Blocks.PINE_LOG, "wood");
        registerColumnBlockInFolder(Blocks.YEW_LOG, "wood");

        registerColumnBlockInFolder(Blocks.STRIPPED_JUNIPER_LOG, "wood");
        registerColumnBlockInFolder(Blocks.STRIPPED_PINE_LOG, "wood");
        registerColumnBlockInFolder(Blocks.STRIPPED_YEW_LOG, "wood");

        registerBlockInFolder(Blocks.JUNIPER_PLANKS, "wood");
        registerBlockInFolder(Blocks.PINE_PLANKS, "wood");
        registerBlockInFolder(Blocks.YEW_PLANKS, "wood");

        registerBlockInFolder(Blocks.BISMUTH_ORE, "ores");
        registerBlockInFolder(Blocks.COBALT_ORE, "ores");
        registerBlockInFolder(Blocks.TUNGSTEN_ORE, "ores");
        registerBlockInFolder(Blocks.IOLITE_ORE, "ores");
        registerBlockInFolder(Blocks.THULITE_ORE, "ores");
        registerBlockInFolder(Blocks.ZOISITE_ORE, "ores");

        registerBlockInFolder(Blocks.DEEPSLATE_BISMUTH_ORE, "ores");
        registerBlockInFolder(Blocks.DEEPSLATE_COBALT_ORE, "ores");
        registerBlockInFolder(Blocks.DEEPSLATE_TUNGSTEN_ORE, "ores");
        registerBlockInFolder(Blocks.DEEPSLATE_IOLITE_ORE, "ores");
        registerBlockInFolder(Blocks.DEEPSLATE_THULITE_ORE, "ores");
        registerBlockInFolder(Blocks.DEEPSLATE_ZOISITE_ORE, "ores");
    }

    private <BLOCK extends SeidraBlock> void registerBlockInFolder(DeferredBlock<BLOCK> block, String folder)
    {
        ResourceLocation blockTexture = ResourceLocation.fromNamespaceAndPath(
                Seidra.MODID,
                ModelProvider.BLOCK_FOLDER + "/" + folder + "/" + block.getId().getPath()
        );

        simpleBlock(block.get(), models().cubeAll(block.getId().getPath(), blockTexture));
    }

    private <BLOCK extends SeidraLogBlock> void registerColumnBlockInFolder(DeferredBlock<BLOCK> block, String folder)
    {
        ResourceLocation blockTexture = ResourceLocation.fromNamespaceAndPath(
                Seidra.MODID,
                ModelProvider.BLOCK_FOLDER + "/" + folder + "/" + block.getId().getPath()
        );

        axisBlock(block.get(), blockTexture, extend(blockTexture, "_top"));
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        return ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), rl.getPath() + suffix);
    }
}
