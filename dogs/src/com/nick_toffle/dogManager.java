package com.nick_toffle;

import java.util.ArrayList;

/**
 * Created by waffle on 2/23/15.
 */
public class dogManager {
    //main method for calling a new dog and setting a string array for the days in a week.
    public static void main(String[] args){
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        //array list that holds each dog.
        ArrayList<dogs> schedule = new ArrayList<dogs>();
        //each dog must be added separately.
        dogs abe = new dogs("abe","123 fk st.");
        dogs lady = new dogs("Lady","3 1/4 NNW St.");
        //calls the setWalks method from the dogs class.
        abe.setWalks(days);
        lady.setWalks(days);
        //adds the dog to the schedule array.
        schedule.add(abe);
        schedule.add(lady);
        //prints the current schedule.
        layout(schedule, days);
    }
    //layout method, provides a layout of the coming week.
    public static void layout(ArrayList<dogs> dogList, String[] day){
        //for each day in the week...
        for(int x = 0; x < day.length; x ++){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(day[x]); //print the day between two identifying lines.
            System.out.println("-----------------------------------------------------------------------");
            int walks = 0; //set up a counter object.
            //look at a given dog (d)...
            for(int d = 0; d < dogList.size(); d ++){
                dogs dog = dogList.get(d);
                //if that dog is scheduled to be walked at least 1 time on the given day...
                if(dog.getWalks()[x] > 0){
                    //print out the dogs name and address and how many walks that dog is expected to get.
                    System.out.println(dog.getname() + " should be walked " + dog.getWalks()[x] + " time(s).");
                    System.out.println("Address: " + dog.getAddress() + "\n");
                    walks += dog.getWalks()[x]; //increment the counter by a value equal to the number of walks to be performed.
                }
            }
            //if the counter exceeds 5, call out a cautionary message.
            if(walks > 5){
                System.out.println(Integer.toString(walks) + " is too many dog walks, try to cut back, or be careful.");
            }else{ //otherwise  print out how many dog walks are expected.
                System.out.println("Total dog walks today: " + Integer.toString(walks));
            }
        }
    }
}