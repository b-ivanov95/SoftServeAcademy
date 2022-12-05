package battles;

import org.example.characters.Army;
import org.example.characters.WarriorType;
import org.example.game.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HealerTest {

    @Test
    @DisplayName("Healer Army vs Healer Army expected True")
    void testHealerArmyVsHealerArmy1() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.LANCER, 7);
        myArmy.addUnits(WarriorType.VAMPIRE, 3);
        myArmy.addUnits(WarriorType.HEALER, 1);
        myArmy.addUnits(WarriorType.WARRIOR, 4);
        myArmy.addUnits(WarriorType.HEALER, 1);
        myArmy.addUnits(WarriorType.DEFENDER, 2);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 4);
        enemyArmy.addUnits(WarriorType.DEFENDER, 4);
        enemyArmy.addUnits(WarriorType.HEALER, 1);
        enemyArmy.addUnits(WarriorType.VAMPIRE, 6);
        enemyArmy.addUnits(WarriorType.LANCER, 4);

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Healer Army vs Healer Army expected False")
    void testHealerArmyVsHealerArmy2() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.LANCER, 1);
        myArmy.addUnits(WarriorType.WARRIOR, 3);
        myArmy.addUnits(WarriorType.HEALER, 1);
        myArmy.addUnits(WarriorType.WARRIOR, 4);
        myArmy.addUnits(WarriorType.HEALER, 1);
        myArmy.addUnits(WarriorType.KNIGHT, 2);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.WARRIOR, 4);
        enemyArmy.addUnits(WarriorType.DEFENDER, 4);
        enemyArmy.addUnits(WarriorType.HEALER, 1);
        enemyArmy.addUnits(WarriorType.VAMPIRE, 6);
        enemyArmy.addUnits(WarriorType.LANCER, 4);

        assertFalse(Battle.fight(myArmy, enemyArmy));
    }

    @Test
    @DisplayName("Healer Army vs Healer Army expected Exception")
    void testHealerOnlyVsHealerOnly() {

        Army myArmy = new Army();
        myArmy.addUnits(WarriorType.HEALER, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(WarriorType.HEALER, 1);

        Exception exception = assertThrows(IllegalStateException.class, () -> myArmy.hit(enemyArmy));
        String expectedMessage = "Cannot fight 2 Healers! Endless fight detected...";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}
