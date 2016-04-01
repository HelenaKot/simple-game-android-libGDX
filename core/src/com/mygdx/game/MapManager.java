package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.blocks.*;

import static com.mygdx.game.blocks.BlockShape.*;

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
            blockPlacedUpdateBuildingGrid(block);
        }
    }

    private void blockPlacedUpdateBuildingGrid(Block block) {
        int x = block.x;
        int y = block.y;
        if (inRange(x - 1, y) && block.getBlockData().shape.canBuildLeft())
            markAsBuldable(x - 1, y);
        if (inRange(x + 1, y) && block.getBlockData().shape.canBuildRight())
            markAsBuldable(x + 1, y);
        if (inRange(x, y - 1) && block.getBlockData().shape.canBuildDown())
            markAsBuldable(x, y - 1);
        if (inRange(x, y + 1) && block.getBlockData().shape.canBuildUp())
            markAsBuldable(x, y + 1);
    }

    private boolean inRange(int x, int y) {
        if (x >= 0 && x < gameMap.map.length)
            if (y >= 0 && y < gameMap.map[0].length)
                return true;
        return false;
    }

    private void markAsBuldable(int x, int y) {
        if (gameMap.getBlockData(x, y).shape == LOCKED)
            gameMap.changeBlock(BlockFactory.createBuildableBlock(x, y));
    }
}
