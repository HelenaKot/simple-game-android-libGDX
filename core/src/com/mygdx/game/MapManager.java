package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.blocks.Block;
import com.mygdx.game.blocks.BlockFactory;

public class MapManager {
    public static MapManager instance;
    GameMap gameMap;

    MapManager(float width, float height) {
        gameMap = new GameMap(width, height);
        placeBlock(BlockFactory.createBlock(gameMap.map.length / 2, 0, RegionAtlas.instance.get(6), Color.CHARTREUSE));
        instance = this;
    }

    public void placeBlock(Block block) {
        if (inRange(block.x, block.y)) {
            gameMap.changeBlock(block);
            blockPlacedUpdateBuildingGrid(block.x, block.y);
        }
    }

    private void blockPlacedUpdateBuildingGrid(int x, int y) {
        if (inRange(x - 1, y))
            markAsBuldable(x - 1, y);
        if (inRange(x + 1, y))
            markAsBuldable(x + 1, y);
        if (inRange(x, y - 1))
            markAsBuldable(x, y - 1);
        if (inRange(x, y + 1))
            markAsBuldable(x, y + 1);
    }

    private boolean inRange(int x, int y) {
        if (x >= 0 && x < gameMap.map.length)
            if (y >= 0 && y < gameMap.map[0].length)
                return true;
        return false;
    }

    private void markAsBuldable(int x, int y) {
        if (gameMap.getBlockData(x, y).shape == RegionAtlas.BlockShape.LOCKED)
            gameMap.changeBlock(BlockFactory.createBuildableBlock(x, y));
    }
}
