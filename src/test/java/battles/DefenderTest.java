package battles;

import characters.Rookie;
import org.example.characters.Army;
import org.example.characters.WarriorType;
import org.example.characters.base.Warrior;
import org.example.characters.interfaces.IWarrior;
import org.example.game.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefenderTest {


    @DisplayName("Two armies fight")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected  result = {2}")
    @MethodSource("testArmiesFight")
    void testArmiesFight(Army army1, Army army2, boolean expected) {

        var test = Battle.fight(army1, army2);

        assertEquals(expected, test);
    }

    public static Stream<Arguments> testArmiesFight() {

        return Stream.of(
                Arguments.of(new Army()
                                .addUnits(WarriorType.WARRIOR, 5)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.DEFENDER, 5),
                        new Army()
                                .addUnits(WarriorType.WARRIOR, 4),
                        true),
                Arguments.of(new Army()
                                .addUnits(WarriorType.DEFENDER, 5)
                                .addUnits(WarriorType.WARRIOR, 20)
                                .addUnits(WarriorType.DEFENDER, 4),
                        new Army()
                                .addUnits(WarriorType.WARRIOR, 21),
                        true),
                Arguments.of(new Army()
                                .addUnits(WarriorType.WARRIOR, 10)
                                .addUnits(WarriorType.DEFENDER, 5)
                                .addUnits(WarriorType.DEFENDER, 10),
                        new Army()
                                .addUnits(WarriorType.DEFENDER, 10),
                        true),
                Arguments.of(new Army()
                                .addUnits(WarriorType.DEFENDER, 2)
                                .addUnits(WarriorType.WARRIOR, 1)
                                .addUnits(WarriorType.DEFENDER, 1),
                        new Army()
                                .addUnits(WarriorType.WARRIOR, 5),
                        false),
                Arguments.of(new Army()
                                .addUnits(WarriorType.WARRIOR, 10)
                                .addUnits(WarriorType.KNIGHT, 5),
                        new Army()
                                .addUnits(WarriorType.WARRIOR, 30),
                        false),
                Arguments.of(new Army()
                                .addUnits(WarriorType.KNIGHT, 3),
                        new Army()
                                .addUnits(WarriorType.WARRIOR, 3),
                        true)
        );
    }
}
