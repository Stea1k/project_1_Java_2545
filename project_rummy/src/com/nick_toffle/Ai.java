package com.nick_toffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by waffle on 3/7/15.
 */
public class Ai extends Player{

    public Ai() {
        setHand("AI");
        setHand_cards();
        setMeld_stack();
        setScore(0);
    }

    public void cpuTurn(Deck d,Discard dis){
        //TODO
        //draw from deck
        this.player_drawFromDeck(d);
        this.cpuMeld(d);
        this.cpuCardToMeld(d);
        this.cpuDiscard(dis);
    }
    public void cpuMeld(Deck d){
        //1 dummy meld stack for all
        //4 array runs lists for cards by suit?
        //1 array list for sets
        //check each possible meld
        //add the first valid meld to the real meld stack.
        //TODO run setup:
        //make 4 dummy melds per suit
        Meld[] runMelds = new Meld[4];
   		Boolean mset = false;
        //for each card in hand, check the suit of said card and place it in the relevant meld
        HashMap<Integer,Card> hand = this.getCards();
        for(int i = 0; i < hand.size(); i ++){
            for(int s = 0; s<d.value.length; s ++) {
                Card c = fromPlayerHand(i);
                if(c.getCardValue().equals(d.value[s])){
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
        	//run through the hand of cards to build a set
        	for(int i = 0; i < this.getCards().size(); i ++){
        		Meld m = new Meld();
        		m.buildMeld(this.getCards().get(i));
        		for(int back = this.getCards().size() - 1; back >= i; back --){
        			if(this.getCards().get(back).getCardValue().equals(m.getCard(i))){
        				m.buildMeld(this.getCards().get(back));
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
        HashMap<Integer,Card> handStuff = this.getCards();
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

        if (handSize < 0) {
            d.dropCard(handSize, this.getCards());
            System.out.println("The CPU discarded the " + d.seeTop());
        } else {
            System.out.println("The CPU discarded the " + d.seeTop());
            System.out.println("The CPU has discarded it's last card. The hand is over!");

        }
    }
}

