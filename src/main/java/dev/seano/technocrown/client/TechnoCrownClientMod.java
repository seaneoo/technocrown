package dev.seano.technocrown.client;

import dev.seano.technocrown.client.model.CrownFeatureModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

import static dev.seano.technocrown.TechnoCrownMod.identifier;

@Environment(EnvType.CLIENT)
public class TechnoCrownClientMod implements ClientModInitializer {

    public static final EntityModelLayer MODEL_LAYER_CROWN = new EntityModelLayer(identifier("crown"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(MODEL_LAYER_CROWN, CrownFeatureModel::getTexturedModelData);
    }
}
