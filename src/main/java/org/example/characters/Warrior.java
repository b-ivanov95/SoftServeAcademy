package org.example.characters;

public class Warrior {

    private int health;
    private final int attack;

    public Warrior() {
        this.health = 50;
        this.attack = 5;
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public boolean isAlive() {
        return  health > 0;
    }

    public void receiveDamageFrom(Warrior warrior) {
        if(warrior.isAlive()) {
           this.setHealth(this.getHealth() - warrior.getAttack());
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

}
