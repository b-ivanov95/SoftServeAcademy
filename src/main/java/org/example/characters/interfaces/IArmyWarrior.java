package org.example.characters.interfaces;

import org.example.characters.Army;

public interface IArmyWarrior extends IWarrior {

    boolean isInCombat();

     void setInCombat();

    IWarrior getWarrior();

    IArmyWarrior getNextWarrior();

    IArmyWarrior getPreviousWarrior();

    void useArmyEffect(Army army);
}
