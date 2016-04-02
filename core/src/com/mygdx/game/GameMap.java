package com.mygdx.game;

import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.BlockFactory;

public class GameMap {
    Block[][] map;

    GameMap(float width, float height) {
        if (map == null)
            initEmptyMap((int) width / RegionAtlas.blockSize, (int) height / RegionAtlas.blockSize);
    }

    private void initEmptyMap(int width, int height) {
        map = new Block[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                initBlock(BlockFactory.createEmptyBlock(x, y));
            }
        }
    }

    void changeBlock(Block block) {
        map[block.x][block.y].remove();
        initBlock(block);
    }

    private void initBlock(Block block) {
        map[block.x][block.y] = block;
        map[block.x][block.y].setPosition(block.x * RegionAtlas.blockSize, block.y * RegionAtlas.blockSize);
        MyGdxGame.addToStage(block);
    }
}
