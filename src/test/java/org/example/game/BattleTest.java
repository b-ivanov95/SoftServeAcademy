package org.example.game;

import org.example.characters.Army;
import org.example.characters.Defender;
import org.example.characters.Knight;
import org.example.characters.Warrior;
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
        assertEquals(expected, Battle.fight(w1, w2));
        assertEquals(expected, w1.isAlive());
        assertEquals(!expected, w2.isAlive());
    }


    @ParameterizedTest
    @MethodSource("fightScenariosArmies")
    void testArmyBattles(Army a1, Army a2, boolean expected) {
        assertEquals(expected, Battle.fight(a1,a2));
        assertEquals(expected,a1.iterator().hasNext());
        assertEquals(!expected, a2.iterator().hasNext());
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
                        new Army().addUnits(Warrior::new, 1),
                        new Army().addUnits(Warrior::new, 2),
                        false),
                //Battle 2
                Arguments.of(
                        new Army().addUnits(Warrior::new, 2),
                        new Army().addUnits(Warrior::new, 3),
                        false),
                //Battle 3
                Arguments.of(
                        new Army().addUnits(Warrior::new, 5),
                        new Army().addUnits(Warrior::new, 7),
                        false),
                //Battle 4
                Arguments.of(
                        new Army().addUnits(Warrior::new, 20),
                        new Army().addUnits(Warrior::new, 21),
                        true),
                //Battle 5
                Arguments.of(
                        new Army().addUnits(Warrior::new, 10),
                        new Army().addUnits(Warrior::new, 11),
                        true),
                //Battle 6
                Arguments.of(
                        new Army().addUnits(Warrior::new, 5)
                                            .addUnits(Defender::new,4)
                                            .addUnits(Defender::new,5),
                        new Army().addUnits(Warrior::new, 4),
                        true),
                //Battle 7
                Arguments.of(
                        new Army().addUnits(Defender::new, 5)
                                            .addUnits(Warrior::new,20)
                                            .addUnits(Defender::new,4),
                        new Army().addUnits(Warrior::new, 21),
                        true),
                //Battle 8
                Arguments.of(
                        new Army().addUnits(Warrior::new, 10)
                                            .addUnits(Defender::new,5)
                                            .addUnits(Defender::new,10),
                        new Army().addUnits(Warrior::new, 5),
                        true),
                //Battle 9
                Arguments.of(
                        new Army().addUnits(Defender::new, 2)
                                            .addUnits(Warrior::new,1)
                                            .addUnits(Defender::new,1),
                        new Army().addUnits(Warrior::new, 5),
                        false));

    }


}