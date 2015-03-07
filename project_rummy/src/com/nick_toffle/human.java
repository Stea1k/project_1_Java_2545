package com.nick_toffle;

/**
 * Created by waffle on 3/7/15.
 */
public class human extends Player{

    //hand constructor.
    public human(String name) {
        setHand(name);
        setHand_cards();
        setMeld_stack();
    }

}