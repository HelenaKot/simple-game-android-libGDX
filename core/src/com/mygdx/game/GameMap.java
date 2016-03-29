package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

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
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                BlockData blockData = RegionAtlas.instance.get(random.nextInt(RegionAtlas.instance.size()));
                map[i][j] = new Block(blockData, new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1));
                map[i][j].setPosition(i * blockSize, j * blockSize);
            }
        }
    }
}
