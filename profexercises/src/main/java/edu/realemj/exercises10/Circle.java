package edu.realemj.exercises10;

import edu.realemj.exercises09.Matrix;

public class Circle {
    private double radius = 1.0;
    private Matrix center = Matrix.makePoint3D(0,0,0);

    public Circle() {}

    public Circle(double r) {
        setRadius(r);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        if(r >= 0) {
            radius = r;
        }
    }

    public Matrix getCenter() {
        return new Matrix(center);
    }

    public void setCenter(Matrix other) {
        center = new Matrix(other);
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public String toString() {
        return "(circle, radius=" + radius
                + ", center=" + center.toPoint3DString() + ")";
    }
}
