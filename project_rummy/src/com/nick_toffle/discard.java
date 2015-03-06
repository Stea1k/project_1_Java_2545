package com.nick_toffle;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by waffle on 3/1/15.
 * This is the discard pile class. It provides the methods necessary for viewing and managing the discard pile.
 */
public class discard {
    private LinkedList<card> discards;

    public void setDiscards(){
        this.discards = new LinkedList<card>();
    }

    public card seeTop(){
        card top = this.discards.peek();
        return top;
    }
    public card drawDiscard(){
        card top = this.discards.pop();
        return top;
    }
    public void dropCard(Integer i,HashMap<Integer, String[]> map){
        for(int key: map.keySet()){
            if(i == key){
                String[] newDiscard = new String[2];
                newDiscard[0] = map.get(i)[0];
                newDiscard[1] = map.get(i)[1];
                map.remove(key);
            }
        }
    }
    public discard(){
        setDiscards();
    }
}
