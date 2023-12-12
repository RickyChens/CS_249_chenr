package edu.realemj.exercises15.decorator;

public class CoffeeShop {
    public static void main(String [] args) {
        Beverage b = new DarkRoast();
        b = new Mocha(b);
        b = new Whip(b);

        System.out.println(b.getDescription()
                        + ": $"
                        + b.getCost());
        System.out.println(b);
    }
}
