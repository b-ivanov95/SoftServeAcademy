package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;

public class Vampire extends Warrior{

    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40,4);
    }

    @Override
    public void hit(IWarrior warrior) {
        warrior.getHitBy(this);
        int damageDealt = warrior.getDamageReceived();
        double healingFactor = (double)VAMPIRISM/100;
        int finalHealing = (int) (damageDealt * healingFactor);
        this.setHealth(this.getHealth() + finalHealing);
    }
}
