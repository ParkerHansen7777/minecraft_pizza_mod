package pizza_mod.com.pizza_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import pizza_mod.com.pizza_mod.PizzaMod;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PizzaMod.MODID);
    public static final RegistryObject<CreativeModeTab> PIZZA_MOD_TAB = CREATIVE_MODE_TABS.register("pizza_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PIZZA.get()))
                    .title(Component.translatable("creativetab.pizza_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                           pOutput.accept(ModItems.PIZZA.get());
                           pOutput.accept(ModItems.DOUGH.get());
                           pOutput.accept(ModItems.TOMATO.get());
                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

