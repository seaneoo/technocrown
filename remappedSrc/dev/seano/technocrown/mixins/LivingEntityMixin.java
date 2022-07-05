package dev.seano.technocrown.mixins;

import dev.seano.technocrown.block.TechnoBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "getPreferredEquipmentSlot", at = @At("HEAD"), cancellable = true)
    private static void technocrown$getPreferredEquipmentSlot(ItemStack stack,
                                                              CallbackInfoReturnable<EquipmentSlot> cir) {
        if (stack.isOf(TechnoBlocks.CROWN.asItem())) {
            cir.setReturnValue(EquipmentSlot.HEAD);
        }
    }
}
