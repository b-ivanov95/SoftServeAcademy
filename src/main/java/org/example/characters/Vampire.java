package org.example.characters;

import org.example.characters.Interfaces.IWarrior;

public class Vampire extends Warrior{

    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40,4);
    }

    @Override
    public void hit(IWarrior warrior) {
        int damageDealt = warrior.getHitBy(this);
        double healingFactor = (double)VAMPIRISM/100;
        int finalHealing = (int) (damageDealt * healingFactor);
        this.setHealth(this.getHealth() + finalHealing);
    }
}
