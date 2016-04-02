package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.TreeMap;

import static com.mygdx.game.BlockShape.BUILDABLE;
import static com.mygdx.game.BlockShape.LOCKED;
import static com.mygdx.game.BlockShape.values;

public class RegionAtlas {
    public static TreeMap<Integer, BlockData> instance;
    public static int blockSize;
    static int variability = 5;

    RegionAtlas(TextureAtlas atlasRegion) {
        instance = new TreeMap<Integer, BlockData>();

        putToAtlas(new BlockData(atlasRegion.findRegion(LOCKED.getName()), instance.size(), LOCKED));
        putToAtlas(new BlockData(atlasRegion.findRegion(BUILDABLE.getName()), instance.size(), BUILDABLE));

        for (BlockShape shape : values) {
            if (shape == LOCKED || shape == BUILDABLE) continue;
            for (int altType = 1; altType <= variability; altType++) {
                String regionName = shape.getName() + altType;
                if (putToAtlas(new BlockData(atlasRegion.findRegion(regionName), instance.size(), shape)).atlasRegion == null)
                    System.out.println(regionName + " is an Incorrect regionName");
            }
        }

        blockSize = instance.get(10).atlasRegion.getRegionWidth();
        System.out.println("RegioAtlas - contains " + instance.size() + " blocks");
    }

    static private BlockData putToAtlas(BlockData blockData) {
        instance.put(blockData.id, blockData);
        return blockData;
    }
}
