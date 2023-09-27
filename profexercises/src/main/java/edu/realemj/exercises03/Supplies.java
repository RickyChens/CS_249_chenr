package edu.realemj.exercises03;

public class Supplies {
    private double totalFood;
    private int totalBullets;
    private int totalAxles;

    public double getTotalFood() {
        return totalFood;
    }
    public int getTotalBullets() { return totalBullets; }
    public int getTotalAxles() { return totalAxles; }

    public boolean setTotalFood(double food) {
        boolean valid = false;
        if(food >= 0) {
            totalFood = food;
            valid = true;
        }
        return valid;
    }

    public boolean setTotalBullets(int bullets) {
        boolean valid = false;
        if(bullets >= 0) {
            totalBullets = bullets;
            valid = true;
        }
        return valid;
    }

    public boolean setTotalAxles(int axles) {
        boolean valid = false;
        if(axles >= 0) {
            totalAxles = axles;
            valid = true;
        }
        return valid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("** SUPPLIES ************\n");
        sb.append("\t* Food: " + totalFood + "\n");
        sb.append("\t* Bullets: " + totalBullets + "\n");
        sb.append("\t* Axles: " + totalAxles + "\n");
        sb.append("************************\n");
        return sb.toString();
    }
}
