package edu.realemj.exercises15.adapter;

public class TensorAdapter implements Image {
    private Tensor t;

    public TensorAdapter(Tensor tensor) {
        t = tensor;
    }
    public int getWidth() {
        return t.getColCnt();
    }
    public int getHeight() {
        return t.getRowCnt();
    }
    public int getPixel(int x, int y) {
        return (int)t.get(y,x);
    }
    public void setPixel(int x, int y, int value) {
        t.set(y, x, value);
    }
}
