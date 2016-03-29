package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import static com.mygdx.game.RegionAtlas.BlockShape;
import static com.mygdx.game.RegionAtlas.instance;

public class BlockData {
    AtlasRegion atlasRegion;
    BlockShape shape;
    int id;

    BlockData(AtlasRegion atlasRegion, int id, BlockShape shape) {
        this.atlasRegion = atlasRegion;
        this.id = id;
        this.shape = shape;
        putToAtlas();
    }

    private void putToAtlas() {
        instance.put(id, this);
    }
}
