package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.TreeMap;

public class RegionAtlas {
    static TreeMap<Integer, BlockData> instance;

    enum BlockShape {LOCKED, BUILDABLE, RANDOM, ROUND, SQUARE, TRIANGLE}

    static int variability = 5;

    RegionAtlas(TextureAtlas atlasRegion) {
        instance = new TreeMap<Integer, BlockData>();

        new BlockData(atlasRegion.findRegion(getName(BlockShape.LOCKED)), instance.size(), BlockShape.LOCKED);
        new BlockData(atlasRegion.findRegion(getName(BlockShape.BUILDABLE)), instance.size(), BlockShape.BUILDABLE);

        for (BlockShape shape : BlockShape.values()) {
            if (shape == BlockShape.LOCKED || shape == BlockShape.BUILDABLE) continue;
            for (int altType = 1; altType <= variability; altType++) {
                String regionName = getName(shape) + altType;
                if (new BlockData(atlasRegion.findRegion(regionName), instance.size(), shape).atlasRegion == null)
                    System.out.println(regionName + " is an Incorrect regionName");
            }
        }
        System.out.println("RegioAtlas - contains " + instance.size() + " blocks");
    }

    private static String getName(BlockShape blockShape) {
        switch (blockShape) {
            case LOCKED:
                return "dot";
            case BUILDABLE:
                return "dothollow";
            case RANDOM:
                return "random";
            case ROUND:
                return "round";
            case SQUARE:
                return "square";
            case TRIANGLE:
                return "triangle";
        }
        return null;
    }
}
