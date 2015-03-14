package com.nick_toffle;

import java.util.LinkedList;

/**
 * Created by waffle on 3/1/15.
 * This is the discard pile class. It provides the methods necessary for viewing and managing the discard pile.
 */
public class Discard {
    //the discard pile is simply a linked card list.
    private LinkedList<Card> discards;

    //sets the discards as a new linked list of cards.
    public void setDiscards(){
        this.discards = new LinkedList<Card>();
    }

    //returns the value and suit of the top card of the given discard pile.
    public Card seeTop(){
        Card top = this.discards.peek();
        return top;
    }

    public LinkedList<Card> getDiscards(){
        return this.discards;
    }
    //pops the top card from the given discard pile.
    public Card drawDiscard(){
        Card top = this.discards.pop();
        return top;
    }
    public void addCard(Card c){
        this.discards.add(c);
    }

    //method for discarding a card from a player's hand.
    public void dropCard(Integer i,LinkedList<Card> linkedList){
        for(int x = 0; x < linkedList.size(); x ++){
            if(i == x){
                Card newDiscard = new Card(linkedList.get(i).getCardValue(),linkedList.get(i).getCardSuit());
                this.addCard(newDiscard);
                linkedList.remove(x);
            }
        }
    }

    //discard constructor.
    public Discard(){
        setDiscards();
    }
}
