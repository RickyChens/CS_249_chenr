package edu.realemj.exercises15.observer;
import java.util.*;
public class Batsignal implements Subject {
    private String activeCrime = "";
    private ArrayList<Observer> crimeFighters = new ArrayList<>();

    @Override
    public void registerObserver(Observer ob) {
        crimeFighters.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        crimeFighters.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob: crimeFighters) {
            ob.update(this);
        }
    }

    public String getActiveCrime() {
        return activeCrime;
    }

    public void setActiveCrime(String crime) {
        activeCrime = crime;
        notifyObservers();
    }
}
