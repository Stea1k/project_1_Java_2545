package com.nick_toffle;

/**
 * Created by waffle on 2/24/15.
 */
public class bee extends Insect{
    //bee class extended from insect.
    private String color;
    private String flower;
    private boolean honey;
    //getters for be traits.
    public String getColor() {
        return color;
    }

    public String getFlower() {
        return flower;
    }

    public boolean isHoney() {
        return honey;
    }
    //setters for bee traits.
    public void setColor(String color) {
        this.color = color;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public void setHoney(boolean honey) {
        this.honey = honey;
    }

    //constructor for bee object
    public bee(String n, String color, String flower, boolean honey) {
        this.name = n;
        this.color = color;
        this.wings = 2;
        this.flower = flower;
        this.honey = honey;
    }

    //bee information method complete with override.
    @Override
    public void printSpeciesData(){
        System.out.println("The " + this.getName() + " bee has the following traits: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Wings: " + this.getWings());
        System.out.println("Color: " + this.getColor());
        System.out.println("Flower: " + this.getFlower());
        System.out.println("Makes Honey: " + this.isHoney());
    }
}
