package net.pramado.pizza_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pramado.pizza_mod.PizzaMod;
import net.pramado.pizza_mod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PizzaMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> PIZZA_MOD_TAB = CREATIVE_MODE_TABS.register("pizza_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PIZZA.get()))
                    .title(Component.translatable("creativetab.pizza_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                           pOutput.accept(ModItems.PIZZA.get());
                           pOutput.accept(ModItems.DOUGH.get());
                           pOutput.accept(ModItems.TOMATO.get());
                           pOutput.accept(ModItems.PEPPERONI.get());
                           pOutput.accept(ModItems.SALT.get());
                           pOutput.accept(ModItems.CHEESE_GRATER.get());
                           pOutput.accept(ModItems.CHEESE.get());
                        pOutput.accept(ModItems.GRATED_CHEESE.get());
                           pOutput.accept(ModItems.TOMATO_SAUCE.get());
                           pOutput.accept(ModItems.TOMATO_SEEDS.get());

                           pOutput.accept(ModBlocks.SALT_ORE.get());
                           pOutput.accept(ModBlocks.FOOD_PROCESSOR.get());

                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

