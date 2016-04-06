package com.mygdx.game;

public enum Score {
    START(0),
    ADDED_PLAIN_BLOCK(1),
    SPEED_STEP(10);

    public final int value;

    Score(int value) {
        this.value = value;
    }
}