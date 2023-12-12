package edu.realemj.exercises16;

import java.util.*;
public class GenericQueue<T> {
    private ArrayList<T> data = new ArrayList<>();

    public int getSize() {
        return data.size();
    }

    public void enqueue(T obj) {
        data.add(obj);
    }

    public T dequeue() {
        if(getSize() > 0) {
            //T obj = data.get(0);
            T obj = data.remove(0);
            return obj;
        }
        else {
            return null;
        }
    }

    public T peek() {
        if(getSize() > 0) {
            return data.get(0);
        }
        else {
            return null;
        }
    }

    public boolean isEmpty() {
        return (getSize() == 0);
    }

    public String toString() {
        return data.toString();
    }
}
