package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by waffle on 2/21/15.
 *This class contains the player-specific methods and hand-related methods.
 */

public class hand {
    //the hand class is built from a player name, a linked list (to be changed to a HashMap) of cards,
    //and a list of melds.
    private String player;
    private LinkedList<card> hand_cards;
    private ArrayList<meld> meld_stack;

    //hand constructor.
    public hand(String name){
        setHand(name);
        setHand_cards();
        setMeld_stack();
    }

    //sets the player's name.
    public void setHand(String name){
        this.player = name;
    }

    //returns a player's name
    public String getplayer(){
        return this.player;
    }

    //sets a hand of cards (to be altered)
    public void setHand_cards(){
        this.hand_cards = new LinkedList<card>();
    }

    //returns the player's hand of cards.
    public LinkedList<card> getCards() {return this.hand_cards;}

    //sets the meld stack.
    public void setMeld_stack(){
        this.meld_stack = new ArrayList<meld>();
    }

    //returns a player's meld stack
    public ArrayList<meld> getMeld_stack(){
        return this.meld_stack;
    }

    //shows the contents of a player's hand.
    public void seeHand(){
        for(int x = 0; x < this.getCards().size(); x ++){
            card view = this.getCards().get(x);
            System.out.print(view.getCardValue() + " | " + view.getCardSuit());
            }
        System.out.println();
    }
}
