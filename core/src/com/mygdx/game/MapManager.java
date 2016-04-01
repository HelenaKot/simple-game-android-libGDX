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
                RegionAtlas.instance.get(2 + random.nextInt(RegionAtlas.instance.size() - 2)), specificColor);
        gameMap.changeBlock(block);
        blockPlacedUpdateBuildingGrid(block);

        instance = this;
    }

    public void placeBlock(int x, int y) {
        if (inRange(x, y)) {
            Block block = CreateFittingBlock(x, y);
            gameMap.changeBlock(block);
            blockPlacedUpdateBuildingGrid(block);
        }
    }

    //TODO here place future plans of color mechanics
    //TODO + tmp location?
    Random random = new Random();
    Color specificColor = Color.SKY;

    private Block CreateFittingBlock(int x, int y) {
        BlockData blockData = RegionAtlas.instance.get(2 + random.nextInt(RegionAtlas.instance.size() - 3));
        while (!blockFits(x,y, blockData.shape)) {
            blockData = RegionAtlas.instance.get(2 + random.nextInt(RegionAtlas.instance.size() - 3));
        }
        return BlockFactory.createBlock(x, y, blockData, specificColor);
        //new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1)
    }

    private boolean blockFits(int x, int y, BlockShape shape) {
        System.out.println("considered shape is "+shape.name);
        if (inRange(x - 1, y) && shape.canBuildLeft() && gameMap.map[x-1][y].getBlockData().id > 2)
            return true;
        if (inRange(x + 1, y) && shape.canBuildRight() && gameMap.map[x+1][y].getBlockData().id > 2)
            return true;
        if (inRange(x, y + 1) && shape.canBuildUp() && gameMap.map[x][y+1].getBlockData().id > 2)
            return true;
        if (inRange(x, y-1) && shape.canBuildDown() && gameMap.map[x][y-1].getBlockData().id > 2)
            return true;
        return false;
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
            gameMap.changeBlock(com.mygdx.game.actors.BlockFactory.createBuildableBlock(x, y));
    }
}
