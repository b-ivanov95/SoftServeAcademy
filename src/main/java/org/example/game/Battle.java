package org.example.game;

import org.example.characters.Army;
import org.example.characters.interfaces.IWarrior;

import java.util.logging.Logger;

public class Battle {

    /**
     *
     *
     * @param w1 first warrior to attach in the 1v1 battle
     * @param w2 always attacks second in the 1v1 battle
     * @return true if the first warrior is alive at the end of the battle and false if not
     */
    public static boolean fight(IWarrior w1, IWarrior w2) {

        while (w1.isAlive() && w2.isAlive()) {
            w1.hit(w2);
            w2.hit(w1);
        }
        return w1.isAlive();

    }

    /**
     * Fight method for battle between two armies
     *
     * @param army1 first army to attack
     * @param army2 second army to attack
     * @return true if army1 has remaining troops after army2 has been depleted and false if not
     */

    public static boolean fight(Army army1, Army army2) {
        while(army1.hasNext() && army2.hasNext()) {
            army1.hit(army2);
            army2.hit(army1);
        }
        return army1.hasNext();
    }

    /**
     * Fight method for straight battle between two armies -
     * Each troop fights the corresponding index troop from the opposing army
     *
     * @param army1 units from this army always attack first in the 1v1 battles
     * @param army2 units from this army always attack second in the 1v1 battles
     * @return true if army1 has remaining troops after army2 has been depleted and false if not
     */
    public static boolean straightFight(Army army1, Army army2) {
        while(army1.hasNext() && army2.hasNext()) {
            var currentW1 = army1.next();
            var currentW2 = army2.next();
            while(currentW1  != null && currentW2 != null) {
                fight(currentW1,currentW2);
                currentW1 = currentW1.getNextWarrior();
                currentW2 = currentW2.getNextWarrior();
            }
            army1.removeDeadWarriors();
            army2.removeDeadWarriors();
        }
        return army1.hasNext();
    }

    private Battle() {}
}
