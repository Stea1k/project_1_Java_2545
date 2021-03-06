package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Nick Toffle and Casey Holmgren on 2/21/15.
 */
public class Ai extends Player{

    public Ai() {
        setHand("AI");
        setHand_cards();
        setMeld_stack();
        setScore(0);
    }

    //AI turn
    public void cpuTurn(Deck d,Discard dis){
        this.player_drawFromDeck(d);
        this.cpuMeld(d);
        this.cpuCardToMeld(d);
        this.cpuDiscard(dis);
    }
    
    //AI method that looks for the first meld available and makes it.
    public void cpuMeld(Deck d){
        //1 dummy meld stack for all
        //4 array runs lists for cards by suit?
        //1 array list for sets
        //check each possible meld
        //add the first valid meld to the real meld stack.
        //TODO run setup:
        //make 4 dummy melds per suit
        Meld[] runMelds = new Meld[4];
        runMelds[0] = new Meld();
        runMelds[1] = new Meld();
        runMelds[2] = new Meld();
        runMelds[3] = new Meld();
   		Boolean mset = false;
        //for each card in hand, check the suit of said card and place it in the relevant meld
   		LinkedList<Card> hand = this.getCards();
        for(int i = 0; i < hand.size(); i ++){
            for(int s = 0; s<d.suit.length; s ++) {
                Card c = fromPlayerHand(i);
                if(c.getCardSuit().equals(d.suit[s])){
                    runMelds[s].buildMeld(c);
                }
            }
        }
        //check length of each suit
        
        for(int i = 0; i<runMelds.length; i ++){
           //for runs of size 3
       		Meld temp = runMelds[i];
       	
       		if(temp.getMeld().size() == 3 && temp.checkRun(d)){
       			//check if the run is viable. if it is, add it to the meld stack.
       			this.getMeld_stack().add(temp);
       	
       		//if runs are greater than 3
            }else if(temp.getMeld().size() > 3){
        		
            	for(int c = 0; c < temp.getMeld().size() - 1; c ++){
               		//make a new dummy meld with the first card of the temp meld.
               		Meld subTemp = new Meld();
               		subTemp.buildMeld(temp.getCard(c));
               		Card v1 = temp.getCard(c);
              		//for each other card available within the meld starting with the last
        			
               		for(int step = temp.getMeld().size()-1; step > c; step --){
               			Card v2 = temp.getCard(step);
               			//check if the value of the card is within 1 step of the first card.
        				
               			if(d.checkCard(v1,v2)){
               				subTemp.buildMeld(temp.getCard(c));
               				//if there is a match, add the card to the dummy meld 
               				//set c to the position of the card added.
               				c = temp.getMeld().size() - step;
               				}
               			}
        			//if the created dummy meld subTemp is valid, add it to the meld stack.
        			if(subTemp.getMeld().size() >= 3 && subTemp.checkRun(d)){
        				this.addMeld_to_Stack(subTemp);
						mset = true;
        			}
           		}
           	}
        }
        //if mset is still false
        if(!mset){
        	LinkedList<Card> handTemp = this.getCards();
        	
        	//run through the hand of cards to build a set
        	for(int i = 0; i < handTemp.size()-1; i ++){
        		Meld m = new Meld();
        		Card startTempCard = handTemp.get(i);
        		m.getMeld().add(startTempCard);
        		
        		//iterate through the cards in hand backwards for cards with identical values.
        		for(int back = handTemp.size() - 1; back > i; back --){
        			Card temp = handTemp.get(back);
        			if(temp.getCardValue().equals(startTempCard.getCardValue())){
        				m.buildMeld(handTemp.get(back));
        			}
        		}
        		
        		//if the set is valid, add it to the meld stack and break the loop.
        		if(m.checkSet()){
        			this.addMeld_to_Stack(m);
        			break;
        		}
        	}
        }
    }
    public void cpuCardToMeld(Deck d){
    
    	//adds a card in hand to a meld already existing in the meld stack.
        //checks meld stack with cards in hand for possible layoffs.
            //if a match is found, the card is placed in with the meld.
        
    	ArrayList<Meld> stuff = this.getMeld_stack();
        LinkedList<Card> handStuff = this.getCards();
        //for loop that pulls each meld from the meld stack.
        //for loop that pulls each card from the AI's hand.
        //each card pulled form AI's hand is checked against each meld
            //the first one that succeeds is applied.
        
        for(int x = 0; x<stuff.size(); x ++){
            for(int y = 0; y< handStuff.size(); y ++){
                //get meld x
                //put card y into temp meld with x
                //check the result
                //first success breaks loops.
                    //checker = true -> break loop.
        
            	Meld meld = stuff.get(x);
                Card c = handStuff.get(y);
                meld.buildMeld(c);
                
                if(meld.checkRun(d) || meld.checkSet()){
                    this.addMeld_to_Stack(meld);
                }
            }
        }
    }

    // method for cpu to discard
    public void cpuDiscard(Discard d){
        Random r = new Random();
        int handSize = r.nextInt(this.getCards().size());
        d.dropCard(handSize, this);
        System.out.println("The CPU discarded the " + d.seeTop().getCardValue() +
        					" of " + d.seeTop().getCardSuit() + "s");
    }
}

