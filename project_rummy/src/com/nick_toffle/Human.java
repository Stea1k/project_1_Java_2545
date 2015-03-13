package com.nick_toffle;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by waffle on 3/7/15.
 */
public class Human extends Player{

    //hand constructor.
    public Human(String name) {
        setHand(name);
        setHand_cards();
        setMeld_stack();
    }

    public void humanDraw(Deck d, Discard dis, Scanner s) {
        //prompts human player to draw from either the deck or the discards
        while(true){
            try{
                int userInput = s.nextInt();
                System.out.println("Would you like to draw from the deck(1) or the discard pile(2)? ");
                if (userInput==1){
                    this.player_drawFromDeck(d);
                    Card dummyCard = getDrawnCard();
                    System.out.println("You drew a " + dummyCard + ".");
                } else if (userInput==2){
                    this.player_drawFromDiscard(dis);
                    Card dummyCardFromDiscard = getDrawnCard();
                    System.out.println("You drew a " + dummyCardFromDiscard + ".");
                } else {
                    System.out.println("Please stick to the number keys. ");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Please stick to the number keys.");
            }
        }
    }
    //TODO finish humanMeld method
    public void humanMeld(Deck d, Scanner s) {
        System.out.println("Would you like to make a meld? [y/n]");
        String userStringInput = s.next();
        if(userStringInput.toLowerCase().equals("y")) {
            try{

            	//what cards should be added to the meld?
            	//make dummy meld
            	//show all cards in the hand
            	//if there is an attempt to add a card already added, note an exception.
            	//loop until player chooses to stop.
            	//once three valid cards are added to the dummy meld, add prompt noting validity.
                Meld m = new Meld();
                while(true) {
                	this.seeHand();
                	//if the meld is of size 3 or more and valid, provide the player with the option of adding it to the stack, 
                	
                	//Canceling the meld, or adding more to the meld.
                	if(m.getMeld().size() >= 3 && (m.checkRun(d) || m.checkSet())){
                		System.out.println("You currently have a valid meld.");
                		m.showMeld();
                		System.out.println("Is the meld complete? [y to finish meld, q to cancel, a to add another card]");
                		userStringInput = s.next();
            			
                		//cancels the meld.
                		if(userStringInput.equals("q")){
                			System.out.println("Meld cancelled");
                			break;
                    		
                			//adds the meld to the meld stack.
                		}else if(userStringInput.equals("y")){
                			this.addMeld_to_Stack(m);
                			break;
                			
                			//human can add to the meld.
                		} else if(userStringInput.equals("a")){
                    		System.out.println();
                    		System.out.println("Please enter the key of the card to be added:");
                    		int UserIntInput = s.nextInt();
                    		for(int c = 0; c < this.getCards().size(); c ++){
                    				if(c == UserIntInput){
                    					m.buildMeld(this.getCards().get(c));
                    				}
                       			}
                			}else {
                    			System.out.println("Enter a valid command");
                    		}
                		
                		//if the meld is size 3 or more and not valid
                	} else if(m.getMeld().size() >= 3 && !(m.checkRun(d) || m.checkSet())){
                		System.out.println("Your current meld is invalid.");
                		m.showMeld();
                		System.out.println("What would you like to do? \n" +
                				"[q to cancel meld, r to remove a card]");
                		userStringInput = s.next();
                		
                		//q for quitting the meld.
                		if(userStringInput.equals("q")){
                			System.out.println("Meld cancelled");
                			break;
                			
                			//r to remove a card from the meld.
                		}else if(userStringInput.equals("r")){
                			System.out.println("Enter the position of the card in meld.");
                			int userIntInput = s.nextInt();
                			for(int n = 0; n < m.getMeld().size(); n ++){
                				if(m.getCard(n).getCardValue().equals(Integer.toString(userIntInput))){
                					m.getMeld().remove(n);
                				}
                			}
                		}else {
                			System.out.println("Enter a valid command");
                		}
                		//if the hand is not size 3 or more.
                	}else if(m.getMeld().size() < 3){
                		m.showMeld();
                		System.out.println("What would you like to do? \n" +
                				"[q to cancel meld, a to add to meld, r to remove a card from the meld]");
                		userStringInput = s.next();
                		if(userStringInput.equals("q")){
                			System.out.println("Meld cancelled");
                			break;
                		}else if(userStringInput.equals("a")){
                			System.out.println("Please enter the key of the card to be added:");
                			int UserIntInput = s.nextInt();
                			for(int c = 0; c < this.getCards().size(); c ++){
                					if(c == UserIntInput){
                						m.buildMeld(this.getCards().get(c));
                				}
                   			}
                		}else if(userStringInput.equals("r")){
                			System.out.println("Enter the position of the card in meld.");
                			int userIntInput = s.nextInt();
                			for(int n = 0; n < m.getMeld().size(); n ++){
                				if(m.getCard(n).getCardValue().equals(Integer.toString(userIntInput))){
                					m.getMeld().remove(n);
                				}
                			}
                		}else {
                			System.out.println("Enter a valid command");
                		}
                	}

            	}
            }catch(InputMismatchException ime) {

            }
        }
    }
    public void humanCardToMeld(){
        //add a card from the hand to a chosen meld
    }

    //given a player's hand and a discard pile, move a card from said player's hand into said discard pile.
    public void humanDiscard(Deck d, Discard dis, Scanner s) {
        //discard a card from the human player's hand
        HashMap<Integer,Card> h = this.getCards();
        for(int key: h.keySet()){
            Card c = h.get(key);
            System.out.println(Integer.toString(key) + " | " + c.getCardValue() +" of " + c.getCardSuit());
        }
        while(true){
            try{
                System.out.println("Which card would you like to discard?");
                dis.dropCard(s.nextInt(),this.getCards());

            }catch(InputMismatchException ime) {
                System.out.println("Please stick to the number keys.");
            }
        }


    }
}