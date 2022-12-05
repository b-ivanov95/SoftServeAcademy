package battles;

import org.example.characters.*;
import org.example.characters.base.Knight;
import org.example.characters.base.Warrior;
import org.example.game.Battle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @ParameterizedTest
    @MethodSource("fightScenarios")
    void test1v1Battles(Warrior w1, Warrior w2, boolean expected) {
        Assertions.assertEquals(expected, Battle.fight(w1, w2));
        assertEquals(expected, w1.isAlive());
        assertEquals(!expected, w2.isAlive());
    }


    @ParameterizedTest
    @MethodSource("fightScenariosArmies")
    void testArmyBattles(Army a1, Army a2, boolean expected) {
        assertEquals(expected, Battle.fight(a1,a2));
        assertEquals(expected,a1.hasNext());
        assertEquals(!expected, a2.hasNext());
    }
    @Test
    void testArmyHealerBattle() {
        Army a1 = new Army();
        Army a2 = new Army();
        a1.addUnits(WarriorType.LANCER,7);
        a1.addUnits(WarriorType.VAMPIRE,3);
        a1.addUnits(WarriorType.HEALER,1);
        a1.addUnits(WarriorType.WARRIOR,4);
        a1.addUnits(WarriorType.HEALER,1);
        a1.addUnits(WarriorType.DEFENDER,2);
        a2.addUnits(WarriorType.WARRIOR,4);
        a2.addUnits(WarriorType.DEFENDER,4);
        a2.addUnits(WarriorType.HEALER,1);
        a2.addUnits(WarriorType.VAMPIRE,6);
        a2.addUnits(WarriorType.LANCER,4);
        assertTrue(Battle.fight(a1,a2));
    }

    @Test
    void test2v1battle() {
        Warrior w1 = new Warrior();
        Warrior w2 = new Warrior();
        Warrior k1 = new Knight();
        assertFalse(Battle.fight(w1, k1));
        assertFalse(w1.isAlive());
        assertTrue(k1.isAlive());
        assertFalse(Battle.fight(k1, w2));
        assertTrue(w2.isAlive());
        assertFalse(k1.isAlive());
    }

    private static Stream<Arguments> fightScenarios() {
        return Stream.of(
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Knight(), new Knight(), true));
    }

    private static Stream<Arguments> fightScenariosArmies() {
        return Stream.of(
                //Battle 1
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 1),
                        new Army().addUnits(WarriorType.WARRIOR, 2),
                        false),
                //Battle 2
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 3),
                        false),
                //Battle 3
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 5),
                        new Army().addUnits(WarriorType.WARRIOR, 7),
                        false),
                //Battle 4
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 20),
                        new Army().addUnits(WarriorType.WARRIOR, 21),
                        true),
                //Battle 5
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 10),
                        new Army().addUnits(WarriorType.WARRIOR, 11),
                        true),
                //Battle 6
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 5)
                                            .addUnits(WarriorType.DEFENDER,4)
                                            .addUnits(WarriorType.DEFENDER,5),
                        new Army().addUnits(WarriorType.WARRIOR, 4),
                        true),
                //Battle 7
                Arguments.of(
                        new Army().addUnits(WarriorType.DEFENDER, 5)
                                            .addUnits(WarriorType.WARRIOR,20)
                                            .addUnits(WarriorType.DEFENDER,4),
                        new Army().addUnits(WarriorType.WARRIOR, 21),
                        true),
                //Battle 8
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 10)
                                            .addUnits(WarriorType.DEFENDER,5)
                                            .addUnits(WarriorType.DEFENDER,10),
                        new Army().addUnits(WarriorType.WARRIOR, 5),
                        true),
                //Battle 9
                Arguments.of(
                        new Army().addUnits(WarriorType.DEFENDER, 2)
                                            .addUnits(WarriorType.WARRIOR,1)
                                            .addUnits(WarriorType.DEFENDER,1),
                        new Army().addUnits(WarriorType.WARRIOR, 5),
                        false),
                //Battle 10 [5x Defender 6x Vampire 7x Warrior]  vs [6x Warrior 6x Defender 6x Vampire]
                Arguments.of(
                        new Army().addUnits(WarriorType.DEFENDER, 5)
                                            .addUnits(WarriorType.VAMPIRE,6)
                                            .addUnits(WarriorType.WARRIOR,7),
                        new Army().addUnits(WarriorType.WARRIOR, 6)
                                  .addUnits(WarriorType.DEFENDER,6)
                                  .addUnits(WarriorType.VAMPIRE,6),
                        false),
                //Battle 11
                Arguments.of(
                        new Army().addUnits(WarriorType.DEFENDER, 2)
                                .addUnits(WarriorType.VAMPIRE,3)
                                .addUnits(WarriorType.WARRIOR,4),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER,4)
                                .addUnits(WarriorType.VAMPIRE,3),
                        false),
                //Battle 12
                Arguments.of(
                        new Army().addUnits(WarriorType.DEFENDER, 11)
                                .addUnits(WarriorType.VAMPIRE,3)
                                .addUnits(WarriorType.WARRIOR,4),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER,4)
                                .addUnits(WarriorType.VAMPIRE,13),
                        true),
                //Battle 13
                Arguments.of(
                        new Army().addUnits(WarriorType.LANCER, 7)
                                .addUnits(WarriorType.VAMPIRE,3)
                                .addUnits(WarriorType.WARRIOR,4)
                                .addUnits(WarriorType.DEFENDER,2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER,4)
                                .addUnits(WarriorType.VAMPIRE,6)
                                .addUnits(WarriorType.LANCER,4),
                        true),
                //Battle 14
                Arguments.of(
                        new Army().addUnits(WarriorType.WARRIOR, 2),
                        new Army().addUnits(WarriorType.LANCER, 1)
                                .addUnits(WarriorType.WARRIOR,1),
                        false));

    }


}