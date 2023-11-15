package edu.realemj.exercises12;

import edu.realemj.exercises09.*;
public abstract class Shape {
    private boolean filled;
    private Matrix center = Matrix.makePoint3D(0,0,0);

    protected Shape() {}

    protected Shape(boolean filled) {
        this(Matrix.makePoint3D(0,0,0), filled);
    }

    protected Shape(Matrix center) {
        this(center, false);
    }

    protected Shape(Matrix center, boolean filled) {
        setFilled(filled);
        setCenter(center);
    }

    public String toString() {
        return "Shape (center=" + center.toPoint3DString()
                + ", filled=" + filled + ")";
    }

    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Matrix getCenter() {
        return new Matrix(center);
    }

    public void setCenter(Matrix center) {
        this.center = new Matrix(center);
    }

    public abstract double getArea();

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if(obj instanceof Shape other) {
            if(filled == other.filled) {
                isEqual = true;
            }
        }
        return isEqual;
    }
}
