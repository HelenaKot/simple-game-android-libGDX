package com.mygdx.game;

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

    public boolean canBuild(Direction direction) {
        return canBuild[direction.ordinal()];
    }

    public boolean canConnect(BlockShape shape, Direction direction) {
        System.out.println("connecting " + direction + "with " + direction.flip());
        return this.canBuild(direction.flip()) && shape.canBuild(direction);
    }
}
