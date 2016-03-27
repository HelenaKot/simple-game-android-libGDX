package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
    TextureAtlas textureAtlas;
    private Stage stage;

    @Override
    public void create() {
        Gdx.gl.glClearColor(0.3f, 0.72f, 0.7f, 1);
        textureAtlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));
        MapAtlas.createMapAlas(textureAtlas);
        stage = new Stage(new ExtendViewport(64,128));
        Block sampleActor = new Block(MapAtlas.instance.get(1), Color.FOREST);
        sampleActor.setPosition(30,30);
        stage.addActor(sampleActor);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize (int width, int height) {
        // See below for what true means.
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        textureAtlas.dispose();
        stage.dispose();
    }
}
