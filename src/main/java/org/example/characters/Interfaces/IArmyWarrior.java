package org.example.characters.Interfaces;

public interface IArmyWarrior extends IWarrior {

    boolean isInCombat();
    IWarrior getWarrior();
    IArmyWarrior getNextWarrior();

    IArmyWarrior getPreviousWarrior();
}
