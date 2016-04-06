package com.mygdx.game;

import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.BlockFactory;

public class GameMap {
    int widthPadding, heightOffset;
    Block[][] map;

    GameMap(int width, int height, int heightOffset) {
        this.heightOffset = heightOffset;
        widthPadding = Constant.MAP_PADDING;
        if (map == null)
            initEmptyMap(width, height);
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
        map[block.x][block.y].setPosition(block.x * Constant.BLOCK_SIZE + widthPadding, (block.y + heightOffset) * Constant.BLOCK_SIZE);
        MyGdxGame.addToStage(block);
    }
}
