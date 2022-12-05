package org.example.characters.army;

import org.example.characters.Army;
import org.example.characters.base.Healer;
import org.example.characters.interfaces.IArmyWarrior;
import org.example.characters.interfaces.IWarrior;
import org.example.items.IWeapon;

public class ArmyHealer extends ArmyWarrior {

    private int healingPower = 2;

    public ArmyHealer() {
        super(new Healer());
    }

    @Override
    public void useArmyEffect(Army army) {
        if (this.getPreviousWarrior() != null && this.getPreviousWarrior().isInCombat()) {
            this.heal(this.getPreviousWarrior());
        }
        super.useArmyEffect(army);
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        super.equipWeapon(weapon);
        setHealingPower(healingPower + weapon.getHealPowerBonus());
    }

    public void heal(IWarrior allyToHeal) {
        allyToHeal.setHealth(allyToHeal.getHealth() + healingPower );
    }
    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }
}
