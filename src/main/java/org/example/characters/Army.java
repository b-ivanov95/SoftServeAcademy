package org.example.characters;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {

    private final Queue<Warrior> units;
    private final Iterator<Warrior> iterator;

    public Army addUnits(Supplier<Warrior> factory, int numberOfUnits) {
        for (int i = 0; i < numberOfUnits; i++) {
            units.offer(factory.get());
        }
        return this;
    }

    public Collection<Warrior> getUnits() {
        return units;
    }

    @Override
    public Iterator<Warrior> iterator() {
        return iterator;
    }

    class ArmyIterator implements Iterator<Warrior> {

        @Override
        public boolean hasNext() {
            if (units.isEmpty()) {
                return false;
            }

            var currentFighter = units.peek();
            if (currentFighter.isAlive()) {
                return true;
            }

            units.poll();
            return units.peek() != null;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return units.peek();
        }
    }

    public Army() {
        this.units = new LinkedList<>();
        this.iterator = new ArmyIterator();
    }
}
