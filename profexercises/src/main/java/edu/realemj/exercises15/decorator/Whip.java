package edu.realemj.exercises15.decorator;

public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Whipped Cream " + beverage.getDescription();
    }

    @Override
    public double getCost() {
        return 0.30 + beverage.getCost();
    }
}
