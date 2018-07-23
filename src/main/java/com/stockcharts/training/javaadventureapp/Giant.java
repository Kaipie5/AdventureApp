package com.stockcharts.training.javaadventureapp;

import java.util.Random;

public class Giant extends Monster {

    public Giant() {
    }

    public void Attack(Character Opponent) {

        //Since we are calling members of the base class, we use the "this" pointer.
        int damage = 0;

        System.out.print("\n\n\t***************** Giant Attacks! *****************\n"
                + "\tBefore Attack:    Giant Hit = " + getHealth() + "      "
                + Opponent.getName() + " Hit = " + Opponent.getHealth()
                + "\n");

        Random rand = new Random();
        damage = (rand.nextInt(10) + 1) + getAttack();
        
        if (damage > Opponent.getDefense()) {
            damage -= Opponent.getDefense();
        } else {
            damage = 0;
        }
        if (Opponent.hasFullBodyArmor()) {
            if (damage > 4) {
                damage -= 4;
            }
        }
        if (Opponent.hasChainMail()) {
            if (damage > 2) {
                damage -= 2;
            }
        }

        Opponent.damage(damage);
        
        System.out.print("\tAfter Attack:     Giant Hit = " + getHealth() + "      "
                + Opponent.getName() + " Hit = " + Opponent.getHealth()
                + "\n\n");

        try { Thread.sleep(3000); } catch (Exception e) {}
    }

}
