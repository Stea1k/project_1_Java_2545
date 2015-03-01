package com.nick_toffle;

import java.util.ArrayList;
import java.util.Scanner;

public class dogs {
    //sets up the name, address, and walks of any given dog.
    private String name;
    private String address;
    private Integer[] walks;

    //the dogs object
    public dogs(String n,String a){
        this.name = n;
        this.address = a;
        this.walks = new Integer[7];
    }

    //methods for getting a dog's name, address, and schedule.
    public String getname(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public Integer[] getWalks() {
        return this.walks;
    }

    //method for setting a dogs schedule. Information must input by user.
    public void setWalks(String[] list){
        Integer[] stuff = new Integer[7];
        for(int x = 0; x<7; x ++){
            Scanner s = new Scanner(System.in);
            System.out.println("How many times does " + this.getname() + " get walked on a " + list[x] + "?");
            stuff[x] = s.nextInt();
        }
        this.walks = stuff;
    }
}
