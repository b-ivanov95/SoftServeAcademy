package org.example.items;


import lombok.Getter;

public interface IWeapon {

    int getHealthBonus();

    int getDefenseBonus();

    int getAttackBonus();

    int getVampirismBonus();

    int getHealPowerBonus();

    int getCooldownReduction();

    static WeaponBuilder builder() {
        return new WeaponBuilder();
    }

    class WeaponBuilder {

        int health;
        int attack;
        int defense;
        int vampirism;
        int healPower;
        int cooldownReduction;

        public WeaponBuilder withHealth(int health) {
            this.health = health;
            return this;
        }

        public WeaponBuilder withAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public WeaponBuilder withDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public WeaponBuilder withVampirism(int vampirism) {
            this.vampirism = vampirism;
            return this;
        }

        public WeaponBuilder withHealPower(int healPower) {
            this.healPower = healPower;
            return this;
        }

        public WeaponBuilder withCooldownReduction(int cooldownReduction) {
            this.cooldownReduction = cooldownReduction;
            return this;
        }

        public IWeapon build() {
            return new IWeapon() {
                @Override
                public int getHealthBonus() {
                    return health;
                }

                @Override
                public int getDefenseBonus() {
                    return defense;
                }

                @Override
                public int getAttackBonus() {
                    return attack;
                }

                @Override
                public int getVampirismBonus() {
                    return vampirism;
                }

                @Override
                public int getHealPowerBonus() {
                    return healPower;
                }

                @Override
                public int getCooldownReduction() {
                    return cooldownReduction;
                }

            };
        }


    }


}
