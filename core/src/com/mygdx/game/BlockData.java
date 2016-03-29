package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import static com.mygdx.game.RegionAtlas.BlockShape;

public class BlockData {
    public AtlasRegion atlasRegion;
    public BlockShape shape;
    public int id;

    BlockData(AtlasRegion atlasRegion, int id, BlockShape shape) {
        this.atlasRegion = atlasRegion;
        this.id = id;
        this.shape = shape;
    }
}
