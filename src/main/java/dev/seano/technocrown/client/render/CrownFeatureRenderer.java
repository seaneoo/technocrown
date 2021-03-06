package dev.seano.technocrown.client.render;

import dev.seano.technocrown.block.TechnoBlocks;
import dev.seano.technocrown.client.model.CrownFeatureModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;

import static dev.seano.technocrown.TechnoCrownMod.identifier;
import static dev.seano.technocrown.client.TechnoCrownClientMod.MODEL_LAYER_CROWN;

@Environment(EnvType.CLIENT)
public class CrownFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {

    private final CrownFeatureModel<T> model;

    public CrownFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader modelLoader) {
        super(context);
        this.model = new CrownFeatureModel<>(modelLoader.getModelPart(MODEL_LAYER_CROWN));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
                       float headPitch) {
        if (entity instanceof AbstractClientPlayerEntity && entity.getEquippedStack(EquipmentSlot.HEAD)
                .isOf(TechnoBlocks.CROWN.asItem())) {
            this.renderCrown(matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress,
                    headYaw, headPitch);
        } else if (entity instanceof PigEntity && entity.getEquippedStack(EquipmentSlot.HEAD)
                .isOf(TechnoBlocks.CROWN.asItem())) {
            this.renderCrown(matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress,
                    headYaw, headPitch);
        }
    }

    private void renderCrown(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity,
                             float limbAngle, float limbDistance, float animationProgress, float headYaw,
                             float headPitch) {
        Identifier texture = identifier("textures/entity/crown.png");

        matrices.push();
        matrices.translate(1f, 1f, 1f);
        this.getContextModel()
                .copyStateTo(this.model);
        this.model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(texture)), light,
                OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 1f);
        matrices.pop();
    }
}
