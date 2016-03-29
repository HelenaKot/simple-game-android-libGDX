package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class GameMap {
    Block[][] map;
    static int blockSize;

    GameMap(float width, float height, int blockSize) {
        GameMap.blockSize = blockSize;
        if (map == null)
            createNewMap((int) width / blockSize, (int) height / blockSize);
    }

    private void createNewMap(int width, int height) {
        map = new Block[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                BlockData emptyBlock = RegionAtlas.instance.get(0);
                map[i][j] = new Block(emptyBlock, Color.WHITE);
                map[i][j].setPosition(i * blockSize, j * blockSize);
            }
        }
        map[width/2][0].setBlockData(RegionAtlas.instance.get(6), Color.CHARTREUSE);
    }
}
