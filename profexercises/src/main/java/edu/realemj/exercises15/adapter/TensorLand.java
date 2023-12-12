package edu.realemj.exercises15.adapter;

public class TensorLand {
    public static void main(String [] args) {
        Image image = new TensorAdapter(new Matrix(480,640));

        System.out.println(image.getWidth() + " x " + image.getHeight());
    }
}
