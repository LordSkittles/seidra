package data.lordskittles.seidra;

import com.lordskittles.seidra.Seidra;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SeidraBlockTagsProvider extends BlockTagsProvider
{
    public SeidraBlockTagsProvider(DataGenerator p_126511_, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(p_126511_, Seidra.MODID, existingFileHelper);
    }
}
