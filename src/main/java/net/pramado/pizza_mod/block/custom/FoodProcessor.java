package net.pramado.pizza_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.pramado.pizza_mod.block.entity.FoodProcessorBlockEntity;
import net.pramado.pizza_mod.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

 public class FoodProcessor extends BaseEntityBlock {

     public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
     public FoodProcessor(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

     public BlockState getStateForPlacement(BlockPlaceContext pContext) {
         return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
     }

     @Override
     public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if(pState.getBlock() != pNewState.getBlock()){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof FoodProcessorBlockEntity){
                ((FoodProcessorBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
     }

     @Override
     public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof FoodProcessorBlockEntity){
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (FoodProcessorBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
     }

     @Nullable
     @Override
     public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
       if(pLevel.isClientSide()){
           return null;
       }

       return createTickerHelper(pBlockEntityType, ModBlockEntities.FOOD_PROCESSOR_BE.get(),
               (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
     }

     @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FoodProcessorBlockEntity(pPos, pState);
    }

     protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
         pBuilder.add(FACING);
     }


}
