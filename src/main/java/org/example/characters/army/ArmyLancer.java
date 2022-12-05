package org.example.characters.army;

import org.example.characters.Army;
import org.example.characters.interfaces.IArmyWarrior;
import org.example.characters.base.Lancer;

public class ArmyLancer extends ArmyWarrior {

    private static final int PIERCING_POWER = 50;

    public ArmyLancer() {
        super(new Lancer());
    }

    @Override
    public void useArmyEffect(Army army) {
        IArmyWarrior enemyBehind = army.getHead().getNextWarrior();
        if (enemyBehind != null && this.isInCombat()) {
            int damageToNext = (army.getHead().getDamageReceived()) * PIERCING_POWER / 100;
            enemyBehind.receiveDamage(damageToNext);
        }
        super.useArmyEffect(army);
    }
}

