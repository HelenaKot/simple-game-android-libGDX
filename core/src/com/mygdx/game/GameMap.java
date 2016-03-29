package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.blocks.Block;
import com.mygdx.game.blocks.BlockFactory;

public class GameMap {
    com.mygdx.game.blocks.Block[][] map;
    static public int blockSize;

    GameMap(float width, float height, int blockSize) {
        GameMap.blockSize = blockSize;
        if (map == null)
            initEmptyMap((int) width / blockSize, (int) height / blockSize);
    }

    private void initEmptyMap(int width, int height) {
        map = new com.mygdx.game.blocks.Block[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                initBlock(x, y, BlockFactory.createBlock());
            }
        }
        changeBlock(width/2, 0, BlockFactory.createBlock(RegionAtlas.instance.get(6), Color.CHARTREUSE));
    }

    void changeBlock(int x, int y, Block block) {
        map[x][y].remove();
        initBlock(x,y,block);
    }

    private void initBlock(int x, int y, Block block) {
        map[x][y] = block;
        map[x][y].setPosition(x * blockSize, y * blockSize);
    }
}
