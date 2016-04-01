package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.*;

public class BlockFactory {
    private static BlockData
            emptyBlockData = RegionAtlas.instance.get(0),
            buildableEmptyBlockData = RegionAtlas.instance.get(1);

    public static Block createEmptyBlock(int x, int y) {
        return createBlock(x, y, emptyBlockData, Color.WHITE);
    }

    public static Block createBuildableBlock(int x, int y) {
        return createBlock(x, y, buildableEmptyBlockData, Color.WHITE);
    }

    public static Block createBlock(int x, int y, BlockData blockData, Color tint) {
        if (blockData.shape == com.mygdx.game.BlockShape.BUILDABLE) {
            return new BuildableBlock(x, y, blockData, tint);
        } else
            return new Block(x, y, blockData, tint);
    }
}

