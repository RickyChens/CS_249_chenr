package edu.realemj.exercises05;

public class SelectionLand {
    public static void main(String [] args) {
        int totalFood = 100;

        boolean enoughFood = (totalFood > 0);
        System.out.println("Enough?: " + enoughFood);
        System.out.println("Total food: " + totalFood);
        totalFood -= 200;

        enoughFood = (totalFood > 0);
        System.out.println("Enough again?: " + enoughFood);
        System.out.println("Total food: " + totalFood);



    }
}
