package demo;

import org.example.characters.Army;
import org.example.characters.Knight;
import org.example.characters.Warrior;
import org.example.game.Battle;

public class Main {
    public static void main(String[] args) {
        Army army1 = new Army().addUnits(Warrior::new, 2);
        Army army2 = new Army().addUnits(Knight:: new, 3);
        Battle.fight(army1,army2);
    }


}
