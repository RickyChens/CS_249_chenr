package edu.realemj.exercises12;

import edu.realemj.exercises09.Matrix;
import edu.realemj.exercises13.InvalidRadiusException;
import edu.realemj.exercises14.*;
import java.util.*;

public class SuperShapeLand {
    public static void main(String [] args) {
        try {
            /*
            // Cannot use now that Shape is abstract
            Shape s1 = new Shape();
            Shape s2 = new Shape(Matrix.makePoint3D(1, 2, 3), true);

            System.out.println(s1);
            System.out.println(s2);
             */

            Circle c2 = new Circle(7.8,
                    Matrix.makePoint3D(4, 5, 6),
                    true);
            Circle c1 = new Circle();
            c1.setFilled(true);
            System.out.println(c2);
            System.out.println(c1);

            Shape c3 = new Circle();
            // Declared: Shape
            // Actual: Circle
            System.out.println(c3);

            Shape[] allShapes = new Shape[3];
            allShapes[0] = new Circle(); // new Shape();
            allShapes[1] = new Circle(4.0);
            allShapes[2] = new Rectangle(2, 9);

            printShapeAreas(allShapes);

            Loadable item = new Circle();
            item.load(new Scanner("4.5"));

            Circle [] allCircles = {
                    new Circle(0.5),
                    new Circle(1.2),
                    new Circle(18.5),
                    new Circle(7.3),
                    new Circle(0.01)
            };

            System.out.println("BEFORE:");
            for(Circle myc: allCircles) {
                System.out.println("* " + myc);
            }

            Arrays.sort(allCircles);

            System.out.println("AFTER:");
            for(Circle myc: allCircles) {
                System.out.println("* " + myc);
            }


            Circle grief = new Circle(-3.0);
        }
        catch(InvalidRadiusException r) {
            System.err.println("Bad Circle: " + r.getMessage());
            r.printStackTrace();
        }
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
