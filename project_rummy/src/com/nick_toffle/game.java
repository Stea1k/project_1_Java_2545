package com.nick_toffle;

import java.util.Scanner;

/**
 * Created by waffle on 2/22/15.
 * This class is the main game class. It is used largely for testing code and testing the game's operations.
 */

//game
public class game {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to start? y/n");
        String start = s.next();
        if(start.equals("n")){
            System.out.println("Thanks for your time!");
        }
        else if(start.equals("y")) {
            Deck game_start = new Deck("game1");
            hand player = new hand("player1");
//            hand computer = new hand("computer");
            for(int x = 0; x < 5; x ++){
                player.getCards().add(game_start.draw());
            }

            player.seeHand();
            System.out.println();
            System.out.println(Integer.toString(game_start.getdeck().size()));
        }
    }
    public static Integer handSize(hand name){
        return name.getCards().size();
    }
}
