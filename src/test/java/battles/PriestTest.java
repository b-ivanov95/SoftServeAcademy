package battles;

import org.example.characters.Army;
import org.example.characters.WarriorType;
import org.example.game.Battle;
import org.example.items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriestTest {

    @Test
    @DisplayName("Priest vs a single Warrior expected False")
    void testPriestVsWarrior() {

        Army myArmy = new Army().addUnits(WarriorType.PRIEST, 1);
        Army enemyArmy = new Army().addUnits(WarriorType.WARRIOR, 1);

        Assertions.assertFalse(Battle.fight(myArmy,enemyArmy));
    }

    @Test
    @DisplayName("Priest vs 2 Warriors expected False")
    void testPriestVs2Warriors() {

        Army myArmy = new Army().addUnits(WarriorType.PRIEST, 1);
        Army enemyArmy = new Army().addUnits(WarriorType.WARRIOR, 2);

        Assertions.assertFalse(Battle.fight(myArmy,enemyArmy));
    }

    @Test
    @DisplayName("Priest vs 3 Warrior expected True")
    void testPriestVs3Warriors() {

        Army myArmy = new Army().addUnits(WarriorType.PRIEST, 1);
        Army enemyArmy = new Army().addUnits(WarriorType.WARRIOR, 3);

        Assertions.assertTrue(Battle.fight(myArmy,enemyArmy));
    }

    @Test
    @DisplayName("Priest Army with Items expected True")
    void testPriestArmyWithItems() {

        Army myArmy = new Army().addUnits(WarriorType.PRIEST, 2);
        myArmy.addUnits(WarriorType.VAMPIRE, 2);
        Army enemyArmy = new Army().addUnits(WarriorType.WARRIOR, 3);
        enemyArmy.addUnits(WarriorType.LANCER, 2);
        myArmy.equipWarriorAtPosition(0, WeaponType.SWIFTNESS_STAFF.getWeapon());
        myArmy.equipWarriorAtPosition(2,WeaponType.KATANA.getWeapon());
        enemyArmy.equipWarriorAtPosition(0,WeaponType.SWORD.getWeapon());
        enemyArmy.equipWarriorAtPosition(3,WeaponType.MAGIC_WAND.getWeapon());
        enemyArmy.equipWarriorAtPosition(3,WeaponType.SHIELD.getWeapon());


        Assertions.assertTrue(Battle.fight(myArmy,enemyArmy));
    }
}
