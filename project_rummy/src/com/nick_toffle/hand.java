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
        setHand_cards();
    }

    public void setHand(String name){
        this.player = name;
    }

    public String getplayer(){
        return this.player;
    }

    public void setHand_cards(){
        this.hand_cards = new LinkedList<String[]>();
    }

    public LinkedList<String[]> getCards() {return this.hand_cards;}

    public void seeHand(){
        for(int x = 0; x < this.getCards().size(); x ++){
            String[] view = this.getCards().get(x);
            for(int v = 0; v < view.length; v ++){
                System.out.print("| " + view[v] + " |");
                if(v%2 != 0){
                    System.out.println();
                }
            }
        }
    }
}
