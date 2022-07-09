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
        if (this.getEquippedStack(EquipmentSlot.HEAD)
                .isOf(TechnoBlocks.CROWN.asItem())) {
            this.equipStack(EquipmentSlot.HEAD, null);
            player.giveItemStack(new ItemStack(TechnoBlocks.CROWN.asItem()));
        } else {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(TechnoBlocks.CROWN.asItem()) && this.getEquippedStack(EquipmentSlot.HEAD)
                    .isEmpty()) {
                if (!player.getAbilities().creativeMode) itemStack.decrement(1);
                this.equipStack(EquipmentSlot.HEAD, new ItemStack(TechnoBlocks.CROWN.asItem()));
            }
        }
        return super.interactMob(player, hand);
    }
}
