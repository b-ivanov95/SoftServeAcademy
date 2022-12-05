package org.example.characters.army;

import org.example.characters.Army;
import org.example.characters.base.Warrior;
import org.example.characters.interfaces.IArmyWarrior;
import org.example.characters.interfaces.IWarrior;
import org.example.items.IWeapon;

public class ArmyWarrior implements IArmyWarrior {

    private IWarrior warrior;
    private ArmyWarrior nextWarrior;
    private ArmyWarrior previousWarrior;
    private boolean inCombat;
    @Override
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
    public void useArmyEffect(Army army) {
        if (this.getNextWarrior() != null) {
            this.getNextWarrior().useArmyEffect(army);
        }
    }

    @Override
    public void hit(IWarrior enemy) {
        this.warrior.hit(enemy);
    }

    @Override
    public void receiveDamage(int damage) {
        this.warrior.receiveDamage(damage);
    }

    @Override
    public int getDamageReceived() {
        return warrior.getDamageReceived();
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
    public void equipWeapon(IWeapon weapon) {
        this.warrior.equipWeapon(weapon);
    }

    @Override
    public void getHitBy(IWarrior warrior) {
        this.warrior.getHitBy(warrior);
    }

    @Override
    public int getAttack() {
        return this.warrior.getAttack();
    }

    @Override
    public void setAttack(int attack) {
        this.warrior.setAttack(attack);
    }
}
