package battles;

import org.example.characters.Army;
import org.example.characters.WarriorType;
import org.example.game.Battle;
import org.example.items.WeaponType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BerserkerTest {

    @Test
    @DisplayName("1 Berserker vs 1 Warrior expected True ")
    void testBerserkerVsWarrior() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.BERSERKER, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 1);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("1 Berserker vs 2 Warriors expected False ")
    void testBerserkerVs2Warriors() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.BERSERKER, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("1 Berserker with cooldown reduction vs 2 Warriors expected False ")
    void testBerserkerWithCoolDownVs2Warriors() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.BERSERKER, 1);
        myArmy.equipWarriorAtPosition(0, WeaponType.SWIFTNESS_STAFF.getWeapon());

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("1 Berserker with 2 cooldown reduction items vs 2 Warriors expected True ")
    void testBerserkerWith2CoolDownVs2Warriors() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.BERSERKER, 1);
        myArmy.equipWarriorAtPosition(0, WeaponType.SWIFTNESS_STAFF.getWeapon());
        myArmy.equipWarriorAtPosition(0, WeaponType.SWIFTNESS_STAFF.getWeapon());

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }


    @Test
    @DisplayName("Berserker + Healer Vs 3 Warriors expected true")
    void testBerserkerHealerVs3Warriors() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.BERSERKER, 1);
        myArmy.addUnits(WarriorType.HEALER, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 3);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @ParameterizedTest
    @MethodSource("fightScenariosBerserkerArmies")
    void testArmyBattles(Army a1, Army a2, boolean expected) {
        assertEquals(expected, Battle.fight(a1, a2));
        assertEquals(expected, a1.hasNext());
        assertEquals(!expected, a2.hasNext());
    }

    private static Stream<Arguments> fightScenariosBerserkerArmies() {
        return Stream.of(
                //Battle 1
                Arguments.of(
                        new Army().addUnits(WarriorType.BERSERKER, 3),
                        new Army().addUnits(WarriorType.PRIEST, 3),
                        false),
                //Battle 2
                Arguments.of(
                        new Army().addUnits(WarriorType.DEFENDER, 2)
                                .addUnits(WarriorType.HEALER, 2)
                                .addUnits(WarriorType.BERSERKER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 3)
                                .addUnits(WarriorType.VAMPIRE, 2),
                        true),
                //Battle 3
                Arguments.of(
                        new Army().addUnits(WarriorType.BERSERKER, 5)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.HEALER, 7),
                        new Army().addUnits(WarriorType.PRIEST, 6)
                                .addUnits(WarriorType.LANCER, 6)
                                .addUnits(WarriorType.HEALER, 6),
                        false),
                //Battle 4
                Arguments.of(
                        new Army().addUnits(WarriorType.LANCER, 2)
                                .addUnits(WarriorType.HEALER, 3)
                                .addUnits(WarriorType.PRIEST, 4),
                        new Army().addUnits(WarriorType.BERSERKER, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 3),
                        true),
                //Battle 5
                Arguments.of(
                        new Army().addUnits(WarriorType.BERSERKER, 11)
                                .addUnits(WarriorType.PRIEST, 3)
                                .addUnits(WarriorType.WARRIOR, 4),
                        new Army().addUnits(WarriorType.KNIGHT, 4)
                                .addUnits(WarriorType.HEALER, 4)
                                .addUnits(WarriorType.VAMPIRE, 13),
                        true));

    }


}
