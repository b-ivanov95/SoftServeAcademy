package org.example.items;

import lombok.Getter;

import static org.example.items.IWeapon.builder;

public enum WeaponType {


    SWORD(builder()
            .withHealth(5)
            .withAttack(2)
            .build()),
    SHIELD(builder()
            .withHealth(20)
            .withAttack(-1)
            .withDefense(2)
            .build()),
    GREAT_AXE(builder()
            .withHealth(-15)
            .withAttack(5)
            .withDefense(-2)
            .withVampirism(10)
            .build()),
    KATANA(builder()
            .withHealth(-20)
            .withAttack(6)
            .withDefense(-5)
            .withVampirism(50)
            .build()),
    MAGIC_WAND(builder()
            .withHealth(30)
            .withAttack(3)
            .withHealPower(3)
            .build()),
    SWIFTNESS_STAFF(builder()
            .withHealth(-10)
            .withAttack(2)
            .withCooldownReduction(25)
            .build());
    @Getter
    private IWeapon weapon;

    WeaponType(IWeapon weapon) {
        this.weapon = weapon;
    }
}
