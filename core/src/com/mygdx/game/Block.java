package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.Iterator;

public class Block extends Actor {
    private static float actorX = 0, actorY = 0;
    private Sprite sprite; //TODO dispose this

    //TODO actor = instance not block
    Block(TextureAtlas.AtlasRegion region, Color tint) {
        sprite = new Sprite(region);
        sprite.setColor(tint);
        setBounds(actorX, actorY, sprite.getWidth(), sprite.getHeight());
        /*
        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //TODO
                return true;
            }
        });
        */
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.setColor(sprite.getColor()); // todo separate colors from sprites
        batch.draw(sprite, actorX, actorY, this.getOriginX(), this.getOriginY(), this.getWidth(),
                this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
    }

    @Override
    public void act(float delta){
        for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
            iter.next().act(delta);
        }
    }

    /* returns if component is HIT, default:
    public Actor hit (float x, float y, boolean touchable) {
        if (touchable && getTouchable() != Touchable.enabled) return null;
        return x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight() ? this : null;
    } */
}
