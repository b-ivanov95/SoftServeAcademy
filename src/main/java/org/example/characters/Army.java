package org.example.characters;

import jdk.jshell.spi.SPIResolutionException;
import org.example.characters.interfaces.IArmyWarrior;
import org.example.characters.army.ArmyWarrior;

import java.util.*;

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

    public Army addUnits(WarriorType type, int numberOfUnits) {
        if (numberOfUnits < 1) {
            throw new IllegalArgumentException();
        }
        ArmyWarrior currentWarrior = type.getArmyInstance();
        if (head == null) {
            head = currentWarrior;
            head.setInCombat();
        } else {
            tail.setNextWarrior(currentWarrior);
            currentWarrior.setPreviousWarrior(tail);
        }

        for (int i = 1; i < numberOfUnits; i++) {
            ArmyWarrior newWarrior = type.getArmyInstance();
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

        myChampion.hit(enemyChampion);
        myChampion.useArmyEffect(enemyChampion);

    }

    public Army() {
    }

    public void burnDeadWarriors() {
        while(head != null && !head.isAlive()) {
            head = head.getNextWarrior();
        }
        var current = head;

        while(current != null && current.getNextWarrior()!= null) {
            if(!current.isAlive()) {
                var previous = current.getPreviousWarrior();
                var next = current.getNextWarrior();
                previous.setNextWarrior(next);
                next.setPreviousWarrior(previous);
            }
            current = current.getNextWarrior();
        }
        tail = current;

    }
}
