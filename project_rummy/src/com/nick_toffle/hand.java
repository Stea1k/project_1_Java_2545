package com.nick_toffle;

import java.util.LinkedList;

/**
 * Created by waffle on 2/21/15.
 */
public class hand {
    private String player;
    private LinkedList<card> hand_cards;

    public hand(String name){
        setHand(name);
        setHand_cards();
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

//    public Integer getCardValue(String s){
//
//    }

    public void seeHand(){
        for(int x = 0; x < this.getCards().size(); x ++){
            card view = this.getCards().get(x);
            System.out.print(view.getValue() + " | " + view.getSuit());
            }
        System.out.println();
    }
}
