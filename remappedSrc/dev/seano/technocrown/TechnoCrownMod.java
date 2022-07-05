package dev.seano.technocrown;

import dev.seano.technocrown.block.TechnoBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class TechnoCrownMod implements ModInitializer {

    public static final String MOD_ID = "technocrown";

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        TechnoBlocks.register();
    }
}
