package edu.realemj.exercises15.observer;

public class Batperson implements Observer {
    private String name;

    public Batperson(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Subject s) {
        if(s instanceof Batsignal b) {
            System.out.println("This is " + name
                    + ", responding to "
                    + b.getActiveCrime());
        }
    }
}
