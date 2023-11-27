package net.pramado.pizza_mod.datagen.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pramado.pizza_mod.PizzaMod;

public class ModBlockLootTables extends BlockStateProvider {
    public ModBlockLootTables(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PizzaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
