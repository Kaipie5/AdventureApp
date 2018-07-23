package com.stockcharts.training.javaadventureapp;

public class Monster {

    private int hitPoints;
    private int attackPower;
    private int defense;
    private String name;

    public Monster() {
        hitPoints = 25;
        attackPower = 1;
        defense = 1;
        name = "Monster";
    }

    //Public Accessor Methods
    public void damage(int hp) {
        hitPoints -= hp;
        if (hitPoints < 0)
            hitPoints = 0;
    }

    public int getHealth() {
        return hitPoints;
    }

    public int getAttack() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

}
