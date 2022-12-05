package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;
import org.example.items.IWeapon;

public class Defender extends Warrior {

    private int defense = 2;

    public Defender() {
        super(60, 3);
    }

    @Override
    public void getHitBy(IWarrior warrior) {
        if (warrior.isAlive() && warrior.getAttack() > getDefense()) {
            receiveDamage(warrior.getAttack() - getDefense());
        }
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        super.equipWeapon(weapon);
        this.defense = defense + weapon.getDefenseBonus();
    }

    public int getDefense() {
        return defense;
    }
}
