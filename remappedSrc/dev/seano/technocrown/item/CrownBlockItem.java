package dev.seano.technocrown.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Wearable;

public class CrownBlockItem extends BlockItem implements Wearable {

    public CrownBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
}
