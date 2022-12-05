package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;
import org.example.items.IWeapon;

import java.util.ArrayList;
import java.util.Collection;

public class Warrior implements IWarrior {
    private int health = 50;
    private int startHealth = 50;
    private int attack = 5;
    private int damageReceived;

    protected Collection<IWeapon> inventory = new ArrayList<>();

    public Warrior() {}

    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
        this.startHealth = health;
    }

    public void getHitBy(IWarrior warrior) {
        if (warrior.isAlive()) {
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

    @Override
    public void equipWeapon(IWeapon weapon) {
        inventory.add(weapon);
        setHealth(this.health + weapon.getHealthBonus());
        setAttack(this.attack + weapon.getAttackBonus());
    }

    public void setHealth(int health) {
        if (this.inventory.isEmpty()) {
            this.health = Math.min(health, this.startHealth);
        } else {
            int maxHealth = startHealth + inventory.stream().mapToInt(IWeapon::getHealthBonus).sum();
            this.health = Math.min(maxHealth,health);
        }
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

}
