package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Block extends Actor {
    private TextureRegion texture;
    private Color tint;

    //TODO actor = instance not block
    Block(TextureAtlas.AtlasRegion region, Color tint) {
        texture = region;
        this.tint = tint;
        setBounds(getX(), getY(), texture.getRegionWidth(), texture.getRegionHeight());

        addListener(new InputListener() {
            public boolean touchDown (com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Touched");
                setVisible(false);
                return true;
            }
        });
    }

    public void draw(Batch batch, float alpha) {
        batch.setColor(tint); // todo separate colors from sprites
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(),
                getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
