package edu.realemj.exercises02;

public class NPC {
    private int health = 100;
    private char relationship = 'N';

    public NPC() {}

    public NPC(int h, char r) {
        //health = h;
        //relationship = r;
        setHealth(h);
        setRelationship(r);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
        health = Math.max(health, 0);
        health = Math.min(health, 100);
    }

    public char getRelationship() {
        return relationship;
    }

    public boolean setRelationship(char r) {
        // F = friend, N = neutral, E = enemy
        boolean valid = false;
        r = Character.toUpperCase(r);
        if(r == 'F' || r == 'N' || r == 'E') {
            relationship = r;
            valid = true;
        }
        return valid;
    }
}
