package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.TreeMap;

import static com.mygdx.game.BlockShape.BUILDABLE;
import static com.mygdx.game.BlockShape.LOCKED;
import static com.mygdx.game.BlockShape.values;

public class RegionAtlas {
    public static TreeMap<Integer, BlockData> instance;
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
        System.out.println("RegionAtlas - contains " + instance.size() + " blocks");
    }

    static private BlockData putToAtlas(BlockData blockData) {
        instance.put(blockData.id, blockData);
        return blockData;
    }

    static public int getTextureSize() {
        if (instance == null) {
            System.out.println("RegionAtlas is not set up yet. Returned Texture Size is 0.");
            return 0;
        } else return instance.get(0).atlasRegion.getRegionWidth();
    }
}
