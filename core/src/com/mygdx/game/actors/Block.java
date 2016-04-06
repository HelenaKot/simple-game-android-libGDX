package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.BlockData;
import com.mygdx.game.Constant;

public class Block extends Actor {
    public int x, y;
    BlockData blockData;
    Color tint;

    Block(int x, int y, BlockData blockData, Color tint) {
        this.x = x;
        this.y = y;
        this.blockData = blockData;
        this.tint = tint;
        setBounds(getX(), getY(), Constant.BLOCK_SIZE, Constant.BLOCK_SIZE);
    }

    public void draw(Batch batch, float alpha) {
        batch.setColor(tint);
        batch.draw(blockData.atlasRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
                getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public BlockData getBlockData() {
        return blockData;
    }
}
