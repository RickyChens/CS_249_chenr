package edu.chenr.assign05;

public class Troll extends Giant{

    public Troll(String name) {
        super(name);
    }

    public String toString(){
        return "Troll " + super.toString();
    }
    public String cook() {
        return "Mutton again...";
    }
}
