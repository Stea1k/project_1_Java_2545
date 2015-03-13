package com.nick_toffle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by waffle on 2/21/15.
 *This class contains the player-specific methods and hand-related methods.
 */

public class Player {

    //the player class is built from a player name, a linked list (to be changed to a HashMap) of cards,
    //and a list of melds.
    private String player;
    private HashMap<Integer,Card> hand_cards;
    private ArrayList<Meld> meld_stack;
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
        this.hand_cards = new HashMap<Integer,Card>();
    }

    //returns the player's hand of cards.
    public HashMap<Integer,Card> getCards() {return this.hand_cards;}

    public Card fromPlayerHand(int i){
        return this.getCards().get(i);
    }
    public Card getDrawnCard(){
        return this.getCards().get(this.getCards().size()+1);
    }

    //sets the meld stack.
    public void setMeld_stack(){
        this.meld_stack = new ArrayList<Meld>();
    }

    //returns a player's meld stack
    public ArrayList<Meld> getMeld_stack(){
        return this.meld_stack;
    }

    //adds a given meld to the player's meld stack.
    public void addMeld_to_Stack(Meld m){
        this.getMeld_stack().add(m);
        this.presentMeld(m);
		for(Card t: m.getMeld()){
			for(int n = 0; n < this.getCards().size(); n ++){
				HashMap<Integer, Card> hnd = this.getCards();
				if(t.getCardValue().equals(hnd.get(n).getCardValue()) &&
				   t.getCardSuit().equals(hnd.get(n).getCardSuit())){
					this.getCards().remove(n);
				}
			}
		}
    }
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
            System.out.print(view.getCardValue() + " | " + view.getCardSuit());
        }
        System.out.println();
    }

    //given a player and a deck, adds a card from said deck to the hand of said player.
    public void player_drawFromDeck(Deck d){
        this.getCards().put(this.getCards().size()+1, d.draw());
    }

    //given a player hand and a discard pile, place a card from said discard pile into said player's hand.
    public void player_drawFromDiscard(Discard d){this.getCards().put(this.getCards().size()+1,d.drawDiscard());
    }
}
