package edu.realemj.exercises15.decorator;

public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Mocha " + beverage.getDescription();
    }

    @Override
    public double getCost() {
        return 0.50 + beverage.getCost();
    }
}
