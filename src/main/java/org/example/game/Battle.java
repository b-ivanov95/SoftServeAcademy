package org.example.game;

import org.example.characters.Army;
import org.example.characters.interfaces.IWarrior;

public class Battle {
    public static boolean fight(IWarrior w1, IWarrior w2) {

        while (w1.isAlive() && w2.isAlive()) {
            w1.hit(w2);
            w2.hit(w1);
        }
        return w1.isAlive();

    }

    public static boolean fight(Army army1, Army army2) {
        while(army1.hasNext() && army2.hasNext()) {
            army1.hit(army2);
            army2.hit(army1);
        }
        return army1.hasNext();
    }

    public static boolean straightFight(Army army1, Army army2) {
        while(army1.hasNext() && army2.hasNext()) {
            var currentW1 = army1.next();
            var currentW2 = army2.next();
            while(currentW1  != null && currentW2 != null) {
                fight(currentW1,currentW2);
                currentW1 = currentW1.getNextWarrior();
                currentW2 = currentW2.getNextWarrior();
            }
            army1.burnDeadWarriors();
            army2.burnDeadWarriors();
        }
        return army1.hasNext();
    }

    private Battle() {}
}
