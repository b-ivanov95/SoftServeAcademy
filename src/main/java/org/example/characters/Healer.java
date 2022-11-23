package org.example.characters;

import org.example.characters.Interfaces.IArmyWarrior;
import org.example.characters.Interfaces.IWarrior;

public class Healer extends Warrior  {

    private static final int HEALING_AMOUNT = 2;

    public Healer () {
        super(60,0);
    }
    public void heal(IWarrior allyToHeal) {
        allyToHeal.setHealth(allyToHeal.getHealth() + HEALING_AMOUNT);
    }
    @Override
    public void hit(IWarrior warrior) {
        this.heal(warrior);
    }


}
