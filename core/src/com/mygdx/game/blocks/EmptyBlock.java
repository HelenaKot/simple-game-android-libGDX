package com.mygdx.game.blocks;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.BlockData;
import com.mygdx.game.GameMap;

public class EmptyBlock extends Block {

    EmptyBlock(BlockData blockData, Color tint) {
        super(blockData, tint);
        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setVisible(false);
                return true;
            }
        });
    }
}
