package org.example.characters.interfaces;

public interface IArmyWarrior extends IWarrior {

    boolean isInCombat();

    IWarrior getWarrior();

    IArmyWarrior getNextWarrior();

    IArmyWarrior getPreviousWarrior();

    void useArmyEffect(IArmyWarrior enemy);
}
