package demo;

import org.example.characters.*;
import org.example.game.Battle;

public class Main {
    public static void main(String[] args) {
        Army lancerArmy = new Army();
        Army second = new Army();
        lancerArmy.addUnits(() -> new ArmyWarrior(new Lancer()), 1);
        lancerArmy.addUnits(ArmyHealer::new,1);
        second.addUnits(() -> new ArmyWarrior(new Warrior()),1);
        second.addUnits(() -> new ArmyWarrior(new Warrior()),1);

        Battle.fight(lancerArmy,second);



    }


}
