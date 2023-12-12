package edu.realemj.exercises16;

public class GenericLand {
    public static void main(String [] args) {
        DataHolder<String> s = new DataHolder<>("Hello");
        DataHolder<Integer> i = new DataHolder<>(78);

        String value1 = s.getData();
        Integer value2 = i.getData();


    }
}
