package com.nick_toffle;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by waffle on 3/1/15.
 */
public class meld {
    protected ArrayList<String[]> melds;

    public void setMelds(){
        this.melds = new ArrayList<String[]>();
    }
    public String[] getMeld(int m){
        return this.melds.get(m);
    }
    public void buildMeld(String[] c){
        this.melds.add(c);
    }
    public Boolean checkMeld(){
        for(int x = 0; x < this.melds.size();x ++){
            
        }
    }
    public meld(){
        this.melds = new ArrayList<String[]>();
    }
}
