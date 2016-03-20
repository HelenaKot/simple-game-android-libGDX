package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.TreeMap;

public class Block {
    static public TreeMap<Integer, Block> mapAtlas = MapAtlas.instance;
    private static float scale = 10;
    private Sprite sprite; //TODO dispose this

    Block(TextureAtlas.AtlasRegion region, Color tint) {
        sprite = new Sprite(region);
        sprite.setColor(tint);
        sprite.scale(scale);
        mapAtlas.put(mapAtlas.size(), this);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public static Sprite getSpriteAt(int id, int x, int y) {
        Sprite tmp = mapAtlas.get(id).getSprite();
        tmp.setPosition(x, y);
        return tmp;
    }
}
