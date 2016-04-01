package com.mygdx.game.blocks;

import java.util.ArrayList;

public class BlockShape {
    String name;
    boolean[] canBuild = new boolean[4];
    public static ArrayList<BlockShape> values = new ArrayList<BlockShape>();
    public static BlockShape LOCKED = new BlockShape("dot", new boolean[]{false, false, false, false}),
            BUILDABLE = new BlockShape("dothollow", new boolean[]{false, false, false, false}),
            RANDOM = new BlockShape("random", new boolean[]{true, true, true, true}),
            ROUND = new BlockShape("round", new boolean[]{true, true, true, true}),
            SQUARE = new BlockShape("square", new boolean[]{true, true, true, true}),
            TRIANGLE = new BlockShape("triangle", new boolean[]{true, false, true, false}),
            T_SHAPED = new BlockShape("t-shaped", new boolean[]{false, true, true, true}),
            HORIZONTAL = new BlockShape("horizontal", new boolean[]{false, true, false, true}),
            VERTICAL = new BlockShape("vertical", new boolean[]{true, false, true, false});

    BlockShape(String name, boolean[] canBuild) {
        this.name = name;
        this.canBuild = canBuild;
        values.add(this);
    }

    public String getName() {
        return name;
    }

    public boolean canBuildUp() {
        return canBuild[0];
    }

    public boolean canBuildRight() {
        return canBuild[1];
    }

    public boolean canBuildDown() {
        return canBuild[2];
    }

    public boolean canBuildLeft() {
        return canBuild[3];
    }
}
