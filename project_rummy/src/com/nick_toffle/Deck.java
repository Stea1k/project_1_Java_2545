package com.nick_toffle;

import java.util.LinkedList;
import java.util.Random;

class Deck{
    private LinkedList<card> deck;
    private String game;

    public Deck(String start){
        this.deck = new LinkedList<card>();
        this.setdeck();
        this.game = start;
    }

    public void setGame(String name){
        this.game = name;
    }

    public LinkedList<card> getdeck(){
        return this.deck;
    }

    public String getGame() {
        return this.game;
    }

    public String[] value = {
            "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"
    };

    public String[] suit = {
            "Heart","Diamond","Club","Spade"
    };

    public Integer getValue(String s){
        int v = 0;
        for(int x = 0; x < value.length; x ++){
            if(s.equals(value[x])){
                v += x;
            }
        }
        return v;
    }

    public void setdeck(){
        for(int x = 0; x < 4; x ++){
            for(int y = 0; y < 13; y ++){
                card newCard = new card(value[y],suit[x]);
                this.deck.add(newCard);
            }
        }
    }

    public card draw(){
        Random r = new Random();
        int another = r.nextInt(this.deck.size());
        card new_card = this.deck.get(another);
        this.deck.remove(another);
        return new_card;
    }
}

