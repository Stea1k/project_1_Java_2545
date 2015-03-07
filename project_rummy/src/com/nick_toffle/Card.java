package com.nick_toffle;

/**
 * Created by waffle on 2/21/15.
 * This class contains all card-specific methods.
 */

class Card{
    //the card class has the following traits:
    private String Cvalue;
    private String Csuit;

    //returns the string value of a card
    public String getCardValue() {
        return Cvalue;
    }

    //returns the string suit of a card
    public String getCardSuit() {
        return Csuit;
    }

    //sets the card value
    public void setCardValue(String value) {
        this.Cvalue = value;
    }

    //sets the card suit
    public void setCardSuit(String suit) {
        this.Csuit = suit;
    }

    //Card constructor.
    public Card(String v,String s){
        this.Cvalue = v;
        this.Csuit = s;
    }
}
