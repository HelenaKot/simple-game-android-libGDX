package com.mygdx.game.blocks;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.BlockData;
import com.mygdx.game.RegionAtlas;
import com.mygdx.game.RegionAtlas.BlockShape;

public class BlockFactory {
    private static BlockData emptyBlockData = RegionAtlas.instance.get(0);

    public static Block createBlock() {
        return createBlock(emptyBlockData, Color.WHITE);
    }

    public static Block createBlock(BlockData blockData, Color tint) {
        if (blockData.shape == BlockShape.BUILDABLE || blockData.shape == BlockShape.LOCKED) {
            return new EmptyBlock(blockData, tint);
        } else
            return new Block(blockData, tint);
    }
}

