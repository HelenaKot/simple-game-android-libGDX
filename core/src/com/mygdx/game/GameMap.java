package com.mygdx.game;

import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.BlockFactory;

public class GameMap {
    int heightOffset;
    Block[][] map;

    GameMap(float width, float height, int heightOffset) {
        this.heightOffset = heightOffset;
        if (map == null)
            initEmptyMap((int) width / Constant.BLOCK_SIZE, (int) height / Constant.BLOCK_SIZE);
    }

    private void initEmptyMap(int width, int height) {
        map = new Block[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                initBlock(BlockFactory.createEmptyBlock(x, y));
            }
        }
        System.out.println("Map initet");
    }

    void changeBlock(Block block) {
        map[block.x][block.y].remove();
        initBlock(block);
    }

    private void initBlock(Block block) {
        map[block.x][block.y] = block;
        map[block.x][block.y].setPosition(block.x * Constant.BLOCK_SIZE, (block.y + heightOffset) * Constant.BLOCK_SIZE);
        MyGdxGame.addToStage(block);
    }
}
