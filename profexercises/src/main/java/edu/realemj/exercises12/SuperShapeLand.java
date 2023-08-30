package edu.realemj.exercises12;

import edu.realemj.exercises09.Matrix;

public class SuperShapeLand {
    public static void main(String [] args) {
        Shape s1 = new Shape();
        Shape s2 = new Shape(Matrix.makePoint3D(1,2,3), true);

        System.out.println(s1);
        System.out.println(s2);

        Circle c2 = new Circle(7.8,
                                Matrix.makePoint3D(4,5,6),
                            true);
        Circle c1 = new Circle();
        c1.setFilled(true);
        System.out.println(c2);
        System.out.println(c1);

        Shape c3 = new Circle();
        // Declared: Shape
        // Actual: Circle
        System.out.println(c3);

        Shape [] allShapes = new Shape[3];
        allShapes[0] = new Shape();
        allShapes[1] = new Circle(4.0);
        allShapes[2] = new Rectangle(2, 9);

        printShapeAreas(allShapes);
    }

    public static void printShapeAreas(Shape [] allShapes) {
        System.out.println("ALL SHAPES:");
        for(Shape s: allShapes) {
            System.out.println(s);
            System.out.println(s.getArea());
            if(s instanceof Circle c) {
                //Circle c = (Circle)s;
                System.out.println("\tRadius=" + c.getRadius());
            }
        }
    }
}