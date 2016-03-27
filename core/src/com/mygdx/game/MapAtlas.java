package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;
import java.util.TreeMap;

import static com.badlogic.gdx.graphics.g2d.TextureAtlas.*;

public class MapAtlas extends TreeMap<Integer, AtlasRegion> {
    static MapAtlas instance = new MapAtlas();
    static String[] blockTypeNames = {"random", "round", "square", "triangle"};
    static int variability = 5;

    static void createMapAlas(TextureAtlas atlasRegion) {
        // locked space
        instance.put(instance.size(), atlasRegion.findRegion("dot"));
        // placement area
        instance.put(instance.size(), atlasRegion.findRegion("dothollow"));

        Random random = new Random();
        for (int blockType = 0; blockType < blockTypeNames.length; blockType++) {
            Color randomColor = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1);
            for (int altType = 1; altType <= variability; altType++) {
                instance.put(instance.size(), atlasRegion.findRegion(blockTypeNames[blockType] + altType));
            }
        }
    }

}
