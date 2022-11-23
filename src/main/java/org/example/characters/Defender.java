package org.example.characters;

import org.example.characters.Interfaces.IWarrior;

public class Defender extends Warrior {

    private static final int DEFENCE = 2;

    @Override
    public int getHitBy(IWarrior warrior) {
        if(warrior.isAlive() && warrior.getAttack() > Defender.DEFENCE) {
                receiveDamage(warrior.getAttack() - Defender.DEFENCE);
        }
        return warrior.getAttack() - Defender.DEFENCE;
    }

    public Defender() {
        super(60,3);
    }

    public int getDefense() {
        return DEFENCE;
    }
}
