package org.example.characters;

import org.example.characters.Interfaces.IArmyWarrior;
import org.example.characters.Interfaces.IWarrior;

public class ArmyWarrior implements IArmyWarrior {

    private IWarrior warrior;
    private ArmyWarrior nextWarrior;
    private ArmyWarrior previousWarrior;
    private boolean inCombat;

    public void setInCombat() {
        this.inCombat = !this.inCombat;
    }

    public void setNextWarrior(ArmyWarrior nextWarrior) {
        this.nextWarrior = nextWarrior;
    }

    public void setPreviousWarrior(ArmyWarrior previousWarrior) {
        this.previousWarrior = previousWarrior;
    }

    public ArmyWarrior(IWarrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public boolean isInCombat() {
        return inCombat;
    }

    @Override
    public IWarrior getWarrior() {
        return warrior;
    }

    @Override
    public ArmyWarrior getNextWarrior() {
        return this.nextWarrior;
    }

    @Override
    public ArmyWarrior getPreviousWarrior() {
        return this.previousWarrior;
    }

    @Override
    public void hit(IWarrior warrior) {
        if(this.inCombat) {
            this.warrior.hit(warrior);
        }
    }

    @Override
    public void receiveDamage(int damage) {
        this.warrior.receiveDamage(damage);
    }

    @Override
    public void setHealth(int health) {
        this.warrior.setHealth(health);
    }

    @Override
    public int getHealth() {
        return this.warrior.getHealth();
    }

    @Override
    public int getHitBy(IWarrior warrior) {
        return this.warrior.getHitBy(warrior);
    }

    @Override
    public int getAttack() {
        return this.warrior.getAttack();
    }
}
