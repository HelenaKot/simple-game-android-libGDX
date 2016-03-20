package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        MapAtlas.createMapAlas(new TextureAtlas(Gdx.files.internal("pack.atlas")));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.72f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        Block.getSpriteAt(0,100,100).draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
