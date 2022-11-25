package org.example.characters;

import org.example.characters.Interfaces.IWarrior;

public class Warrior implements IWarrior {

    private int health;

    private int maxHealth;
    private final int attack;

    public Warrior() {
        this.health = 50;
        this.maxHealth = 50;
        this.attack = 5;
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
        this.maxHealth = health;
    }

    public boolean isAlive() {
        return  health > 0;
    }

    public int getHitBy(IWarrior warrior) {
        if(warrior.isAlive()) {
           receiveDamage(warrior.getAttack());
        }
        return warrior.getAttack();
    }

    public void receiveDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public void hit(IWarrior warrior) {
        warrior.getHitBy(this);
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health,this.maxHealth);
    }

    public int getAttack() {
        return attack;
    }

}
