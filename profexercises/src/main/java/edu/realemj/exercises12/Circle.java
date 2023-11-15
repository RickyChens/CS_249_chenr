package edu.realemj.exercises12;

import edu.realemj.exercises09.*;
import edu.realemj.exercises13.InvalidRadiusException;
import edu.realemj.exercises14.*;
import java.util.*;
public class Circle extends Shape
        implements Loadable, Comparable<Circle> {
    private double radius = 1.0;

    public int compareTo(Circle other) {
        if(this.equals(other)) {
            return 0;
        }
        else if(this.radius < other.radius) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public Circle() {
        // super();
    }

    public Circle(double radius) throws InvalidRadiusException {
        // super();
        setRadius(radius);
    }

    public Circle(double radius, Matrix center) throws InvalidRadiusException {
        super(center);
        setRadius(radius);
    }

    public Circle(double radius,
                  Matrix center,
                  boolean filled) throws InvalidRadiusException {
        super(center, filled);
        setRadius(radius);
        //setCenter(center);
        //setFilled(filled);
    }

    public void load(Scanner input) {
        radius = input.nextDouble();
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) throws InvalidRadiusException {
        if(radius >= 0.0) {
            this.radius = radius;
        }
        else {
            throw new InvalidRadiusException("Bad radius: " + radius);
        }
    }

    @Override
    public String toString() {
        String old = super.toString();
        int pindex = old.indexOf("(");
        old = old.substring(pindex+1);
        return "Circle (radius=" + radius + ", " + old;

        /*
        return "Circle (radius=" + radius
                + ", center="
                + getCenter().toPoint3DString()
                + ", filled="
                + isFilled()
                + ")";
         */
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if(obj instanceof Circle other) {
            final double EPS = 1e-08;
            if(Math.abs(radius - other.radius) < EPS
                && super.equals(other)) {
                // Radii are equal
                isEqual = true;
            }
        }
        return isEqual;
    }
}
