package edu.realemj.exercises15.observer;

public class Superperson implements Observer {
    private String name;

    public Superperson(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject s) {
        if(s instanceof Batsignal b) {
            System.out.println("This isn't really my jurisdiction, but this is " + name + ", responding to " + b.getActiveCrime());
        }
    }
}
