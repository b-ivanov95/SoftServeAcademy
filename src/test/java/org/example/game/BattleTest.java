package org.example.game;

import org.example.characters.*;
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
        assertEquals(expected,a1.hasNext());
        assertEquals(!expected, a2.hasNext());
    }
    @Test
    void testArmyHealerBattle() {
        Army a1 = new Army();
        Army a2 = new Army();
        a1.addUnits(Lancer::new,7);
        a1.addUnits(Vampire::new,3);
        a1.addUnits(Healer::new,1);
        a1.addUnits(Warrior::new,4);
        a1.addUnits(Healer::new,1);
        a1.addUnits(Defender::new,2);
        a2.addUnits(Warrior::new,4);
        a2.addUnits(Defender::new,4);
        a2.addUnits(Healer::new,1);
        a2.addUnits(Vampire::new,6);
        a2.addUnits(Lancer::new,4);
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
                        false),
                //Battle 10 [5x Defender 6x Vampire 7x Warrior]  vs [6x Warrior 6x Defender 6x Vampire]
                Arguments.of(
                        new Army().addUnits(Defender::new, 5)
                                            .addUnits(Vampire::new,6)
                                            .addUnits(Warrior::new,7),
                        new Army().addUnits(Warrior::new, 6)
                                  .addUnits(Defender::new,6)
                                  .addUnits(Vampire::new,6),
                        false),
                //Battle 11
                Arguments.of(
                        new Army().addUnits(Defender::new, 2)
                                .addUnits(Vampire::new,3)
                                .addUnits(Warrior::new,4),
                        new Army().addUnits(Warrior::new, 4)
                                .addUnits(Defender::new,4)
                                .addUnits(Vampire::new,3),
                        false),
                //Battle 12
                Arguments.of(
                        new Army().addUnits(Defender::new, 11)
                                .addUnits(Vampire::new,3)
                                .addUnits(Warrior::new,4),
                        new Army().addUnits(Warrior::new, 4)
                                .addUnits(Defender::new,4)
                                .addUnits(Vampire::new,13),
                        true),
                //Battle 13
                Arguments.of(
                        new Army().addUnits(Lancer::new, 7)
                                .addUnits(Vampire::new,3)
                                .addUnits(Warrior::new,4)
                                .addUnits(Defender::new,2),
                        new Army().addUnits(Warrior::new, 4)
                                .addUnits(Defender::new,4)
                                .addUnits(Vampire::new,6)
                                .addUnits(Lancer::new,4),
                        true),
                //Battle 14
                Arguments.of(
                        new Army().addUnits(Warrior::new, 2),
                        new Army().addUnits(Lancer::new, 1)
                                .addUnits(Warrior::new,1),
                        false));

    }


}