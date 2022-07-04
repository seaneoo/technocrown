package dev.seano.technocrown.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static dev.seano.technocrown.TechnoCrownMod.identifier;

public class TechnoBlocks {

    public static final Block CROWN = new CrownBlock(FabricBlockSettings.of(Material.METAL)
            .nonOpaque()
            .strength(0.5f));

    @SuppressWarnings("SameParameterValue")
    private static void registerBlock(Block block, String id) {
        Registry.register(Registry.BLOCK, identifier(id), block);
        Registry.register(Registry.ITEM, identifier(id), new BlockItem(block,
                new FabricItemSettings().group(ItemGroup.MISC)));
    }

    public static void register() {
        registerBlock(CROWN, "crown");
    }
}
