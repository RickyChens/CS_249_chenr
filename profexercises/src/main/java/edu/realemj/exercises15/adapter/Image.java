package edu.realemj.exercises15.adapter;

public interface Image {
    int getWidth();
    int getHeight();
    int getPixel(int x, int y);
    void setPixel(int x, int y, int value);
}
