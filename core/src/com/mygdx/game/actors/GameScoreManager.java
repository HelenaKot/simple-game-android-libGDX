package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Score;

public class GameScoreManager extends Actor {
    public static GameScoreManager instance;
    static int score = Score.START.value;
    int speed = 0;
    int height = 0; //todo death/fail detection
    OrthographicCamera camera;

    private static int SPEED_STEP = 1;
    private static int MAX_SPEED = 4;

    public GameScoreManager(OrthographicCamera camera) {
        this.camera = camera;
        instance = this;
        MyGdxGame.addToStage(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        camera.translate(0, speed);
    }

    public void addScorePoints(Score points) {
        score += points.value;
        if (score % Score.SPEED_STEP.value == 0 && speed <= MAX_SPEED)
            speed += SPEED_STEP;
    }
}
