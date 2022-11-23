package org.example.characters;

import org.example.characters.Interfaces.IWarrior;

public class ArmyHealer extends ArmyWarrior {

    public ArmyHealer() {
        super(new Healer());
    }
    @Override
    public void hit(IWarrior warrior) {
        if (getPreviousWarrior() != null && getPreviousWarrior().isInCombat() ) {
            this.getWarrior().hit(getPreviousWarrior());
        }

    }
}
