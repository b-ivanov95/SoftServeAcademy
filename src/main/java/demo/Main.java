package demo;

import org.example.characters.*;
import org.example.game.Battle;

public class Main {
    public static void main(String[] args) {

        Army a1 = new Army();
        Army a2 = new Army();
        a1.addUnits(WarriorType.HEALER,5);
        a2.addUnits(WarriorType.HEALER,5);

        boolean result = Battle.straightFight(a1,a2);
        System.out.println(result);






    }


}
