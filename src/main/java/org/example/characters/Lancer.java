package org.example.characters;

import org.example.characters.Interfaces.IWarrior;
import org.example.characters.Interfaces.IArmyWarrior;

public class Lancer extends Warrior{

    private static final int PIERCING_POWER = 50;

    public Lancer () {
        super(50,6);
    }

    @Override
    public void hit(IWarrior opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        if(opponent instanceof IArmyWarrior opponentWithNext) {
               IWarrior nextOpponent = opponentWithNext.getNextWarrior();
               if(nextOpponent != null) {
                   int healthAfter = opponent.getHealth();
                   int damageDealt = healthBefore - healthAfter;
                   int damageToNext = damageDealt * PIERCING_POWER / 100;
                   nextOpponent.receiveDamage(damageToNext);
               }
        }
    }
}
