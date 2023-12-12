package edu.realemj.exercises15.strategy;

import java.util.*;

public class BearSimulator {
    public static void main(String [] args) {
        ArrayList<Bear> allBears = new ArrayList<>();
        allBears.add(new GrizzlyBear());
        allBears.add(new TeddyBear());
        allBears.add(new GrizzlyBear());

        System.out.println("BEARS!");
        for(Bear b: allBears) {
            b.performMove();
        }

        allBears.get(2).setMoveBehavior(new MoveWithTwoLegs());

        System.out.println("BEARS AGAIN!");
        for(Bear b: allBears) {
            b.performMove();
        }
    }
}
