package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.BlockFactory;

import java.util.Random;

import static com.mygdx.game.BlockShape.LOCKED;

public class MapManager {
    public static MapManager instance;
    GameMap gameMap;

    MapManager(float width, float height) {
        gameMap = new GameMap(width, height);

        Block block = BlockFactory.createBlock(gameMap.map.length / 2, 0,
                RegionAtlas.instance.get(2 + new Random().nextInt(RegionAtlas.instance.size() - 2)), Color.SKY);
        gameMap.changeBlock(block);
        updateBuildingGrid(block);

        instance = this;
    }

    public void placeBlock(int x, int y) {
        if (inRange(x, y)) {
            Block block = BlockPicker.CreateFittingBlock(x, y, this);
            gameMap.changeBlock(block);
            updateBuildingGrid(block);
        }
    }

    boolean inRange(int x, int y) {
        if (x >= 0 && x < gameMap.map.length)
            if (y >= 0 && y < gameMap.map[0].length)
                return true;
        return false;
    }

    BlockShape getBlockShape(int x, int y) {
        return gameMap.map[x][y].getBlockData().shape;
    }

    private void updateBuildingGrid(Block block) {
        int x, y;
        for (Direction direction : Direction.values()) {
            x = block.x + direction.deltaX;
            y = block.y + direction.deltaY;
            if (inRange(x, y) && block.getBlockData().shape.canBuild(direction))
                markAsBuildable(x, y);
        }
    }

    private void markAsBuildable(int x, int y) {
        if (getBlockShape(x, y) == LOCKED)
            gameMap.changeBlock(com.mygdx.game.actors.BlockFactory.createBuildableBlock(x, y));
    }
}