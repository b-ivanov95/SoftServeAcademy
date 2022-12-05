package demo;

import org.example.characters.Army;
import org.example.characters.WarriorType;
import org.example.characters.base.*;
import org.example.characters.interfaces.IWarrior;
import org.example.game.Battle;
import org.example.items.IWeapon;
import org.example.items.WeaponType;

public class Main {
    public static void main(String[] args) {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.BERSERKER, 1);
        myArmy.addUnits(WarriorType.HEALER, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 3);
        Battle.fight(myArmy,enemyArmy);
    }

}


