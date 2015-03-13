package com.nick_toffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by waffle on 3/7/15.
 */
public class Ai extends Player{
//test
    public Ai() {
        setHand("AI");
        setHand_cards();
        setMeld_stack();
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
            //for runs of size 3 or more
                //build new melds of size 3 to hand size

        //make a dummy meld
        //for loop per card in player's hand:
            //get the value of the card
            //for each other card in the hand, check if it shares the value of the other cards in dummy meld.
            //if it does, add it to the dummy meld
        //if the dummy meld has a size of 3 or more, add it to the meld stack
        //for each card in the dummy meld, remove that card from the player's hand.
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
            System.out.println("The CPU has discarded it's last card. The round is over!");

        }
    }
}

