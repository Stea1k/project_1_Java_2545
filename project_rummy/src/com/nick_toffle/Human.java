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

    public void humanDraw(Deck d,Discard dis){
        //prompts human player to draw from either the deck or the discards
    }
    public void humanMeld(Deck d){
        //1 dummy meld stack for all
        //4 array lists for runs
        //1 array list for sets
        //check each possible meld
    }
    public void humanCardToMeld(){
        //add a card from the hand to a chosen meld
    }
    public void humanDiscard(Discard d){
        //discard a card from the human player's hand.
    }
}