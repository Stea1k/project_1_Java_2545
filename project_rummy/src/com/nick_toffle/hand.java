package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by waffle on 2/21/15.
 *This class contains the player-specific methods and hand-related methods.
 */

public class hand {
    private String player;
    private LinkedList<card> hand_cards;
    private ArrayList<meld> meld_stack;

    public hand(String name){
        setHand(name);
        setHand_cards();
        setMeld_stack();
    }

    public void setHand(String name){
        this.player = name;
    }

    public String getplayer(){
        return this.player;
    }

    public void setHand_cards(){
        this.hand_cards = new LinkedList<card>();
    }

    public LinkedList<card> getCards() {return this.hand_cards;}

    public void setMeld_stack(){
        this.meld_stack = new ArrayList<meld>();
    }
    public ArrayList<meld> getMeld_stack(){
        return this.meld_stack;
    }

    public void seeHand(){
        for(int x = 0; x < this.getCards().size(); x ++){
            card view = this.getCards().get(x);
            System.out.print(view.getCardValue() + " | " + view.getCardSuit());
            }
        System.out.println();
    }
}
