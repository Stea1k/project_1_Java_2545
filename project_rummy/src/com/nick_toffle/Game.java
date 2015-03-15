package com.nick_toffle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nick Toffle and Casey Holmgren on 2/21/15.
 * This class is the main game class. It is used largely for testing code and testing the game's operations.
 */
//TODO test
//game
public class Game {
    public static void main(String[] args) {
    	//Stat the game up
        Scanner s = new Scanner(System.in);
        
        //Check if the player would like to initiate the game.
        System.out.println("Would you like to start? y/n");
        String start = s.next();
        
        //Cancels the game if the player declines.
        if (start.equals("n")) {
            System.out.println("Thanks for your time!");
           //Starts the game otherwise.
        
        } else if (start.equals("y")) {
        	//checks the point limit for end game.
        	System.out.println("What will be the point limit? [50/100]");
        	int points = s.nextInt();
        
        	//game is built
        	if(points == 50 || points == 100){while(true){
        		Deck game_start = new Deck("game1");
        		Discard discardPile = new Discard();
        		Human player1 = new Human("player1");
        		Ai computer = new Ai();
            
        		//populates each player's hand.
        		for (int x = 0; x < 5; x++) {
                	player1.getCards().add(game_start.draw());
                	computer.getCards().add(game_start.draw());
            	}
        		
        		//generates the discard pile.
            	discardPile.addCard(game_start.draw());
            	
            	//sets a turn counter to 0.
            	int turnCounter = 0;
            	
            	//randomly chooses the first player.
            	int first = firstPlayer();
            	ArrayList<Player> order = new ArrayList<Player>();
            	if (first < 1) {
                	order.add(player1);
                	order.add(computer);
            	} else {
                	order.add(computer);
                	order.add(player1);
            	}
            	
            	//while loop for game operations.
            	while (turnCounter >= 0) {
                	turnCounter ++;
                	
                	//for loop goes through the turn for each player.
                	for (Player p : order) {
                		System.out.println("_____________________________________________________________");
                		System.out.println("\n" + "turn" + Integer.toString(turnCounter) + "\n");
                    	
                		//shows the top card of the discard pile.
                		System.out.println("Top discard: " + 
                    						discardPile.seeTop().getCardValue() + " of " +
                    						discardPile.seeTop().getCardSuit()+"s");
                    	
                		//prints the name of the player currently up.
                		System.out.println("\n" + p.getplayer());
                    	
                		//prints the player's hand size as reference.
                		System.out.println("\n" + "Hand size: " + Integer.toString(p.getCards().size()));
                    	
                		//used for debugging.
//                		p.seeHand();
                		
                		//if checker for the turn order.
                		if (p.equals(player1)) {
                    	//TODO human turn order
                    		player1.humanTurn(game_start, discardPile, s);
                    	} else {
                        	//TODO AI turn order
                    		computer.cpuTurn(game_start,discardPile);
                    	}
                		
                		//if a player ends their turn with no cards in hand, the while loop breaks.
                		if(!nocards(p)){
                			turnCounter = -1;
                			break;
                		}
                		
                		//checks if the deck is out of cards.
                		deckCheck(game_start,discardPile);
                	}

//              	  System.out.println();
//              	  System.out.println(Integer.toString(game_start.getdeck().size()));
            	}
            	//adds up the points for the round and declares a winner for that round.
            	endOfRound(order,points,s);
        	//else statement for if the points requested were invalid.
        	}}else{
        		System.out.println("Point selection invalid, try again later.");
        	}
        }
        s.close();
    }
    
    //checks if a player has any cards in hand.
    public static Boolean nocards(Player p){
    	if(p.getCards().isEmpty()){
    		return false;
    	}else return true;
    }
    
    //point calculator for the end of a round.
    public static Boolean endOfRound(ArrayList<Player> order,int Points,Scanner scan) {
        //calculate points for each card in each meld
        ArrayList<Integer> scores = new ArrayList<Integer>();
        
        //for a given player
        for(Player p : order) {
            int scoreCounter = 0;
            
            //for each meld in the players meld stack.
            for (Meld m : p.getMeld_stack()) {
                
            	//for each card in the meld, add up the point value.
            	for(int x = 0; x < m.getMeld().size(); x++) {
            		//if the card value is parsible, return the numeric value of the card
                    if (isParsible(m.getMeld().get(x).getCardValue())) {
                        int toScoreCounter = Integer.parseInt(m.getMeld().get(x).getCardValue());
                        scoreCounter += toScoreCounter;
                    
                        //if the card is not parsible and is an ace return 15 points
                    } else if (m.getMeld().get(x).getCardValue().equals("Ace")){
                        scoreCounter += 15;
                        
                        //otherwise return 10 points.
                    } else {
                        scoreCounter += 10;
                    }
                    
                    //append the scores to the scores list.
                    scores.add(scoreCounter);
                }
            }
        }
        
        //for each score in the score list print the points for the appropriate player.
        for(int s = 0; s < 2; s ++){
        	order.get(s).addToScore(scores.get(s));
            System.out.println(order.get(s) + " has " + scores.get(s) + " points. \n");
        }
        
        //prints the winning player and their score if a player has points equal to or greater than the desired amount.
        if (scores.get(0) > scores.get(1) && scores.get(0) >= Points) {
            System.out.println(order.get(0) + " wins " + " with " + scores.get(0) + " points! ");
            return false;
        } else if(scores.get(1) > scores.get(0) && scores.get(1) >= Points){
            System.out.println(order.get(1) + " wins " + " with " + scores.get(1) + " points! ");
            return false;
        }else {
        	//asks if another round is acceptable.
        	System.out.println("Would you like to continue playing? [y/n]");
        	String stringIn = scan.next();
        	if(stringIn.equals("n")){
        		return false;
        	}else return true;
        }
    }
    
    //checks if a string is parseable
    public static boolean isParsible(String input) {
        boolean parsable = true;
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

    //sets a value for first player reference.
    public static Integer firstPlayer(){
        int goesFirst;
        Random r = new Random();
        goesFirst = r.nextInt(2);
        return goesFirst;
        }
    //TODO methods that iterate through human and AI turn order.
    //returns a player's hand size as an integer.
    public static Integer handSize(Player name){
        return name.getCards().size();
    }
    
    //checks if the deck is empty and sets it equal to the discard pile if it is.
    //discard pile is reset.
    public static void deckCheck(Deck d, Discard dis){
    	if(d.getdeck().isEmpty()){
    		d.setDeck(dis.getDiscards());
    		dis.setDiscards();
        	dis.addCard(d.draw());    		
    	}
    }
}
