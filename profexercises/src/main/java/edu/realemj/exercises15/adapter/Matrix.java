package edu.realemj.exercises15.adapter;

public class Matrix implements Tensor {

    private double [][] m;

    public Matrix(int rowCnt, int colCnt) {
        m = new double[rowCnt][colCnt];
    }

    public Matrix(Matrix other) {
        m = new double[other.getRowCnt()][other.getColCnt()];
        for(int i = 0; i < other.getRowCnt(); i++) {
            for(int j = 0; j < other.getColCnt(); j++) {
                m[i][j] = other.m[i][j];
            }
        }
    }

    public int getRowCnt() {
        return m.length;
    }

    public int getColCnt() {
        return m[0].length;
    }

    public double get(int row, int col) {
        return m[row][col];
    }

    public void set(int row, int col, double val) {
        m[row][col] = val;
    }

    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix(getRowCnt(), other.getColCnt());
        for(int r = 0;  r < result.getRowCnt(); r++) {
            for(int c = 0; c < result.getColCnt(); c++) {
                double sum = 0;
                for(int i = 0; i < getColCnt(); i++) {
                    double val = get(r,i)*other.get(i,c);
                    sum += val;
                }
                result.set(r,c,sum);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < getRowCnt(); r++) {
            for(int c = 0; c < getColCnt(); c++) {
                sb.append(m[r][c]);
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void copyFrom(Matrix other) {
        if(getRowCnt() != other.getRowCnt() ||
                getColCnt() != other.getColCnt()) {
            m = new double[other.getRowCnt()][other.getColCnt()];
        }

        for(int i = 0; i < getRowCnt(); i++) {
            for(int j = 0; j < getColCnt(); j++) {
                m[i][j] = other.m[i][j];
            }
        }
    }

    public String toPoint3DString() {
        if(isPoint3D()) {
            return "(" + m[0][0] + "," + m[1][0] + "," + m[2][0] + ")";
        }
        else {
            return "()";
        }
    }

    public boolean isPoint3D() {
        return (getColCnt() == 1 &&
                (getRowCnt() == 3 || getRowCnt() == 4));
    }

    public static Matrix makePoint3D(double x, double y, double z) {
        Matrix p = new Matrix(4, 1);
        p.set(0, 0, x);
        p.set(1, 0, y);
        p.set(2, 0, z);
        p.set(3, 0, 1);
        return p;
    }

    public static Matrix makeTranslation3D(double ox,
                                                                   double oy,
                                                                   double oz) {
        Matrix t = new Matrix(4,4);
        t.set(0,0,1);
        t.set(1,1,1);
        t.set(2,2,1);
        t.set(3,3,1);

        t.set(0, 3, ox);
        t.set(1, 3, oy);
        t.set(2, 3, oz);

        return t;
    }

    public static Matrix makeScaling3D(double sx,
                                       double sy,
                                       double sz) {
        Matrix t = new Matrix(4,4);
        t.set(0,0,sx);
        t.set(1,1,sy);
        t.set(2,2,sz);
        t.set(3,3, 1);
        return t;
    }

    public static Matrix makeZRotation3D(double degrees) {
        double angle = Math.toRadians(degrees);
        Matrix t = new Matrix(4,4);
        t.set(0,0,Math.cos(angle));
        t.set(0,1,-Math.sin(angle));
        t.set(1,0,Math.sin(angle));
        t.set(1,1, Math.cos(angle));
        t.set(2,2,1);
        t.set(3,3,1);
        return t;
    }
}
