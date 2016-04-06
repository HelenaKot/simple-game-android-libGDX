package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.actors.GameScoreManager;

public class MyGdxGame extends ApplicationAdapter {
    private TextureAtlas textureAtlas;
    private static Stage stage;

    @Override
    public void create() {
        textureAtlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));

        stage = new Stage();
        setUpGame();

        Gdx.input.setInputProcessor(stage);
    }

    private void setUpGame() {
        new RegionAtlas(textureAtlas);
        Constant.setUpBlockConstants((int) stage.getWidth(), RegionAtlas.getTextureSize());
        MapManager mapManager = new MapManager(stage.getWidth());
        GameScoreManager gameScoreManager = new GameScoreManager((OrthographicCamera) stage.getCamera());
    }

    public static void addToStage(Actor actor) {
        stage.addActor(actor);
    }
    public static void die() {
        //todo
    }

    @Override
    public void resize(int width, int height) {
        // See below for what true means.
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.72f, 0.7f, 1);
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
