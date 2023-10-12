package edu.realemj.exercises03;

public class Person {
    private String name = "";
    private boolean alive = true;

    public Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean living) {
        alive = living;
    }

    public String toString() {
        String s = name;
        if(!alive) {
            s += " (Deceased)";
        }
        return s;
    }

}
