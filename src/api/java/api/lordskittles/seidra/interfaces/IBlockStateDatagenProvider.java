package api.lordskittles.seidra.interfaces;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;

public interface IBlockStateDatagenProvider<PROVIDER extends BlockStateProvider>
{
    public Runnable generate(PROVIDER provider);
}
