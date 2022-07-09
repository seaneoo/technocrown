package dev.seano.technocrown.mixins;

import dev.seano.technocrown.block.TechnoBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemSteerable;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PigEntity.class)
public abstract class PigEntityMixin extends AnimalEntity implements ItemSteerable, Saddleable {

    protected PigEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            ItemStack head = this.getEquippedStack(EquipmentSlot.HEAD);
            // Put crown on head
            if (head.isEmpty()) {
                ItemStack itemStack = player.getStackInHand(hand);
                if (itemStack.isOf(TechnoBlocks.CROWN.asItem())) {
                    this.equipStack(EquipmentSlot.HEAD, new ItemStack(itemStack.getItem()));
                    if (!player.getAbilities().creativeMode) itemStack.decrement(1);
                }
            } else
            // Remove crown from head
            {
                ItemStack itemStack = this.getEquippedStack(EquipmentSlot.HEAD);
                player.giveItemStack(itemStack);
                this.equipStack(EquipmentSlot.HEAD, ItemStack.EMPTY);
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }
}
