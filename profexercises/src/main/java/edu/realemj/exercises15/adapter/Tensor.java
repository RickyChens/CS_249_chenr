package edu.realemj.exercises15.adapter;

public interface Tensor {
    int getRowCnt();
    int getColCnt();
    double get(int row, int col);
    void set(int row, int col, double val);
}
