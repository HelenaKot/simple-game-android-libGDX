package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.BlockData;
import com.mygdx.game.Constant;
import com.mygdx.game.MapManager;
import com.mygdx.game.Score;

public class BuildableBlock extends Block {

    BuildableBlock(final int blockX, final int blockY, BlockData blockData, Color tint) {
        super(blockX, blockY, blockData, tint);
        maintainTopBlock(y);
        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                MapManager.instance.placeBlock(blockX, blockY);
                GameScoreManager.instance.addScorePoints(Score.ADDED_PLAIN_BLOCK);
                return true;
            }
        });
    }

    private void maintainTopBlock(int y) {
        if (y > TOP_BLOCK)
            TOP_BLOCK = y + Constant.FAIL_COMPENSATION_BLOCKS;

    }
}
