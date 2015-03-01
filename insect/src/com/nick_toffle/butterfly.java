package com.nick_toffle;

/**
 * Created by waffle on 2/24/15.
 */
public class butterfly extends Insect{
    //added objects for butterfly on insect.
    private String wingColor;
    private String Flower;

    //getters for butterfly.
    public String getWingColor() {
        return wingColor;
    }

    public String getFlower() {
        return Flower;
    }

    //setters for butterfly.
    public void setColor(String color) {
        this.wingColor = color;
    }

    public void setFlower(String flower) {
        Flower = flower;
    }

    //butterfly constructor
    public butterfly(String n,Integer w,String c,String f){
        this.name = n;
        this.wings = w;
        this.wingColor = c;
        this.Flower = f;
    }
    //data method complete with override.
    @Override
    public void printSpeciesData(){
        System.out.println("The " + this.getName() + " butterfly has the following traits: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Wings: " + this.getWings());
        System.out.println("Color: " + this.getWingColor());
        System.out.println("legs: " + this.getLegs());
        System.out.println("Preferred Flower: " + this.getFlower());
    }
}
