package net.pramado.pizza_mod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pramado.pizza_mod.PizzaMod;
import net.pramado.pizza_mod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PizzaMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<FoodProcessorBlockEntity>> FOOD_PROCESSOR_BE =
            BLOCK_ENTITIES.register("food_processor_be", () ->
                    BlockEntityType.Builder.of(FoodProcessorBlockEntity::new,
                            ModBlocks.FOOD_PROCESSOR.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
