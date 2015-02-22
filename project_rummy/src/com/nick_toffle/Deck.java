package com.nick_toffle;

import java.util.LinkedList;
import java.util.Random;

class Deck{
    private LinkedList<String[]> deck;
    private String game;

    public Deck(String start){
        this.deck = new LinkedList<String[]>();
        this.setdeck();
        this.game = start;
    }

    public void setGame(String name){
        this.game = name;
    }

    public LinkedList<String[]> getdeck(){
        return this.deck;
    }

    public String getGame() {
        return this.game;
    }

    public String[] value = {
            "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"
    };
    public String[] suit = {
            "Heart","Diamond","CLub","Spade"
    };

    public void setdeck(){
        for(int x = 0; x < 4; x ++){
            for(int y = 0; y < 13; y ++){
                String[] newCard = {value[y],suit[x]};
                this.deck.add(newCard);
            }
        }
    }

    public String[] draw(){
        Random r = new Random();
        int another = r.nextInt(this.deck.size());
        String[] new_card = this.deck.get(another);
        this.deck.remove(another);
        return new_card;
    }
}

