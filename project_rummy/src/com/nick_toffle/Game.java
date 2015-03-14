package com.nick_toffle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by waffle on 2/22/15.
 * This class is the main game class. It is used largely for testing code and testing the game's operations.
 */
//TODO test
//game
public class Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to start? y/n");
        String start = s.next();
        if (start.equals("n")) {
            System.out.println("Thanks for your time!");
        } else if (start.equals("y")) {
        	System.out.println("What will be the point limit? [50/100]");
        	int points = s.nextInt();
        	if(points == 50 || points == 100){while(true){
        		Deck game_start = new Deck("game1");
        		Discard discardPile = new Discard();
        		Human player1 = new Human("player1");
        		Ai computer = new Ai();
            	for (int x = 0; x < 5; x++) {
                	player1.getCards().add(game_start.draw());
                	computer.getCards().add(game_start.draw());
            	}
            	discardPile.addCard(game_start.draw());
            	int turnCounter = 0;
            	int first = firstPlayer();
            	ArrayList<Player> order = new ArrayList<Player>();
            	if (first < 1) {
                	order.add(player1);
                	order.add(computer);
            	} else {
                	order.add(computer);
                	order.add(player1);
            	}
            	//TODO add boolean check for end game following discard.
            	while (turnCounter >= 0) {
                	turnCounter ++;
                	for (Player p : order) {
                		System.out.println("_____________________________________________________________");
                		System.out.println("\n" + "turn" + Integer.toString(turnCounter) + "\n");
                    	System.out.println("Top discard: " + 
                    						discardPile.seeTop().getCardValue() + " of " +
                    						discardPile.seeTop().getCardSuit()+"s");
                    	System.out.println("\n" + p.getplayer());
                    	System.out.println("\n" + "Hand size: " + Integer.toString(p.getCards().size()));
                    	p.seeHand();
                		if (p.equals(player1)) {
                    	//TODO human turn order
                    		player1.humanTurn(game_start, discardPile, s);
                    	} else {
                        	//TODO AI turn order
                    		computer.cpuTurn(game_start,discardPile);
                    	}
                		if(!nocards(p)){
                			turnCounter = -1;
                			break;
                		}
                	}

//              	  System.out.println();
//              	  System.out.println(Integer.toString(game_start.getdeck().size()));
            	}
            	endOfRound(order,points,s);
        	}}
        }
        s.close();
    }
    public static Boolean nocards(Player p){
    	if(p.getCards().isEmpty()){
    		return false;
    	}else return true;
    }
    public static Boolean endOfRound(ArrayList<Player> order,int Points,Scanner scan) {
        //calculate points for each card in each meld
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for(Player p : order) {
            int scoreCounter = 0;
            for (Meld m : p.getMeld_stack()) {
                for(int x = 0; x < m.getMeld().size(); x++) {

                    if (isParsible(m.getMeld().get(x).getCardValue())) {
                        int toScoreCounter = Integer.parseInt(m.getMeld().get(x).getCardValue());
                        scoreCounter += toScoreCounter;

                    } else if (m.getMeld().get(x).getCardValue().equals("Ace")){
                        scoreCounter += 15;
                    } else {
                        scoreCounter += 10;
                    }
                    scores.add(scoreCounter);
                }
            }
        }
        for(int s = 0; s < 2; s ++){
        	order.get(s).addToScore(scores.get(s));
            System.out.println(order.get(s) + " has " + scores.get(s) + " points. \n");
        }
        if (scores.get(0) > scores.get(1) && scores.get(0) >= Points) {
            System.out.println(order.get(0) + " wins " + " with " + scores.get(0) + " points! ");
            return false;
        } else if(scores.get(1) > scores.get(0) && scores.get(1) >= Points){
            System.out.println(order.get(1) + " wins " + " with " + scores.get(1) + " points! ");
            return false;
        }else {
        	System.out.println("Would you like to continue playing? [y/n]");
        	String stringIn = scan.next();
        	if(stringIn.equals("n")){
        		return false;
        	}else return true;
        }

        //display results
        //declare winner
    }
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
}
