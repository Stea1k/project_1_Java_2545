package com.nick_toffle;

public class Insect {
    //base superclass
    protected String name;
    protected Integer wings;
    protected Integer legs = 6;
    //getters for all basic insect information.
    public String getName() {
        return name;
    }

    public Integer getWings() {
        return wings;
    }

    public Integer getLegs() {
        return legs;
    }
    //setters for all basic insect information
    public void setName(String name) {
        this.name = name;
    }

    public void setWings(Integer wings) {
        this.wings = wings;
    }
    //base method for the printSpeciesData Method.
    public void printSpeciesData(){
    }
}