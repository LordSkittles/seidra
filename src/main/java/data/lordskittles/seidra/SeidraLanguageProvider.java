/*
package data.lordskittles.seidra;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.blocks.IPrettyNameProvider;
import com.lordskittles.seidra.common.registries.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class SeidraLanguageProvider extends LanguageProvider
{
    public SeidraLanguageProvider(DataGenerator gen, String locale)
    {
        super(gen, Seidra.MODID, locale);
    }

    @Override
    protected void addTranslations()
    {
        blockGroup(new RegistryObject[]{ Blocks.JUNIPER_LOG, Blocks.JUNIPER_PLANKS, Blocks.STRIPPED_JUNIPER_LOG });
        blockGroup(new RegistryObject[]{ Blocks.PINE_LOG, Blocks.PINE_PLANKS, Blocks.STRIPPED_PINE_LOG });
        blockGroup(new RegistryObject[]{ Blocks.YEW_LOG, Blocks.YEW_PLANKS, Blocks.STRIPPED_YEW_LOG });

        blockGroup(new RegistryObject[]{ Blocks.BISMUTH_ORE, Blocks.COBALT_ORE, Blocks.TUNGSTEN_ORE, Blocks.IOLITE_ORE, Blocks.THULITE_ORE, Blocks.ZOISITE_ORE });
        blockGroup(new RegistryObject[]{ Blocks.DEEPSLATE_BISMUTH_ORE, Blocks.DEEPSLATE_COBALT_ORE, Blocks.DEEPSLATE_TUNGSTEN_ORE, Blocks.DEEPSLATE_IOLITE_ORE, Blocks.DEEPSLATE_THULITE_ORE, Blocks.DEEPSLATE_ZOISITE_ORE });
    }

    private <BLOCK extends Block & IPrettyNameProvider> void blockGroup(RegistryObject<BLOCK>[] blocks)
    {
        for (RegistryObject<BLOCK> block : blocks)
        {
            addBlock(block);
        }
    }

    private <BLOCK extends Block & IPrettyNameProvider> void addBlock(RegistryObject<BLOCK> block)
    {
        add(block.get(), block.get().getPrettyName());
    }
}
*/
