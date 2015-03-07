package com.nick_toffle;

/**
 * Created by waffle on 3/7/15.
 */
public class Ai extends Player{


    public Ai() {
        setHand("AI");
        setHand_cards();
        setMeld_stack();
    }

    public static void cpuTurn(){
        //TODO
        //draw from deck
        //meld checker(runs or sets)
        //play meld or set (if hand hand size after draw is 3 or more)
        //check melds
    }
    public static void cpuMeld(Deck d){
        //1 dummy meld stack for all
        //4 array lists for runs
        //1 array list for sets
        //check each possible meld
        //add the first valid meld to the real meld stack.
    }
    public static void cpuCardToMeld(){
        //adds a card in hand to a meld already existing in the meld stack.
    }
    public static void cpuDiscard(Discard d){
        //randomly discards a card from the computer's hand.
    }
}

