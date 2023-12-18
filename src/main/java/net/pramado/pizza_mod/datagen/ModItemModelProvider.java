package net.pramado.pizza_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.pramado.pizza_mod.PizzaMod;
import net.pramado.pizza_mod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PizzaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PIZZA);
        simpleItem(ModItems.DOUGH);
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.PEPPERONI);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.CHEESE_GRATER);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.GRATED_CHEESE);
        simpleItem(ModItems.TOMATO_SAUCE);
        simpleItem(ModItems.TOMATO_SEEDS);
        simpleItem(ModItems.PIZZA_CUTTER);
        simpleItem(ModItems.PIZZA_SLICE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PizzaMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
