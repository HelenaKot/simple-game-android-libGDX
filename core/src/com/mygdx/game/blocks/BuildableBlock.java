package com.mygdx.game.blocks;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.BlockData;
import com.mygdx.game.MapManager;
import com.mygdx.game.RegionAtlas;

public class BuildableBlock extends Block {

    BuildableBlock(final int x, final int y, BlockData blockData, Color tint) {
        super(x, y, blockData, tint);
        addListener(new InputListener() {
            private int blockX = x, blockY = y;
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                MapManager.instance.placeBlock(BlockFactory.createBlock(blockX, blockY, RegionAtlas.instance.get(17), Color.CORAL));
                return true;
            }
        });
    }
}
