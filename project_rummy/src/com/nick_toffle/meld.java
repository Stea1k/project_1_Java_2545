package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by waffle on 3/1/15.
 */
public class meld {
    protected ArrayList<card> melds;
    //sets the meld object
    public void setMelds(){
        this.melds = new ArrayList<card>();
    }
    //returns a meld
    public ArrayList<card> getMeld(){
        return this.melds;
    }
    //adds a card to a possible meld
    public void buildMeld(card c){
        this.melds.add(c);
    }
    //gets a card from a meld
    public card getCard(int c){
        return this.melds.get(c);
    }
    //checks if the possible meld is a valid meld
    public Boolean checkRun(Deck d){
        int largest = d.getValue(getCard(0).getCardValue());
        int smallest = d.getValue(getCard(0).getCardValue());
        int counter = 0;
        for(int x = 0; x < this.melds.size();x ++){
            counter ++;
            int g = d.getValue(getCard(x).getCardValue());
            if(g < smallest){
                smallest = g;
            }
            else if(g > largest){
                largest = g;
            }
        }
        if(largest - smallest != (counter - 1)){
            return true;
        }else return false;
    }
    public Boolean checkSet(){
        card check = this.getCard(0);
        boolean test = true;
        for(int x = 0; x<this.melds.size(); x ++){
            if(this.getCard(x).getCardValue() != check.getCardValue()){
                test = false;
                break;
            }
        }
        return test;
    }
    public meld(){
        this.melds = new ArrayList<card>();
    }
}
