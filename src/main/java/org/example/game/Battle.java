package org.example.game;

import org.example.characters.Army;
import org.example.characters.Warrior;

public class Battle {
    public static boolean fight(Warrior w1, Warrior w2) {

        while (w1.isAlive() && w2.isAlive()) {
            w2.receiveDamageFrom(w1);
            w1.receiveDamageFrom(w2);
        }
        return w1.isAlive();

    }

    public static boolean fight(Army army1, Army army2) {
        while(army1.iterator().hasNext() && army2.iterator().hasNext()) {
            Warrior w1 = army1.iterator().next();
            Warrior w2 = army2.iterator().next();
            fight(w1, w2);

        }
        return army1.iterator().hasNext();
    }

    private Battle() {}
}
