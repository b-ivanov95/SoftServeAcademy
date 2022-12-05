package org.example.characters.base;

import org.example.characters.interfaces.IWarrior;
import org.example.items.IWeapon;

public class Berserker extends Warrior {

    private int healthExpended;
    private int passiveCooldown = 25;
    private static final int INVINCIBILITY_ROUNDS = 3;
    private int currentRound = 1;


    public Berserker() {
        super(60, 4);
    }

    @Override
    public void getHitBy(IWarrior warrior) {
        if (!isInvincible()) {
            super.getHitBy(warrior);
            healthExpended += getDamageReceived();
        } else {
            if (currentRound == INVINCIBILITY_ROUNDS) {
                currentRound = 1;
                healthExpended = 0;
            } else {
                currentRound++;
            }
        }
    }

    /**
     * Overridden version of equipWeapon method to apply passive cooldown reduction to applicable units
     * reduces the passive cooldown (damage taken to activate invincibility)
     *
     * @param weapon IWeapon item to be equipped and modify passive cooldown
     */

    @Override
    public void equipWeapon(IWeapon weapon) {
        super.equipWeapon(weapon);
        this.setPassiveCooldown(passiveCooldown- (int)(passiveCooldown * (weapon.getCooldownReduction()/100.0)));

    }
    private boolean isInvincible() {
        return this.healthExpended >= passiveCooldown;
    }

    public void setPassiveCooldown(int passiveCooldown) {
        this.passiveCooldown = passiveCooldown;
    }

}
