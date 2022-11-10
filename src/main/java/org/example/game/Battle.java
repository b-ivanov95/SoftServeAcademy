package org.example.game;

import org.example.characters.Warrior;

public class Battle {
    public static boolean fight(Warrior w1, Warrior w2) {

        while (w1.isAlive() && w2.isAlive()) {
            w1.dealDamageTo(w2);
            w2.dealDamageTo(w1);
        }
        return w1.isAlive();

    }

    private Battle() {}
}
