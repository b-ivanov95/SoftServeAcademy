package org.example.characters.army;

import org.example.characters.interfaces.IArmyWarrior;
import org.example.characters.base.Lancer;

public class ArmyLancer extends ArmyWarrior {

    private static final int PIERCING_POWER = 50;

    public ArmyLancer() {
        super(new Lancer());
    }

    @Override
    public void useArmyEffect(IArmyWarrior enemy) {
        IArmyWarrior enemyBehind = enemy.getNextWarrior();
        if (enemyBehind != null && this.isInCombat()) {
            int damageToNext = (enemy.getDamageReceived() / 2) * PIERCING_POWER / 100;
            enemyBehind.receiveDamage(damageToNext);
        }
        super.useArmyEffect(enemy);
    }
}

