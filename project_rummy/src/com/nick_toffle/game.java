package com.nick_toffle;

import java.util.Scanner;

/**
 * Created by waffle on 2/22/15.
 */
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

//    public void handOut(hand name){
//        System.out.println(name.getplayer() + " has " + Integer.toString(handSize(name)) + " cards in hand.");
//    }
}
