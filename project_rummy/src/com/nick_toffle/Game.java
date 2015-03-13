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
            Deck game_start = new Deck("game1");
            Discard discardPile = new Discard();
            Human player1 = new Human("player1");
            Ai computer = new Ai();
            for (int x = 0; x < 5; x++) {
                player1.getCards().put(x, game_start.draw());
                computer.getCards().put(x, game_start.draw());
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
            while (true) {
                turnCounter++;
                for (Player p : order) {
                    if (p.equals(player1)) {
                        //TODO human turn order
                    } else {
                        //TODO AI turn order
                    }
                }

//                System.out.println();
//                System.out.println(Integer.toString(game_start.getdeck().size()));
            }
        }
    }public void endOfRound(ArrayList<Player> order) {
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
        if (scores.get(0) > scores.get(1)) {
            System.out.println(order.get(0) + " wins " + " with " + scores.get(0) + " points! ");
        } else {
            System.out.println(order.get(1) + " wins " + " with " + scores.get(1) + " points! ");
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
