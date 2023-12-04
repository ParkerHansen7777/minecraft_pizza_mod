package net.pramado.pizza_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.registries.RegistryObject;
import net.pramado.pizza_mod.PizzaMod;
import net.pramado.pizza_mod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PizzaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.SALT_ORE);

        simpleBlockWithItem(ModBlocks.FOOD_PROCESSOR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/food_processor")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
