package net.pramado.pizza_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.pramado.pizza_mod.block.ModBlocks;
import net.pramado.pizza_mod.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> p_251297_) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIZZA.get())
                .pattern(" p ")
                .pattern("scs")
                .pattern("ddd")
                .define('p', ModItems.PEPPERONI.get())
                .define('c', ModItems.GRATED_CHEESE.get())
                .define('s', ModItems.TOMATO_SAUCE.get())
                .define('d', ModItems.DOUGH.get())
                .unlockedBy(getHasName(ModItems.DOUGH.get()), has(ModItems.DOUGH.get()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.CHEESE.get(), 1)
                .requires(Items.WATER_BUCKET)
                .requires(Items.MILK_BUCKET)
                .requires(ModItems.RENNET.get())
                .requires(ModItems.SALT.get())
                .unlockedBy(getHasName(ModItems.RENNET.get()), has(ModItems.RENNET.get()))
                .save(p_251297_);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_PEPPERONI.get(), 4)
                .requires(Items.BEEF)
                .requires(Items.PORKCHOP)
                .unlockedBy(getHasName(Items.BEEF), has(Items.BEEF))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PIZZA_SLICE.get(), 8)
                .requires(ModItems.PIZZA_CUTTER.get())
                .requires(ModItems.PIZZA.get())
                .unlockedBy(getHasName(ModItems.PIZZA_CUTTER.get()), has(ModItems.PIZZA_CUTTER.get()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRATED_CHEESE.get(), 16)
                .requires(ModItems.CHEESE_GRATER.get())
                .requires(ModItems.CHEESE.get())
                .unlockedBy(getHasName(ModItems.CHEESE_GRATER.get()), has(ModItems.CHEESE_GRATER.get()))
                .save(p_251297_);
    }





}
