package data.lordskittles.seidra;

import com.lordskittles.seidra.Seidra;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SeidraItemTagsProvider extends ItemTagsProvider
{
    public SeidraItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(p_126530_, p_126531_, Seidra.MODID, existingFileHelper);
    }
}
