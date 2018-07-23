package com.stockcharts.training.javaadventureapp;

import java.util.*;

public class Character {

    // Character Attributes
    private int hitPoints;
    private int attackPower;
    private int defense;
    private int level;
    private Location location;
    private String name;
    private int score;

    // Inventory Items
    private boolean hasDagger;
    private boolean hasSword;
    private boolean hasLongBow;
    private boolean hasChainMail;
    private boolean hasFullBodyArmor;
    private boolean hasFishKey;
    private int numHealingPotions;

    private boolean usingDagger;
    private boolean usingSword;
    private boolean usingLongBow;
    
    private Scanner console = new Scanner(System.in);

    public Character() {
        hitPoints = 20;
        attackPower = 1;
        defense = 2;
        level = 0;
        score = 0;

        hasDagger = true;
        hasSword = false;
        hasLongBow = false;
        hasChainMail = true;
        hasFullBodyArmor = false;
        numHealingPotions = 2;
        hasFishKey = false;
    }

    public void showStatistics() {
        System.out.print("\n\t*********************** Stats ***********************\n"
                + "\t" + name + ":    " + "Hit: " + hitPoints
                + "    " + "Attack: " + attackPower + "    "
                + "Defense: " + defense + "\n"
                + "\t*****************************************************");
    }

    public void showInventory() {
        System.out.print("\n\n\t\t\t***********************************\n"
                + "\t\t\t*        Current Inventory:       *\n"
                + "\t\t\t***********************************\n");
        System.out.print("\t\t\t*                                 *\n");

        if (hasDagger) {
            System.out.print("\t\t\t*  Dagger (+ 2 Attack)            *\n");
        }

        if (hasSword) {
            System.out.print("\t\t\t*  Sword (+ 4 Attack)             *\n");
        }

        if (hasLongBow) {
            System.out.print("\t\t\t*  Long Bow (+2 over Distance)    *\n");
        }

        if (hasChainMail) {
            System.out.print("\t\t\t*  Chain Mail (+ 2 Defense)       *\n");
        }

        if (hasFullBodyArmor) {
            System.out.print("\t\t\t*  Full Body Armor (+4 Defense)   *\n");
        }

        if (numHealingPotions > 0) {
            System.out.print("\t\t\t*  Healing Potion (+20HP)  Amt: " + numHealingPotions + " *\n");
        }

        if (hasFishKey) {
            System.out.print("\t\t\t*  Fish Key (Access to Objects)   *\n");
        }

        if (hasDagger == false && hasSword == false && hasLongBow == false
                && hasChainMail == false && hasFullBodyArmor == false
                && numHealingPotions == 0 && hasFishKey == false) {
            System.out.print("\t\t\t*   How sad, absolute nothing!    *\n");
        }

        System.out.print("\t\t\t*                                 *\n");
        System.out.print("\t\t\t***********************************\n");
        System.out.print("\n");
    }

    
    public void Attack(Monster Opponent) {

        Random rand = new Random();
        int damage = (rand.nextInt(10) + 1) + attackPower;

        if (hasDagger && usingDagger) {
            System.out.print("\n\t" + name + " stabs with the dagger!\n");
            damage += 2;
        } else if (hasSword && usingSword) {
            System.out.print("\n\t" + name + " swings the sword!\n");
            damage += 4;
        } else if (hasLongBow && usingLongBow) {
            System.out.print("\n\t" + name + " releases the String of the longbow!");
            damage += 2;
        } else {
            System.out.print("\n\t" + name + " engages the oponent in brutal hand to hand combat!\n");
        }

        System.out.print("\n\n\t***************** " + name + " Attacks! *****************\n"
                + "\tBefore Attack:    " + name + " Hit = " + hitPoints + "   "
                + "    Opponent Hit = " + Opponent.getHealth()
                + "\n");

        if (damage > Opponent.getDefense()) {
            damage -= Opponent.getDefense();
        } else {
            damage = 0;
        }

        Opponent.damage(damage);

        System.out.print("\tAfter Attack:     " + name + " Hit = " + hitPoints
                + "   " + "    Opponent Hit = " + Opponent.getHealth() + "\n");

        try { Thread.sleep(3000); } catch (Exception e) {}
    }

    
    public void askPlayerForName() {
        System.out.print("\n\n\tWhat be your true name, player?\t");
        name = console.nextLine();

        System.out.print("\n\tHenceforth, you shall be called \"" + name + " the Moist\"!\n\n\t");

        waitForKeypress();
    }

    
    public void drinkHealingPotion() {
        if (numHealingPotions > 0) {
            hitPoints += hitPoints;
            showStatistics();
            numHealingPotions--;
        } else {
            System.out.print("\n\tWishful thinking. You don't have any healing potions.\n");
        }
    }

    private void waitForKeypress() {
        System.out.print("\n\tPaused. Press ENTER to continue.");
        console.nextLine();
    }

    //Inventory Accessor Methods
    public boolean hasDagger() {
        return hasDagger;
    }

    public boolean hasSword() {
        return hasSword;
    }

    public boolean hasLongbow() {
        return hasLongBow;
    }

    public boolean hasChainMail() {
        return hasChainMail;
    }

    public boolean hasFullBodyArmor() {
        return hasFullBodyArmor;
    }

    public int numHealingPotions() {
        return numHealingPotions;
    }

    public boolean hasFishKey() {
        return hasFishKey;
    }

    public void addDagger() {
        this.hasDagger = true;
    }

    public void addSword() {
        this.hasSword = true;
    }

    public void addLongBow() {
        hasLongBow = true;
    }

    public void addChainMail() {
        hasChainMail = true;
    }

    public void addFullBodyArmor() {
        hasFullBodyArmor = true;
    }

    public void addHealingPotion() {
        numHealingPotions++;
    }

    public void addFishKey() {
        hasFishKey = true;
    }

    public void equipDagger() {
        usingDagger = hasDagger;
        usingSword = false;
        usingLongBow = false;
    }

    public void equipSword() {
        usingDagger = false;
        usingSword = hasSword;
        usingLongBow = false;
    }

    public void equipLongBow() {
        usingDagger = false;
        usingSword = false;
        usingLongBow = hasLongBow;
    }
    
    public void equipHandToHand() {
        usingDagger = false;
        usingSword = false;
        usingLongBow = false;
    }

    public void damage(int hp) {
        hitPoints -= hp;
        if (hitPoints < 0)
            hitPoints = 0;
    }

    public void incrementAttackPower() {
        this.attackPower++;
    }

    public void incrementDefense() {
        this.defense++;
    }

    public void incrementLevel() {
        this.level++;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

}
