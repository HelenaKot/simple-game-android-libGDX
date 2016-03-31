package com.mygdx.game.blocks;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.BlockData;
import com.mygdx.game.MapManager;
import com.mygdx.game.RegionAtlas;

import java.util.Random;

public class BuildableBlock extends Block {

    BuildableBlock(final int blockX, final int blockY, BlockData blockData, Color tint) {
        super(blockX, blockY, blockData, tint);
        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                MapManager.instance.placeBlock(generateNextBlock(blockX,blockY));
                return true;
            }
        });
    }

    Random random = new Random();
    private Block generateNextBlock(int x, int y) {
        return BlockFactory.createBlock(x, y, RegionAtlas.instance.get(2+random.nextInt(RegionAtlas.instance.size()-2))
                , new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1));
    }
}
