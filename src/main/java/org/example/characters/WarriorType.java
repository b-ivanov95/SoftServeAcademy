package org.example.characters;


import org.example.characters.army.ArmyHealer;
import org.example.characters.army.ArmyLancer;
import org.example.characters.army.ArmyPriest;
import org.example.characters.army.ArmyWarrior;
import org.example.characters.base.*;

public enum WarriorType {

    WARRIOR {
        @Override
        public Warrior getInstance() {
            return new Warrior();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyWarrior(new Warrior());
        }

    },
    KNIGHT {
        @Override
        public Warrior getInstance() {
            return new Warrior(50, 7);
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyWarrior(new Warrior(50, 7));
        }

    },
    DEFENDER {
        @Override
        public Warrior getInstance() {
            return new Defender();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyWarrior(new Defender());
        }

    },
    VAMPIRE {
        @Override
        public Warrior getInstance() {
            return new Vampire();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyWarrior(new Vampire());
        }

    },
    LANCER {
        @Override
        public Warrior getInstance() {
            return new Lancer();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyLancer();
        }

    },
    HEALER {
        @Override
        public Warrior getInstance() {
            return new Healer();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyHealer();
        }

    },
    BERSERKER {

        @Override
        public Warrior getInstance() {
            return new Berserker();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyWarrior(new Berserker());
        }
    },
    PRIEST {

        @Override
        public Warrior getInstance() {
            return new Priest();
        }

        @Override
        public ArmyWarrior getArmyInstance() {
            return new ArmyPriest();
        }
    };

    public abstract Warrior getInstance();

    public abstract ArmyWarrior getArmyInstance();


}
