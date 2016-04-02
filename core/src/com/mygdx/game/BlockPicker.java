package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.BlockFactory;

import java.util.Random;

public class BlockPicker {

    //TODO here place future plans of color mechanics
    static Random random = new Random();
    static Color specificColor = Color.SKY;

    static public Block CreateFittingBlock(int x, int y, MapManager mapManager) {
        BlockData blockData = RegionAtlas.instance.get(2 + random.nextInt(RegionAtlas.instance.size() - 3));
        while (!blockFits(x, y, blockData.shape, mapManager)) {
            blockData = RegionAtlas.instance.get(2 + random.nextInt(RegionAtlas.instance.size() - 3));
        }
        return BlockFactory.createBlock(x, y, blockData, specificColor);
        //new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1)
    }

    static private boolean blockFits(int x, int y, BlockShape shape, MapManager mapManager) {
        System.out.println("considered shape is " + shape.name);
        for (Direction direction : Direction.values()) {
            if (mapManager.inRange(x + direction.deltaX, y + direction.deltaY)
                    && mapManager.getBlockShape(x + direction.deltaX, y + direction.deltaY).canConnect(shape, direction)) {
                return true;
            }
        }
        return false;
    }
}