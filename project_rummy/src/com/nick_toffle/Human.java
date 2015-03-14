package com.nick_toffle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
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
        setScore(0);
    }

    public void humanTurn(Deck d,Discard dis,Scanner s){
    	this.humanDraw(d,dis,s);
    	this.humanMeld(d, s);
    	this.humanCardToMeld(d, s);
    	this.humanDiscard(d, dis, s);
    }
    
    public void humanDraw(Deck d, Discard dis, Scanner s) {
        //prompts human player to draw from either the deck or the discards
        while(true){
            try{
                System.out.println("Would you like to draw from the deck(1) or the discard pile(2)? ");
                int userInput = s.nextInt();
                if (userInput==1){
                    this.player_drawFromDeck(d);
                    Card dummyCard = getDrawnCard();
                    System.out.println("You drew a " + dummyCard.getCardValue() + 
                    					" of " +dummyCard.getCardSuit()+ ".");
                    break;
                } else if (userInput==2){
                    this.player_drawFromDiscard(dis);
                    Card dummyCardFromDiscard = getDrawnCard();
                    System.out.println("You drew a " + 
                    					dummyCardFromDiscard.getCardValue() +" of "+
                    					dummyCardFromDiscard.getCardSuit() + ".");
                    break;
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
                	} else if(m.getMeld().size() >= 3 && (!m.checkRun(d) && !m.checkSet())){
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
                				if(m.getCard(n).getCardValue().equals(m.getCard(userIntInput).getCardValue()) && 
                				   m.getCard(n).getCardSuit().equals(m.getCard(userIntInput).getCardSuit())){
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
    public void humanCardToMeld(Deck d,Scanner s){
        ArrayList<Meld> M = this.getMeld_stack();
        int M_size = M.size();
        System.out.println("\n Melds held by you: " + Integer.toString(M_size) + "\n");
        String stringIn;
        Integer intIn;
        
        if(M_size > 0){
        	//if there are any melds available to add to:
        
        	while(true){
        		//make layoff request
        		System.out.println("Would you like to try adding to a meld? [y/n]");
        		stringIn = s.next();
        		//if no layoff is requested.
        	
        		if(stringIn.equals("n")){
        			System.out.println("Laying off cancelled.");
        			break;
        		//if a layoff is requested
        		
        		}else if(stringIn.equals("y")){
        			//present all available melds for a layoff.
        			System.out.println("Please select a meld to add to from the list below: ");
        		
        			for(int m = 0; m < M_size; m ++){
        				System.out.println("Meld " + Integer.toString(m) + ": ");
        				M.get(m).showMeld();
        			}
        			//request the meld number.
        			System.out.println("What is the number of the meld you would like to add to?");
        			intIn = s.nextInt();
        			//check if the meld requested exists.
        			
        			if(intIn > M_size || intIn <= 0){
        				System.out.println("You must choose a meld that is available.");
        			
        			}else{
        				//request a card from the player's hand.
        				System.out.println("Please choose a card from your hand to add to meld " + Integer.toString(intIn));
        				this.seeHand();
        				int layInt = s.nextInt();
        				//show the card being used to lay off.
        				System.out.println(this.getCards().get(layInt).getCardValue() + " of " +
        								   this.getCards().get(layInt).getCardSuit() + "s \n");
        				System.out.println("Is this the card to be added? [y/n]");
        				stringIn = s.next();
        				//verify the card being used.
        			
        				if(stringIn.equals("n")){
        					System.out.println("Layoff cancelled.");
        					break;
        				//if the card is correct, add it to the meld if the meld is valid.
        				
        				}else if(stringIn.equals("y")){
        					Meld test = this.getMeld_stack().get(intIn);
        					Card c = this.getCards().get(layInt);
        					test.buildMeld(c);
        				
        					if(test.checkRun(d) || test.checkSet()){
        						this.getMeld_stack().get(intIn).buildMeld(c);
        						this.newLayOff(intIn, c);
        					//if the meld is invalid, return a failure message.
        					
        					}else{
        						System.out.println("Lay off failed. Invalid meld created.");
        					}
        				//if y or n are not chosen.
        				
        				}else{
        					System.out.println("Please choose 'y' or 'n'. Layoff Cancelled.");
        				}
        			}
        		}
        	}
        	
        //if the size of the list of melds is 0, return a message.
        }else if(M_size == 0){
        	System.out.println("You have no melds to add to.");
        }
    }

    //given a player's hand and a discard pile, move a card from said player's hand into said discard pile.
    public void humanDiscard(Deck d, Discard dis, Scanner s) {
        //discard a card from the human player's hand
    	LinkedList<Card> h = this.getCards();
        for(int x = 0; x < h.size(); x ++){
            Card c = h.get(x);
            System.out.println(x + " | " + c.getCardValue() +" of " + c.getCardSuit());
        }
        try{
            System.out.println("Which card would you like to discard?");
            int stuff = s.nextInt();
            Card disC = this.getCards().get(stuff);
            System.out.println("You have discarded a " + disC.getCardValue()+
            					" of " + disC.getCardSuit());
            dis.dropCard(stuff,this.getCards());

        }catch(InputMismatchException ime) {
            System.out.println("Please stick to the number keys.");
        }
    }
}