package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;

public class Warrior implements IWarrior {

    private int health;

    private int maxHealth;
    private final int attack;
    private int damageReceived;

    public Warrior() {
        this.health = 50;
        this.maxHealth = 50;
        this.attack = 5;
    }

    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
        this.maxHealth = health;
    }

    public boolean isAlive() {
        return  health > 0;
    }

    public void getHitBy(IWarrior warrior) {
        if(warrior.isAlive()) {
           receiveDamage(warrior.getAttack());
        }
    }

    @Override
    public int getDamageReceived() {
        return damageReceived;
    }

    public void receiveDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        this.damageReceived = damage;
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
