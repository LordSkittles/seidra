package com.lordskittles.seidra.datagen;

import com.lordskittles.seidra.Seidra;
import com.lordskittles.seidra.common.block.SeidraBlocks;
import com.lordskittles.seidra.common.block.simple.WakestoneBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.lordskittles.seidra.Constants.*;

public class SeidraBlockStateProvider extends BlockStateProvider
{
    public SeidraBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, Seidra.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        registerWakestone();

        axisBlockSubFolder(SeidraBlocks.ASH_LOG, Suffixes.WOOD, Misc.TOP);
        axisBlockSubFolder(SeidraBlocks.PINE_LOG, Suffixes.WOOD, Misc.TOP);
        axisBlockSubFolder(SeidraBlocks.YEW_LOG, Suffixes.WOOD, Misc.TOP);

        blockWithItemSubFolder(SeidraBlocks.ASH_WOOD, Suffixes.WOOD, Suffixes.WOOD, Suffixes.LOG);
        blockWithItemSubFolder(SeidraBlocks.PINE_WOOD, Suffixes.WOOD, Suffixes.WOOD, Suffixes.LOG);
        blockWithItemSubFolder(SeidraBlocks.YEW_WOOD, Suffixes.WOOD, Suffixes.WOOD, Suffixes.LOG);

        axisBlockSubFolder(SeidraBlocks.STRIPPED_ASH_LOG, Suffixes.WOOD, Misc.TOP);
        axisBlockSubFolder(SeidraBlocks.STRIPPED_PINE_LOG, Suffixes.WOOD, Misc.TOP);
        axisBlockSubFolder(SeidraBlocks.STRIPPED_YEW_LOG, Suffixes.WOOD, Misc.TOP);

        blockWithItemSubFolder(SeidraBlocks.STRIPPED_ASH_WOOD, Suffixes.WOOD, Suffixes.WOOD, Suffixes.LOG);
        blockWithItemSubFolder(SeidraBlocks.STRIPPED_PINE_WOOD, Suffixes.WOOD, Suffixes.WOOD, Suffixes.LOG);
        blockWithItemSubFolder(SeidraBlocks.STRIPPED_YEW_WOOD, Suffixes.WOOD, Suffixes.WOOD, Suffixes.LOG);

        blockWithItemSubFolder(SeidraBlocks.ASH_PLANKS, Suffixes.WOOD);
        blockWithItemSubFolder(SeidraBlocks.PINE_PLANKS, Suffixes.WOOD);
        blockWithItemSubFolder(SeidraBlocks.YEW_PLANKS, Suffixes.WOOD);

        saplingBlockWithItem(SeidraBlocks.ASH_SAPLING);
        saplingBlockWithItem(SeidraBlocks.PINE_SAPLING);
        saplingBlockWithItem(SeidraBlocks.YEW_SAPLING);

        blockWithItemSubFolder(SeidraBlocks.ASH_LEAVES, Groups.PLANT);
        blockWithItemSubFolder(SeidraBlocks.PINE_LEAVES, Groups.PLANT);
        blockWithItemSubFolder(SeidraBlocks.YEW_LEAVES, Groups.PLANT);

        woodGroup(SeidraBlocks.ASH_STAIRS, SeidraBlocks.ASH_SLAB, SeidraBlocks.ASH_FENCE, SeidraBlocks.ASH_FENCE_GATE, SeidraBlocks.ASH_BUTTON, SeidraBlocks.ASH_PRESSURE_PLATE, SeidraBlocks.ASH_PLANKS);
        woodGroup(SeidraBlocks.PINE_STAIRS, SeidraBlocks.PINE_SLAB, SeidraBlocks.PINE_FENCE, SeidraBlocks.PINE_FENCE_GATE, SeidraBlocks.PINE_BUTTON, SeidraBlocks.PINE_PRESSURE_PLATE, SeidraBlocks.PINE_PLANKS);
        woodGroup(SeidraBlocks.YEW_STAIRS, SeidraBlocks.YEW_SLAB, SeidraBlocks.YEW_FENCE, SeidraBlocks.YEW_FENCE_GATE, SeidraBlocks.YEW_BUTTON, SeidraBlocks.YEW_PRESSURE_PLATE, SeidraBlocks.YEW_PLANKS);

        blockWithItemSubFolder(SeidraBlocks.BISMUTH_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.SILVER_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.TUNGSTEN_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.AMBER_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.LABRADORITE_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.THULITE_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.RAW_BISMUTH_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.RAW_SILVER_BLOCK, Groups.STORAGE_BLOCK);
        blockWithItemSubFolder(SeidraBlocks.RAW_TUNGSTEN_BLOCK, Groups.STORAGE_BLOCK);

        blockWithItemSubFolder(SeidraBlocks.BISMUTH_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.SILVER_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.TUNGSTEN_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.AMBER_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.LABRADORITE_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.THULITE_ORE, Suffixes.ORE);

        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_BISMUTH_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_SILVER_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_TUNGSTEN_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_AMBER_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_LABRADORITE_ORE, Suffixes.ORE);
        blockWithItemSubFolder(SeidraBlocks.DEEPSLATE_THULITE_ORE, Suffixes.ORE);

        blockWithItemSubFolder(SeidraBlocks.FELDSPAR, Suffixes.STONE);
        blockWithItemSubFolder(SeidraBlocks.FELDSPAR_BRICK, Suffixes.STONE);
        blockWithItemSubFolder(SeidraBlocks.POLISHED_FELDSPAR, Suffixes.STONE);
        blockWithItemSubFolder(SeidraBlocks.CRACKED_FELDSPAR, Suffixes.STONE);
        blockWithItemSubFolder(SeidraBlocks.CRACKED_FELDSPAR_BRICK, Suffixes.STONE);
        blockWithItemSubFolder(SeidraBlocks.CRACKED_POLISHED_FELDSPAR, Suffixes.STONE);
        blockWithItemSubFolder(SeidraBlocks.CHISELED_FELDSPAR_BRICK, Suffixes.STONE);
        axisBlockSubFolder(SeidraBlocks.FELDSPAR_PILLAR, Suffixes.STONE, Misc.TOP);

        stoneGroup(SeidraBlocks.FELDSPAR_STAIRS, SeidraBlocks.FELDSPAR_SLAB, SeidraBlocks.FELDSPAR_WALL, SeidraBlocks.FELDSPAR_BUTTON, SeidraBlocks.FELDSPAR_PRESSURE_PLATE, SeidraBlocks.FELDSPAR);
        stoneGroup(SeidraBlocks.FELDSPAR_BRICK_STAIRS, SeidraBlocks.FELDSPAR_BRICK_SLAB, SeidraBlocks.FELDSPAR_BRICK_WALL, null, null, SeidraBlocks.FELDSPAR_BRICK);
        stoneGroup(SeidraBlocks.POLISHED_FELDSPAR_STAIRS, SeidraBlocks.POLISHED_FELDSPAR_SLAB, SeidraBlocks.POLISHED_FELDSPAR_WALL, null, null, SeidraBlocks.POLISHED_FELDSPAR);

        blockWithItem(SeidraBlocks.ARCANE_CRAFTING_BLOCK);

        ResourceLocation crackedDeepslateBricks = ResourceLocation.withDefaultNamespace(buildName('/', Groups.BLOCK, buildName(Prefixes.CRACKED, Prefixes.DEEPSLATE, Suffixes.BRICK + "s")));

        stairsBlock((StairBlock) SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), crackedDeepslateBricks);
        slabBlock((SlabBlock) SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(), crackedDeepslateBricks, crackedDeepslateBricks);
        blockItem(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);
        blockItem(SeidraBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);
    }

    public void registerWakestone()
    {
        ResourceLocation dormantWakestoneSide = modRes(buildName('/', Groups.BLOCK, Suffixes.STONE, buildName(Types.WAKESTONE, Suffixes.PILLAR)));
        ResourceLocation activeWakestoneSide = modRes(buildName('/', Groups.BLOCK, Suffixes.STONE, buildName(Misc.ACTIVATED, Types.WAKESTONE, Suffixes.PILLAR)));
        ResourceLocation wakestoneEnd = modRes(buildName('/', Groups.BLOCK, Suffixes.STONE, buildName(Types.WAKESTONE, Suffixes.PILLAR, Misc.END)));

        ModelFile dormantVertical = this.models().cubeColumn(
                buildName(Misc.DORMANT, Types.WAKESTONE), dormantWakestoneSide, wakestoneEnd
        );
        ModelFile dormantHorizontal = this.models().cubeColumnHorizontal(
                buildName(Misc.DORMANT, Types.WAKESTONE), dormantWakestoneSide, wakestoneEnd
        );

        ModelFile activeVertical = this.models().cubeColumn(
                buildName(Misc.ACTIVE, Types.WAKESTONE), activeWakestoneSide, wakestoneEnd
        );
        ModelFile activeHorizontal = this.models().cubeColumnHorizontal(
                buildName(Misc.ACTIVE, Types.WAKESTONE), activeWakestoneSide, wakestoneEnd
        );

        wakestoneState(false, Direction.Axis.Y).modelForState().modelFile(dormantVertical).addModel();
        wakestoneState(true, Direction.Axis.Y).modelForState().modelFile(activeVertical).addModel();
        wakestoneState(false, Direction.Axis.X).modelForState().modelFile(dormantHorizontal).rotationX(90).rotationY(90).addModel();
        wakestoneState(true, Direction.Axis.X).modelForState().modelFile(activeHorizontal).rotationX(90).rotationY(90).addModel();
        wakestoneState(false, Direction.Axis.Z).modelForState().modelFile(dormantHorizontal).rotationX(90).addModel();
        wakestoneState(true, Direction.Axis.Z).modelForState().modelFile(activeHorizontal).rotationX(90).addModel();

        simpleBlockItem(SeidraBlocks.WAKESTONE.get(), dormantVertical);
    }

    public VariantBlockStateBuilder.PartialBlockstate wakestoneState(boolean active, Direction.Axis axis)
    {
        return this.getVariantBuilder(SeidraBlocks.WAKESTONE.get()).partialState()
                .with(RotatedPillarBlock.AXIS, axis).with(WakestoneBlock.ACTIVE, active);
    }

    public void blockWithItem(DeferredBlock<?> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    public void saplingBlockWithItem(DeferredBlock<?> deferredBlock)
    {
        ResourceLocation location = modRes(buildName('/', Groups.BLOCK, Groups.PLANT, deferredBlock.getId().getPath()));

        BlockModelBuilder blockModel = this.models().cross(deferredBlock.getId().getPath(), location).renderType(ERenderType.Cutout.toString());
        simpleBlock(deferredBlock.get(), blockModel);
    }

    public void blockWithItemSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAllSubFolder(deferredBlock, subFolder));
    }

    public void blockWithItemSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String toReplace, String replacement)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAllSubFolder(deferredBlock, subFolder, toReplace, replacement));
    }

    public ModelFile cubeAllSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        return cubeAllSubFolder(deferredBlock, subFolder, "", "");
    }

    public ModelFile cubeAllSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String toReplace, String replacement)
    {
        ResourceLocation blockId = deferredBlock.getId();

        ResourceLocation location = modRes(buildName('/', Groups.BLOCK, subFolder, blockId.getPath().replace(toReplace, replacement)));

        return this.models().cubeAll(deferredBlock.getId().getPath(), location);
    }

    public void axisBlockSubFolder(DeferredBlock<?> deferredBlock, String subFolder)
    {
        axisBlockSubFolder(deferredBlock, subFolder, "");
    }

    public void axisBlockSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String endName)
    {
        axisBlockSubFolder(deferredBlock, subFolder, endName, "", "");
    }

    public void axisBlockSubFolder(DeferredBlock<?> deferredBlock, String subFolder, String endName, String toReplace, String replacement)
    {
        ResourceLocation blockId = deferredBlock.getId();

        ResourceLocation location = modRes(buildName('/', Groups.BLOCK, subFolder, blockId.getPath().replace(toReplace, replacement)));

        ResourceLocation end = !endName.isEmpty() ? extend(location, "_" + endName) : location;

        axisBlock(((RotatedPillarBlock) deferredBlock.get()),
                this.models().cubeColumn(blockId.getPath(), location, end),
                this.models().cubeColumnHorizontal(blockId.getPath(), location, end)
        );

        simpleBlockItem(deferredBlock.get(), this.models().cubeColumn(blockId.getPath(), location, end));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(modRes(buildName('/', Groups.BLOCK, deferredBlock.getId().getPath()))));
    }

    private void woodGroup(DeferredBlock<Block> stair, DeferredBlock<Block> slab, DeferredBlock<Block> fence, DeferredBlock<Block> fenceGate, DeferredBlock<Block> button, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> parentBlock)
    {
        ResourceLocation textureLoc = modRes(buildName('/', Groups.BLOCK, Suffixes.WOOD, parentBlock.getId().getPath()));
        ResourceLocation doubleSlabLoc = modRes(buildName('/', Groups.BLOCK, parentBlock.getId().getPath()));

        stairsBlock(((StairBlock) stair.get()), textureLoc);
        slabBlock(((SlabBlock) slab.get()), doubleSlabLoc, textureLoc);
        fenceBlock(((FenceBlock) fence.get()), textureLoc);
        fenceGateBlock(((FenceGateBlock) fenceGate.get()), textureLoc);
        pressurePlateBlock(((PressurePlateBlock) pressurePlate.get()), textureLoc);
        buttonBlock(((ButtonBlock) button.get()), textureLoc);

        blockItem(stair);
        blockItem(slab);
        blockItem(fenceGate);
        blockItem(pressurePlate);
    }

    private void stoneGroup(DeferredBlock<Block> stair, DeferredBlock<Block> slab, DeferredBlock<Block> wall, DeferredBlock<Block> button, DeferredBlock<Block> pressurePlate, DeferredBlock<Block> parentBlock)
    {
        ResourceLocation textureLoc = modRes(buildName('/', Groups.BLOCK, Suffixes.STONE, parentBlock.getId().getPath()));
        ResourceLocation doubleSlabLoc = modRes(buildName('/', Groups.BLOCK, parentBlock.getId().getPath()));

        stairsBlock(((StairBlock) stair.get()), textureLoc);
        slabBlock(((SlabBlock) slab.get()), doubleSlabLoc, textureLoc);
        wallBlock(((WallBlock) wall.get()), textureLoc);

        if(pressurePlate != null)
        {
            pressurePlateBlock(((PressurePlateBlock) pressurePlate.get()), textureLoc);
            blockItem(pressurePlate);
        }
        if(button != null)
        {
            buttonBlock(((ButtonBlock) button.get()), textureLoc);
        }

        blockItem(stair);
        blockItem(slab);
    }

    public ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        String namespace = rl.getNamespace();
        String path = rl.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
