package com.nick_toffle;

import java.util.LinkedList;
import java.util.Random;

/*Created by Nick Toffle and Casey Holmgren on 2/21/15.
* This is the deck class. many of the more basic methods for creating, storing, and managing a deck are in here.
* */

class Deck{
    // Deck class is composed of a linked list of cards and a name suing a string.
    private LinkedList<Card> deck;
    private String game;

    //deck constructor
    public Deck(String start){
        this.deck = new LinkedList<Card>();
        this.setNewdeck();
        this.game = start;
    }

    //sets the name of a given game.
    public void setGame(String name){
        this.game = name;
    }

    //returns the deck list of the given deck
    public LinkedList<Card> getdeck(){
        return this.deck;
    }

    //sets the given deck list to another deck list.
    public void setDeck(LinkedList<Card> d){
        this.deck = d;
    }

    //returns the name of the given game.
    public String getGame() {
        return this.game;
    }

    //string array for a list of card values.
    public String[] value = {
            "2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"
    };

    //string array for a list of vard suits.
    public String[] suit = {
            "Heart","Diamond","Club","Spade"
    };

    //returns the numerical value of a card's value based on it's position in the value list.
    public Integer getValue(String s){
        int v = 0;
        for(int x = 0; x < value.length; x ++){
            if(s.equals(value[x])){
                v = x;
            }
        }
        return v;
    }

    //sets the deck as a fresh card set.
    public void setNewdeck(){
        for(int x = 0; x < 4; x ++){
            for(int y = 0; y < 13; y ++){
                Card newCard = new Card(value[y],suit[x]);
                this.deck.add(newCard);
            }
        }
    }

    //draws a card from the given deck and removes it from the deck list.
    public Card draw(){
        Random r = new Random();
        int another = r.nextInt(this.deck.size());
        Card new_card = this.deck.get(another);
        this.deck.remove(another);
        return new_card;
    }
    //check if two cards are within 1 unit of value of each other.
    public Boolean checkCard(Card c, Card a){
    	int v1 = getValue(c.getCardValue());
    	int v2 = getValue(a.getCardValue());
    	if(v1 == (v2-1) || v1 == (v2+1)){
    		return true;
    	}else return false;
    }
}

