package com.nick_toffle;

import java.util.ArrayList;

/**
 * Created by waffle on 3/1/15.
 * This class involves the methods necessary for creating and testing melds.
 */
public class Meld {
    //the meld class is built of an ArrayList of cards.
    protected ArrayList<Card> melds;
    //sets the meld object
    public void setMelds(){
        this.melds = new ArrayList<Card>();
    }
    //returns a meld
    public ArrayList<Card> getMeld(){
        return this.melds;
    }

    //adds a card to a possible meld
    public void buildMeld(Card c){
    	Card newC = c;
        this.melds.add(newC);
    }
    //gets a card from a meld
    public Card getCard(int c){
        return this.melds.get(c);
    }
    //checks if the possible meld is a valid meld
    //first validates the run by suit, then validates by card value.
    public Boolean checkRun(Deck d){
        String s = this.getCard(0).getCardSuit();
        int t = 0;
        for(int x = 1; x < this.melds.size(); x ++) {
            if (!s.equals(this.getCard(x).getCardSuit())) {
                t++;
            }
        }
        if(t>0){
            return false;
        }else {
            int largest = d.getValue(getCard(0).getCardValue());
            int smallest = d.getValue(getCard(0).getCardValue());
            int counter = 0;
            for (int x = 0; x < this.melds.size(); x++) {
                counter++;
                int g = d.getValue(getCard(x).getCardValue());
                if (g < smallest) {
                    smallest = g;
                } else if (g > largest) {
                    largest = g;
                }
            }
            if (largest - smallest != (counter - 1) && this.melds.size()>=3) {
                return true;
            } else return false;
        }
    }
    //Checks if a card set is valid.
    public Boolean checkSet(){
        Card check = this.getCard(0);
        boolean test = true;
        if(this.melds.size()<4){
        	test = false;
        }else{
        	for(int x = 0; x<this.melds.size(); x ++){
        		if(this.getCard(x).getCardValue() != check.getCardValue()){
        			test = false;
        			break;
        		}
        	}
        }
        return test;
    }
    //generates a new null meld (meld contructor)
    public Meld(){
        this.melds = new ArrayList<Card>();
    }
    public void showMeld(){
		System.out.println();
    	for(int c = 0; c < this.getMeld().size(); c ++){
    		System.out.println(Integer.toString(c) + " | "+
    							this.getMeld().get(c).getCardValue() + " of " + 
    							this.getMeld().get(c).getCardSuit());
    	}
		System.out.println();
    }
}