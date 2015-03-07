package com.nick_toffle;

/**
 * Created by waffle on 3/7/15.
 */
public class Human extends Player{

    //hand constructor.
    public Human(String name) {
        setHand(name);
        setHand_cards();
        setMeld_stack();
    }

}