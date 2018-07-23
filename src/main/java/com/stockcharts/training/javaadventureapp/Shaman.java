package com.stockcharts.training.javaadventureapp;

import java.util.Random;

public class Shaman extends Character {

    public Shaman() {
    }

    public void talk() {
        
        Random rand = new Random();
        int saying = rand.nextInt(10);

        print("\n\tThe Shaman looks at you from beneath her priestly\n"
                + "\tgarments and says,\n\n\t\"");

        switch (saying) {
            case 0:
                print("Beware the edge of the forest. Giants are afoot");
                break;
            case 1:
                print("I like wild flowers. They are very beautiful, and\n"
                    + "\ttheir restorative powers are merely a fringe benefit");
                break;
            case 2:
                print("Do not look at the outward appearance of things,\n"
                    + "\tcharacter should be judged by what is on the inside.");
                break;
            case 3:
                print("Good karma, bad karma, it's all the same..");
                break;
            case 4:
                print("I have a secret to tell...");
                break;
            case 5:
                print("To unlock the gate between worlds one needs a key");
                break;
            case 6:
                print("You are not from this world, I see that now");
                break;
            case 7:
                print("You did not yet know it traveler, but you must seek\n"
                    + "\tthe key of the fish god!");
                break;
            case 8:
                print("Sometimes I wish I'd never taken that vow of chastity");
                break;
            case 9:
                print("Do you think I'm pretty? Don't judge a book by its cover!");
                break;
            default:
                print("Uh oh, this should never happen..");
                break;
        }

        print("\".\n\n");

    }
    
    private void print(String s) {
        System.out.print(s);
    }

};
