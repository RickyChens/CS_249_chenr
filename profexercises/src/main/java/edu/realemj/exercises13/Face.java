package edu.realemj.exercises13;

public class Face {
    private int index0, index1, index2;

    public Face() {}

    public Face(int i0, int i1, int i2) {
        index0 = i0;
        index1 = i1;
        index2 = i2;
    }

    public int getIndex(int index) {
        return switch(index) {
            case 0 -> index0;
            case 1 -> index1;
            case 2 -> index2;
            default -> -1;
        };
    }

    public void setIndex(int index, int value) {
        switch(index) {
            case 0 -> index0 = value;
            case 1 -> index1 = value;
            case 2 -> index2 = value;
            default -> {}
        }
    }

    public String toString() {
        return "f " + index0 + " " + index1 + " " + index2;
    }
}
