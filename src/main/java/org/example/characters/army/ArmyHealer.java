package org.example.characters.army;

import org.example.characters.base.Healer;
import org.example.characters.interfaces.IArmyWarrior;
import org.example.characters.interfaces.IWarrior;

public class ArmyHealer extends ArmyWarrior {

    private static final int HEALING_AMOUNT = 2;

    public ArmyHealer() {
        super(new Healer());
    }

    @Override
    public void useArmyEffect(IArmyWarrior enemy) {
        if (this.getPreviousWarrior().isInCombat()) {
            this.heal(this.getPreviousWarrior());
        }
        super.useArmyEffect(enemy);
    }

    public void heal(IWarrior allyToHeal) {
        allyToHeal.setHealth(allyToHeal.getHealth() + HEALING_AMOUNT);
    }
}
