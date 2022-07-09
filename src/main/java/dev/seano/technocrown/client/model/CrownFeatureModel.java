package dev.seano.technocrown.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class CrownFeatureModel<T extends LivingEntity> extends EntityModel<T> {

    private final ModelPart root;

    public CrownFeatureModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,
                0.0F, 0.0F));
        root.addChild("north", ModelPartBuilder.create()
                .uv(8, 3)
                .cuboid(-12.0F, -2.0F, 4.0F, 8.0F, 2.0F, 1.0F, Dilation.NONE)
                .uv(14, 10)
                .cuboid(-12.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(13, 7)
                .cuboid(-10.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(8, 12)
                .cuboid(-7.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(0, 12)
                .cuboid(-5.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE), ModelTransform.pivot(8.0F, 0.0F, -8.0F));
        root.addChild("east", ModelPartBuilder.create()
                .uv(0, 8)
                .cuboid(-12.0F, -2.0F, 5.0F, 1.0F, 2.0F, 6.0F, Dilation.NONE)
                .uv(11, 11)
                .cuboid(-12.0F, -3.0F, 6.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(11, 9)
                .cuboid(-12.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(8, 10)
                .cuboid(-12.0F, -3.0F, 10.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE), ModelTransform.pivot(8.0F, 0.0F,
                -8.0F));
        root.addChild("south", ModelPartBuilder.create()
                .uv(8, 0)
                .cuboid(-4.0F, 6.0F, 3.0F, 8.0F, 2.0F, 1.0F, Dilation.NONE)
                .uv(0, 10)
                .cuboid(-3.0F, 5.0F, 3.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(0, 0)
                .cuboid(-1.0F, 5.0F, 3.0F, 2.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(8, 8)
                .cuboid(2.0F, 5.0F, 3.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE), ModelTransform.pivot(0.0F, -8.0F, 0.0F));
        root.addChild("west", ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(3.0F, 6.0F, -3.0F, 1.0F, 2.0F, 6.0F, Dilation.NONE)
                .uv(0, 8)
                .cuboid(3.0F, 5.0F, 2.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(0, 4)
                .cuboid(3.0F, 5.0F, 0.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE)
                .uv(0, 2)
                .cuboid(3.0F, 5.0F, -2.0F, 1.0F, 1.0F, 1.0F, Dilation.NONE), ModelTransform.pivot(0.0F, -8.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
                          float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
                       float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
