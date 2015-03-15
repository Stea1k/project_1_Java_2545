package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Nick Toffle and Casey Holmgren on 2/21/15.
 * Class: Player
 */

public class Player {

    //the player class is built from a player name, a linked list (to be changed to a HashMap) of cards,
    //and a list of melds.
    private String player;
    private LinkedList<Card> hand_cards;
    private ArrayList<Meld> meld_stack;
    private int score;
    
    //sets the player's name.
    public void setHand(String name){
        this.player = name;
    }

    //returns a player's name
    public String getplayer(){
        return this.player;
    }

    //sets a hand of cards (to be altered)
    public void setHand_cards(){
        this.hand_cards = new LinkedList<Card>();
    }

    //returns the player's hand of cards.
    public LinkedList<Card> getCards() {return this.hand_cards;}

    //returns a card from the player's hand
    public Card fromPlayerHand(int i){
        return this.getCards().get(i);
    }
    
    //returns the card last drawn.
    public Card getDrawnCard(){
        return this.getCards().get(this.getCards().size()-1);
    }

    //sets the meld stack.
    public void setMeld_stack(){
        this.meld_stack = new ArrayList<Meld>();
    }

    //returns a player's meld stack
    public ArrayList<Meld> getMeld_stack(){
        return this.meld_stack;
    }

    //sets the player's score
    public void setScore(int i){
    	this.score = i;
    }
    
    //gets the player's score
    public Integer getScore(){
    	return this.score;
    }
    
    //adds to the player's score
    public void addToScore(int i){
    	int s = this.getScore();
    	s += i;
    	this.setScore(s);
    }
    
    //adds a given meld to the player's meld stack.
    public void addMeld_to_Stack(Meld m){
        this.getMeld_stack().add(m);
        this.presentMeld(m);
		for(Card t: m.getMeld()){
			for(int n = 0; n < this.getCards().size(); n ++){
				LinkedList<Card> hnd = this.getCards();
				if(t.getCardValue().equals(hnd.get(n).getCardValue()) &&
				   t.getCardSuit().equals(hnd.get(n).getCardSuit())){
					this.getCards().remove(n);
				}
			}
		}
    }
    
    //adds a card to a meld already in existence.
    public void newLayOff(int m, Card c){
    	this.getMeld_stack().get(m).buildMeld(c);
    	System.out.println(" \n Your " + c.getCardValue() + " of " + c.getCardSuit() + "s has been used in a lay off. \n");
    	for(int n = 0;n < this.getCards().size(); n ++){
    		if(c.getCardSuit().equals(this.getCards().get(n).getCardSuit()) &&
    		   c.getCardValue().equals(this.getCards().get(n).getCardValue())){
    			this.getCards().remove(c);
    		}
    	}
    }
    
    //shows all cards in the meld.
    public void presentMeld(Meld m){
    	System.out.println(this.getplayer() + " has created a meld using: ");
    	for(Card c : m.getMeld()){
    		System.out.println(c.getCardValue() + " of " + c.getCardSuit() +"s");
    	}
    }
    //shows the contents of a player's hand.
    public void seeHand(){
        for(int x = 0; x < this.getCards().size(); x ++){
            Card view = this.getCards().get(x);
            System.out.println(Integer.toString(x) + "| " + 
            					view.getCardValue() + " of " + 
            					view.getCardSuit() + "s |");
        }
        System.out.println();
    }

    //given a player and a deck, adds a card from said deck to the hand of said player.
    public void player_drawFromDeck(Deck d){
    	Card c = d.draw();
//    	System.out.println(c.getCardValue() + " of " + c.getCardSuit() + "\n");
        this.getCards().add(c);
//        this.seeHand();
    }

    //given a player hand and a discard pile, place a card from said discard pile into said player's hand.
    public void player_drawFromDiscard(Discard d){this.getCards().add(d.drawDiscard());
    }
}
