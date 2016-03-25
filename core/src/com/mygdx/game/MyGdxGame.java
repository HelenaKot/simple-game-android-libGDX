package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener, InputProcessor {
    SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    TextureAtlas textureAtlas;
    private BitmapFont font;
    private String message = "";
    private int w,h;
    OrthographicCamera camera;

    /** przy inputach wazne jest zwracanie true/false -
     * true oznacza, ze inputy obsluzone i te tyou scale/fling moga nie przejsc */
    @Override
    public void create() {
        camera = new OrthographicCamera(1280, 720);
        texture = new Texture(Gdx.files.internal("placeholder.jpg"));
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        sprite = new Sprite(texture);
        sprite.setOrigin(0,0);
        sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);

        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));
        MapAtlas.createMapAlas(textureAtlas);
        font = new BitmapFont();
        font.setColor(Color.RED);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        InputMultiplexer im = new InputMultiplexer();
        GestureDetector gd = new GestureDetector(this);
        im.addProcessor(gd);
        im.addProcessor(this);
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.72f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        Block.getSpriteAt(0,100,100).draw(batch);
        float x = w/2;
        float y = h/2;
        font.draw(batch, message, x, y);
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
        textureAtlas.dispose();
        font.dispose();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        message = "Touch down!";
        Gdx.app.log("INFO", message);
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        message = "Tap performed, finger" + Integer.toString(button);
        Gdx.app.log("INFO", message);
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        message = "Long press performed";
        Gdx.app.log("INFO", message);
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        message = "Fling performed, velocity:" + Float.toString(velocityX) +
                "," + Float.toString(velocityY);
        Gdx.app.log("INFO", message);
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        message = "Pan performed, delta:" + Float.toString(deltaX) +
                "," + Float.toString(deltaY);
        Gdx.app.log("INFO", message);
        camera.translate(deltaX,0);
        camera.update();
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        message = "Zoom performed, initial Distance:" + Float.toString(initialDistance) +
                " Distance: " + Float.toString(distance);
        Gdx.app.log("INFO", message);
        return true;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        message = "Pinch performed";
        Gdx.app.log("INFO", message);
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        message = "Touch Down";
        Gdx.app.log("INFO", message);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        message = "Touch up";
        Gdx.app.log("INFO", message);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        message = "Touch Dragged";
        Gdx.app.log("INFO", message);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        message = "Scrolled";
        Gdx.app.log("INFO", message);
        return false;
    }
}
