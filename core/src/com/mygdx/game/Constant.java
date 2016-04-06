package com.mygdx.game;

public class Constant {
    public static int BLOCK_SIZE;

    // todo not really used now:
    private static int BLOCKS_IN_ROW;
    private static int BLOCK_TEXTURE_SIZE;
    private static int BLOCK_SCALE;

    public static void setUpBlockConstants(int gameWidth, int textureSize) {
        BLOCKS_IN_ROW = 8;
        BLOCK_TEXTURE_SIZE = textureSize;
        BLOCK_SCALE = (gameWidth / BLOCKS_IN_ROW) / BLOCK_TEXTURE_SIZE;
        BLOCK_SIZE = BLOCK_TEXTURE_SIZE * BLOCK_SCALE;
    }
}