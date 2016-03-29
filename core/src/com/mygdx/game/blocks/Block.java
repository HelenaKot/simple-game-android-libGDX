package com.mygdx.game.blocks;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.BlockData;
import com.mygdx.game.GameMap;

public class Block extends Actor {
    BlockData blockData;
    Color tint;

    Block(BlockData blockData, Color tint) {
        this.blockData = blockData;
        this.tint = tint;
        setBounds(getX(), getY(), GameMap.blockSize, GameMap.blockSize);
    }

    public void draw(Batch batch, float alpha) {
        batch.setColor(tint);
        batch.draw(blockData.atlasRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
                getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
