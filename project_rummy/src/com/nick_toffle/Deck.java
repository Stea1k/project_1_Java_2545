package com.nick_toffle;

import java.util.LinkedList;

class Deck{
    private LinkedList<String[]> deck;
    public String[] value = {
            "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"
    };
    public String[] suit = {
            "Heart","Diamond","CLub","Spade"
    };

    public Deck(){
        this.deck = new LinkedList<String[]>();
    }

    public void mkdeck(){
        if(this.deck.size() == 0){
            for(int x = 0; x < 4; x ++){
                for(int y = 0; y < 13; y ++){
                    String[] newCard = {value[y],suit[x]};
                    this.deck.add(newCard);
                }
            }
        }
    }
}

