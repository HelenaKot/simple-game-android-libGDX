package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Block extends Actor {
    private BlockData blockData;
    private Color tint;

    Block(BlockData blockData, Color tint) {
        this.blockData = blockData;
        this.tint = tint;
        setBounds(getX(), getY(), blockData.atlasRegion.getRegionWidth(), blockData.atlasRegion.getRegionHeight());

        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setVisible(false);
                return true;
            }
        });
    }

    public void setBlockData(BlockData blockData, Color tint) {
        this.blockData = blockData;
        this.tint = tint;
    }

    public void draw(Batch batch, float alpha) {
        batch.setColor(tint);
        batch.draw(blockData.atlasRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
                getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
