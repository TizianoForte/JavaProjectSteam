package com.example.JavaGameLibrary.enums;

public enum Genre {
    FANTASY(0), FPS(1), TPS(2), MMORPG(3), STRATEGY(4), PUZZLE(5), ARCADE(6), SIDESCROLLER(7), TOPDOWN(8), HORROR(9), HENTAI(10);
    private final int code;

    Genre(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
