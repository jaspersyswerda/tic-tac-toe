package com.jasper;

public class Player {

    private boolean isHumanPlayer;
    private String mark;

    public Player(boolean isHumanPlayer, String mark){
        this.isHumanPlayer = isHumanPlayer;
        this.mark = mark;
    }

    public boolean isHumanPlayer() {
        return isHumanPlayer;
    }

    public String getMark() {
        return mark;
    }


}
