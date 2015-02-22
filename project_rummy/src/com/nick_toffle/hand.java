package com.nick_toffle;

import java.util.LinkedList;

/**
 * Created by waffle on 2/21/15.
 */
public class hand {
    private String player;
    private LinkedList<String[]> hand_cards;

    public hand(String name){
        setHand(name);
        this.hand_cards = new LinkedList<String[]>();
    }

    public void setHand(String name){
        this.player = name;
    }
    public String getHand(){
        return this.player;
    }
}
