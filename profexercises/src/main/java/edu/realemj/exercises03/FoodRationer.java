package edu.realemj.exercises03;

import java.util.Scanner;

public class FoodRationer {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        Supplies supplies = new Supplies();
        String [] names = {"Luke", "Han", "Leia"};
        Party party = new Party(names);
        party.printParty();

        System.out.println("Enter total food:");
        supplies.setTotalFood(input.nextDouble());
        double rations = 10.0;

        double daysLeft = supplies.getTotalFood()/(rations*party.getPartyCnt());

        System.out.println("DAYS LEFT: " + daysLeft);
    }
}
