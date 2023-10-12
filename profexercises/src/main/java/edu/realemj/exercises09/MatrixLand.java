package edu.realemj.exercises09;

public class MatrixLand {
    public static void main(String [] args) {
        Matrix p = Matrix.makePoint3D(5, 3, -2);
        System.out.println(p);
        Matrix t = Matrix.makeTranslation3D(2, 8, 0);
        Matrix t2 = Matrix.makeTranslation3D(-7, 3, -1);
        Matrix combo = t2.multiply(t);
        System.out.println(combo);
        Matrix p2 = combo.multiply(p);
        System.out.println(p2);


    }
}
