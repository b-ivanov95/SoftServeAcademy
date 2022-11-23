package org.example.characters;

import org.example.characters.Interfaces.IArmyWarrior;
import org.example.characters.Interfaces.IWarrior;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterator<IArmyWarrior> {

    private ArmyWarrior tail;

    private ArmyWarrior head;

    @Override
    public boolean hasNext() {
        if (head == null) {
            return false;
        }

        if (head.isAlive()) {
            return true;
        }
        head.setInCombat();
        head = head.getNextWarrior();
        if (head == null) {
            return false;
        }
        head.setInCombat();
        return true;

    }

    @Override
    public IArmyWarrior next() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head;

    }

    private ArmyWarrior wrap(IWarrior warrior) {
        if (warrior instanceof Healer) {
            return new ArmyHealer();
        }
        return new ArmyWarrior(warrior);
    }

    public Army addUnits(Supplier<IWarrior> factory, int numberOfUnits) {
        if (numberOfUnits < 1) {
            throw new IllegalArgumentException();
        }
        ArmyWarrior currentWarrior = wrap(factory.get());
        if (head == null) {
            head = currentWarrior;
            head.setInCombat();
        } else {
            tail.setNextWarrior(currentWarrior);
            currentWarrior.setPreviousWarrior(tail);
        }

        for (int i = 1; i < numberOfUnits; i++) {
            ArmyWarrior newWarrior = wrap(factory.get());
            currentWarrior.setNextWarrior(newWarrior);
            newWarrior.setPreviousWarrior(currentWarrior);
            currentWarrior = newWarrior;
        }
        tail = currentWarrior;


        return this;
    }

    public void hit(Army enemyArmy) {

        var myChampion = this.next();
        var enemyChampion = enemyArmy.next();
        while (myChampion != null) {
            myChampion.hit(enemyChampion);
            myChampion = myChampion.getNextWarrior();
        }
    }

    public Army() {
    }
}
