package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;

public class Defender extends Warrior {

    private static final int DEFENCE = 2;

    public Defender() {
        super(60, 3);
    }

    @Override
    public void getHitBy(IWarrior warrior) {
        if (warrior.isAlive() && warrior.getAttack() > Defender.DEFENCE) {
            receiveDamage(warrior.getAttack() - Defender.DEFENCE);
        }
    }

    public int getDefense() {
        return DEFENCE;
    }
}
