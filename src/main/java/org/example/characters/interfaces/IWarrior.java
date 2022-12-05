package org.example.characters.interfaces;

import org.example.items.IWeapon;

public interface IWarrior {
    void hit(IWarrior warrior);

    void getHitBy(IWarrior warrior);

    void receiveDamage(int damage);

    int getDamageReceived();

    void setHealth(int health);

    int getHealth();

    void equipWeapon(IWeapon weapon);

    default boolean isAlive() {
        return getHealth() > 0;
    }

    int getAttack();

    void setAttack(int attack);
}
