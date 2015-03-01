package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by waffle on 3/1/15.
 */
public class meld {
    protected ArrayList<String[]> melds;
    //sets the meld object
    public void setMelds(){
        this.melds = new ArrayList<String[]>();
    }
    //returns a meld
    public ArrayList<String[]> getMeld(){
        return this.melds;
    }
    //adds a card to a possible meld
    public void buildMeld(String[] c){
        this.melds.add(c);
    }
    //checks if the possible meld is a valid meld
    public Boolean checkMeld(){
        int largest = 0;
        for(int x = 0; x < this.melds.size();x ++){
            /*
            * for card within a meld of size > x, look for the card with the smallest meld value and the card with the largest meld value.
            * find these value by iterating through the card value list in Deck.java and return the placement of the card as the card value.
            * If largest - smallest != (this.melds.size() - 1) then the meld is not valid.
            * otherwise the meld is valid.*/
            
        }
    }
    public meld(){
        this.melds = new ArrayList<String[]>();
    }
}
