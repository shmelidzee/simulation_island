package com.company.basics;

public class Position {
    private static Position INSTANCE;
    private static int y = 10;
    private static int x = 10;

    private Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static Position getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Position(y, x);
        }
        return INSTANCE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
