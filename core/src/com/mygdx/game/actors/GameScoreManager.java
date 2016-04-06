package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Constant;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Score;

public class GameScoreManager extends Actor {
    public static GameScoreManager instance;
    static int score = Score.START.value;
    private int speed = 0;
    private int initCameraPosition; //todo death/fail detection
    OrthographicCamera camera;

    private static int SPEED_STEP = 1;
    private static int MAX_SPEED = 3;

    public GameScoreManager(OrthographicCamera camera) {
        this.camera = camera;
        instance = this;
        MyGdxGame.addToStage(this);
        initCameraPosition = (int) camera.position.y / Constant.BLOCK_SIZE;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        camera.translate(0, speed);
        if (dead())
            MyGdxGame.die();
    }

    public void addScorePoints(Score points) {
        score += points.value;
        if (score % Score.SPEED_STEP.value == 0 && speed <= MAX_SPEED)
            speed += SPEED_STEP;
    }

    public void reset() {
        score = Score.START.value;
        speed = 0;
        Block.TOP_BLOCK = 0;
    }

    private boolean dead() {
        if (camera.position.y / Constant.BLOCK_SIZE > Block.TOP_BLOCK + initCameraPosition)
            return true;
        return false;
    }

}
