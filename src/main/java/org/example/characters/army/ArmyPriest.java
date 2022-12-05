package org.example.characters.army;

import org.example.characters.Army;
import org.example.characters.base.Priest;
import org.example.items.IWeapon;

public class ArmyPriest extends ArmyWarrior {

    private int passiveCooldown = 5;

    private int roundsInBattle = 0;

    public ArmyPriest() {
        super(new Priest());
    }

    /**
     * Overriden version of the useArmyEffect applying the effect every N rounds in battle depending on passiveCooldown
     * Removes the head for the enemy army and reassigns it to the second position of the Ally army
     * @param army - enemy army to apply passive to
     */
    @Override
    public void useArmyEffect(Army army) {
        if (isInCombat()) {
            if (roundsInBattle == passiveCooldown) {
                var stolenWarrior = army.removeHead();
                if(stolenWarrior.getNextWarrior() == null) {
                    super.useArmyEffect(army);
                    return;
                }
                ArmyWarrior newNext = null;
                if (this.getNextWarrior() != null) {
                    newNext = this.getNextWarrior();
                    this.getNextWarrior().setPreviousWarrior(stolenWarrior);
                }
                this.setNextWarrior(stolenWarrior);
                stolenWarrior.setNextWarrior(newNext);
                stolenWarrior.setPreviousWarrior(this);
                stolenWarrior.setInCombat();
                army.next().setInCombat();
                roundsInBattle = 1;
            }
            roundsInBattle++;
        }
        super.useArmyEffect(army);
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        super.equipWeapon(weapon);
        this.setPassiveCooldown(passiveCooldown - (int) (passiveCooldown * (weapon.getCooldownReduction() / 100.0)));
    }

    public void setPassiveCooldown(int passiveCooldown) {
        this.passiveCooldown = passiveCooldown;
    }
}
