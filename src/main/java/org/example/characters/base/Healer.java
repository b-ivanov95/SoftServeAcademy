package org.example.characters.base;

import org.example.characters.army.ArmyHealer;
import org.example.characters.interfaces.IWarrior;

public class Healer extends Warrior  {

    public Healer () {
        super(60,0);
    }

    @Override
    public void hit(IWarrior enemy) {
        if((enemy instanceof Healer || enemy instanceof ArmyHealer) && (this.getAttack() <= 0 && enemy.getAttack() <= 0)) {
            throw new IllegalStateException("Cannot fight 2 Healers! Endless fight detected...");
        }
        super.hit(enemy);
    }



}
