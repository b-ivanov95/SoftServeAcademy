package org.example.characters;

public class Defender extends Warrior {

    private final int defense;

    @Override
    public void receiveDamageFrom(Warrior warrior) {
        if(warrior.isAlive() && warrior.getAttack() > this.defense) {
                this.setHealth(this.getHealth() - (warrior.getAttack() - this.defense));

        }
    }


    public Defender() {
        super(60,3);
        this.defense = 2;
    }

    public int getDefense() {
        return defense;
    }
}
