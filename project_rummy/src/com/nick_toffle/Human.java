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
        while(true) {
            try{

                String userStringInput = s.nextLine();
                System.out.println("Would you like to add cards to the meld? [y/n]");
                if(userStringInput.toLowerCase().equals("y")) {
                    int UserIntInput = s.nextInt();
                    System.out.println("Please enter the key of the card to be discarded");


                }else {
                    System.out.println("Would you like to discard and end your turn? [y/n]");
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