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
                .pattern(" m ")
                .pattern(" d ")
                .pattern("   ")
                .define('m', Items.COOKED_BEEF)
                .define('d', ModItems.DOUGH.get())
                .unlockedBy(getHasName(ModItems.DOUGH.get()), has(ModItems.DOUGH.get()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.PEPPERONI.get(), 4)
                .requires(Items.COOKED_BEEF)
                .unlockedBy(getHasName(Items.COOKED_BEEF), has(Items.COOKED_BEEF))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PIZZA_SLICE.get(), 8)
                .requires(ModItems.PIZZA_CUTTER.get())
                .requires(ModItems.PIZZA.get())
                .unlockedBy(getHasName(ModItems.PIZZA_CUTTER.get()), has(ModItems.PIZZA_CUTTER.get()))
                .save(p_251297_);
    }





}
