package org.example.characters.interfaces;

public interface IWarrior {
    void hit(IWarrior warrior);

    void getHitBy(IWarrior warrior);

    void receiveDamage(int damage);

    int getDamageReceived();

    void setHealth(int health);

    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }

    int getAttack();
}
