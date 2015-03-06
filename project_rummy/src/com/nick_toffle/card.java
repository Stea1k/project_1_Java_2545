package com.nick_toffle;

/**
 * Created by waffle on 2/21/15.
 */

class card{
    private String Cvalue;
    private String Csuit;

    public String getCardValue() {
        return Cvalue;
    }

    public String getCardSuit() {
        return Csuit;
    }

    public void setCardValue(String value) {
        this.Cvalue = value;
    }

    public void setCardSuit(String suit) {
        this.Csuit = suit;
    }

    public card(String v,String s){
        this.Cvalue = v;
        this.Csuit = s;
    }
}
