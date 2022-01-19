package com.task.rockpaperscissors.dto;

public enum Choice {

    STONE("SCISSORS", "PAPER"),
    PAPER("STONE", "SCISSORS"),
    SCISSORS("PAPER", "STONE");

    public final String win;

    public final String lose;

    Choice(String win, String lose) {
        this.win = win;
        this.lose = lose;
    }
}
