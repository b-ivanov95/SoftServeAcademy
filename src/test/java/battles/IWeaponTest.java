package battles;

import characters.Rookie;
import org.example.characters.Army;
import org.example.characters.WarriorType;
import org.example.characters.base.*;
import org.example.characters.interfaces.IWarrior;
import org.example.game.Battle;
import org.example.items.IWeapon;
import org.example.items.WeaponType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IWeaponTest {

    @Test
    @DisplayName("1. ")
    void one() {
        IWarrior warrior = new Warrior();
        warrior.equipWeapon(WeaponType.SWORD.getWeapon());

        Warrior vampire = new Vampire();
        vampire.equipWeapon(WeaponType.MAGIC_WAND.getWeapon());

        assertFalse(Battle.fight(warrior, vampire));
    }

    @Test
    @DisplayName("2. ")
    void two() {
        IWarrior warrior1 = new Defender();
        warrior1.equipWeapon(WeaponType.SHIELD.getWeapon());

        IWarrior warrior2 = new Lancer();
        warrior2.equipWeapon(WeaponType.GREAT_AXE.getWeapon());

        assertFalse(Battle.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("3. ")
    void three() {
        Warrior warrior1 = new Healer();
        warrior1.equipWeapon(WeaponType.MAGIC_WAND.getWeapon());

        Warrior warrior2 = new Knight();
        warrior2.equipWeapon(WeaponType.KATANA.getWeapon());

        assertFalse(Battle.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("4.")
    void four() {
        Warrior warrior1 = new Defender();
        warrior1.equipWeapon(WeaponType.SHIELD.getWeapon());
        warrior1.equipWeapon(WeaponType.MAGIC_WAND.getWeapon());

        Warrior warrior2 = new Vampire();
        warrior2.equipWeapon(WeaponType.SHIELD.getWeapon());
        warrior2.equipWeapon(WeaponType.KATANA.getWeapon());

        assertFalse(Battle.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("5.")
    void five() {
        IWeapon weapon_1 = WeaponType.MAGIC_WAND.getWeapon();
        IWeapon weapon_2 = WeaponType.GREAT_AXE.getWeapon();

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.KNIGHT, 1);
        myArmy.addUnits(WarriorType.LANCER, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.VAMPIRE, 1);
        enemyArmy.addUnits(WarriorType.HEALER, 1);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("6.")
    void six() {
        IWeapon weapon_1 = WeaponType.SWORD.getWeapon();
        IWeapon weapon_2 = WeaponType.GREAT_AXE.getWeapon();

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.DEFENDER, 1);
        myArmy.addUnits(WarriorType.WARRIOR, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.KNIGHT, 1);
        enemyArmy.addUnits(WarriorType.HEALER, 1);

        myArmy.equipWarriorAtPosition(0, weapon_2);
        myArmy.equipWarriorAtPosition(1, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_1);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("7. ")
    void seven() {
        IWeapon weapon_1 = WeaponType.KATANA.getWeapon();
        IWeapon weapon_2 = WeaponType.SHIELD.getWeapon();

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.DEFENDER, 2);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.KNIGHT, 1);
        enemyArmy.addUnits(WarriorType.VAMPIRE, 1);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_1);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }



    @Test
    @DisplayName("8. ")
    void eight() {
        IWeapon weapon_1 = WeaponType.KATANA.getWeapon();
        IWeapon weapon_2 = WeaponType.SHIELD.getWeapon();

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.VAMPIRE, 2);
        myArmy.addUnits(WarriorType.WARRIOR, 2);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 1);
        enemyArmy.addUnits(WarriorType.DEFENDER, 2);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);
        myArmy.equipWarriorAtPosition(2, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);
        enemyArmy.equipWarriorAtPosition(2, weapon_2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("9. ")
    void nine() {
        IWeapon weapon_1 = WeaponType.SWORD.getWeapon();
        IWeapon weapon_2 = WeaponType.GREAT_AXE.getWeapon();

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.VAMPIRE, 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 1);
        enemyArmy.addUnits(WarriorType.DEFENDER, 1);

        myArmy.equipWarriorAtPosition(0, weapon_2);
        myArmy.equipWarriorAtPosition(1, weapon_2);
        myArmy.equipWarriorAtPosition(2, weapon_2);

        enemyArmy.equipWarriorAtPosition(0, weapon_1);
        enemyArmy.equipWarriorAtPosition(1, weapon_1);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("10. ")
    void ten() {
        IWeapon weapon_1 = WeaponType.KATANA.getWeapon();
        IWeapon weapon_2 = WeaponType.MAGIC_WAND.getWeapon();

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.WARRIOR, 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.DEFENDER, 1);
        enemyArmy.addUnits(WarriorType.HEALER, 1);

        myArmy.equipWarriorAtPosition(0, weapon_1);
        myArmy.equipWarriorAtPosition(1, weapon_1);
        myArmy.equipWarriorAtPosition(2, weapon_1);

        enemyArmy.equipWarriorAtPosition(0, weapon_2);
        enemyArmy.equipWarriorAtPosition(1, weapon_2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }
}
