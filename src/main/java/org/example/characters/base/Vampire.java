package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;
import org.example.items.IWeapon;

public class Vampire extends Warrior{

    private int vampirism = 50;

    public Vampire() {
        super(40,4);
    }

    @Override
    public void hit(IWarrior warrior) {
        warrior.getHitBy(this);
        int damageDealt = warrior.getDamageReceived();
        double healingFactor = vampirism * 1.0 / 100.0;
        int finalHealing = (int) (damageDealt * healingFactor);
        this.setHealth(this.getHealth() + finalHealing);
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        super.equipWeapon(weapon);
        setVampirism(this.vampirism + weapon.getVampirismBonus());
    }
    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }
}
