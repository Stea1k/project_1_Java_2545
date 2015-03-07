package com.nick_toffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by waffle on 2/22/15.
 * This class is the main game class. It is used largely for testing code and testing the game's operations.
 */
//this is a test
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

            while (true) {
                turnCounter++;
                for (Player p : order) {
                    if (p.equals(player1)) {
                        //TODO human turn order
                    } else {//TODO AI turn order
                    }
                }

                System.out.println();
                System.out.println(Integer.toString(game_start.getdeck().size()));
            }
        }
    }


    //given a player and a deck, adds a card from said deck to the hand of said player.
    public void player_drawFromDeck(Player p, Deck d){
        p.getCards().put(p.getCards().size()+1, d.draw());
    }

    //given a player hand and a discard pile, place a card from said discard pile into said player's hand.
    public void player_drawFromDiscard(Player p, Discard d){
        p.getCards().put(p.getCards().size()+1,d.drawDiscard());
    }

    //given a player's hand and a discard pile, move a card from said player's hand into said discard pile.
    public void human_discard(Player p, Discard d){
        HashMap<Integer,Card> h = p.getCards();
        for(int key: h.keySet()){
            Card c = h.get(key);
            System.out.println(Integer.toString(key) + " | " + c.getCardValue() +" of " + c.getCardSuit());
        }
        System.out.println("please enter the key of the card to be discarded.");
        Scanner s = new Scanner(System.in);
        d.dropCard(s.nextInt(),p.getCards());
    }
    //sets a value for first player reference.
    public static Integer firstPlayer(){
        int goesFirst;
        Random r = new Random();
        goesFirst = r.nextInt(2);
        return goesFirst;
        }
    //TODO add
    //returns a player's hand size as an integer.
    public static Integer handSize(Player name){
        return name.getCards().size();
    }
}
