package edu.realemj.exercises15.observer;

public class GothamCity {
    public static void main(String [] args) {
        Batsignal batsignal = new Batsignal();

        Batperson bruce = new Batperson("Batman");
        Batperson dick = new Batperson("Nightwing");
        Batperson tim = new Batperson("Robin");
        Batperson barbara = new Batperson("Batgirl");

        Batperson [] batfam = {
                bruce, dick, tim, barbara
        };

        for(Batperson p: batfam) {
            batsignal.registerObserver(p);
        }

        batsignal.setActiveCrime("a robbery");

        batsignal.removeObserver(dick);

        batsignal.setActiveCrime("a kidnapping");

        Superperson clark = new Superperson("Superman");
        batsignal.registerObserver(clark);
        batsignal.setActiveCrime("an alien invasion");
    }
}
