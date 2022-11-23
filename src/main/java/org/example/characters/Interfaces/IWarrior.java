package org.example.characters.Interfaces;

public interface IWarrior {
    void hit(IWarrior warrior);
    void receiveDamage(int damage);
    void setHealth(int health);
    int getHealth();
    int getHitBy(IWarrior warrior);
    default boolean isAlive() {
        return  getHealth() > 0;
    }

    int getAttack();
}
