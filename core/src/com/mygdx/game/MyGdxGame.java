package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class MyGdxGame extends ApplicationAdapter {
    private TextureAtlas textureAtlas;
    private Stage stage;

    @Override
    public void create() {
        Gdx.gl.glClearColor(0.3f, 0.72f, 0.7f, 1);
        textureAtlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));
        stage = new Stage(new ExtendViewport(64, 128));

        setUpGame();

        Gdx.input.setInputProcessor(stage);
    }

    private void setUpGame() {
        new RegionAtlas(textureAtlas);
        int blockSize = RegionAtlas.instance.get(10).atlasRegion.getRegionWidth();

        spawnBlocks(new GameMap(stage.getWidth(), stage.getHeight(), blockSize));

    }

    private void spawnBlocks(GameMap gameMap) {
        for (com.mygdx.game.blocks.Block[] blockRow : gameMap.map) {
            for (com.mygdx.game.blocks.Block block : blockRow) {
                stage.addActor(block);
            }
        }
    }

    @Override
    public void resize(int width, int height) {
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
