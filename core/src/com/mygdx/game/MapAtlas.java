package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;
import java.util.TreeMap;

public class MapAtlas extends TreeMap<Integer, Block> {
    static MapAtlas instance = new MapAtlas();
    static String[] blockTypeNames = {"random", "round", "square", "triangle"};
    static int variability = 5;

    static void createMapAlas(TextureAtlas textureAtlas) {
        // locked space
        new Block(textureAtlas.findRegion("dot"), Color.WHITE);
        // placement area
        new Block(textureAtlas.findRegion("dothollow"), Color.WHITE);

        Random random = new Random();
        for (int blockType = 0; blockType < blockTypeNames.length; blockType++) {
            Color randomColor = new Color(random.nextFloat(),random.nextFloat(),random.nextFloat(),1);
            for (int altType = 1; altType <= variability; altType++) {
                new Block(textureAtlas.findRegion(blockTypeNames[blockType]+altType), randomColor);
            }
        }
    }
}
