package com.nick_toffle;

import java.util.LinkedList;

/**
 * Created by waffle on 2/24/15.
 */
public class InsectManager {
    //main method
    public static void main(String[] args){
        //list of insects
        LinkedList<Insect> insects = new LinkedList<Insect>();
        //new butterfly test
        butterfly test_1 =new butterfly("name", 2,"color","flower");
        insects.add(test_1);
        //new bee test
        bee test_2 = new bee("bumble","yellow","all",true);
        insects.add(test_2);
        //test of polymorphism related to insect subclasses.
        for(Insect i: insects){
            i.printSpeciesData();
            System.out.println();
        }
    }
}
