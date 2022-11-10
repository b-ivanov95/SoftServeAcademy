package org.example.game;

import org.example.characters.Knight;
import org.example.characters.Warrior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    private static Stream<Arguments> fightScenarios() {
        return Stream.of(
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Knight(), new Knight(), true));
    }

    @ParameterizedTest
    @MethodSource("fightScenarios")
    void test1v1Battles(Warrior w1, Warrior w2, boolean expected) {
        assertEquals(expected, Battle.fight(w1, w2));
        assertEquals(expected, w1.isAlive());
        assertEquals(!expected, w2.isAlive());
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
}