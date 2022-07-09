package dev.seano.technocrown.mixins;

import dev.seano.technocrown.client.render.CrownFeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.entity.passive.PigEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntityRenderer.class)
public abstract class PigEntityRendererMixin extends MobEntityRenderer<PigEntity, PigEntityModel<PigEntity>> {

    public PigEntityRendererMixin(EntityRendererFactory.Context context, PigEntityModel<PigEntity> entityModel,
                                  float f) {
        super(context, entityModel, f);
    }

    @Inject(method = "<init>", at = @At("TAIL"), allow = 1)
    private void technocrown$init(EntityRendererFactory.Context context, CallbackInfo ci) {
        this.addFeature(new CrownFeatureRenderer<>(this, context.getModelLoader()));
    }
}
