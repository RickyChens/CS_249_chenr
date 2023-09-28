package edu.chenr.assign02;
import java.util.Scanner;

public class League {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        Superhero p = new Superhero();

        System.out.println("Enter hero name:");
        p.setHeroName(input.nextLine());
        System.out.println("Enter real name:");
        p.setRealName(input.nextLine());
        System.out.println("Enter height (inches) and weight (pounds):");
        String line = input.nextLine();
        Scanner parseLine = new Scanner(line);
        p.setHeight(parseLine.nextInt());
        p.setWeight(parseLine.nextDouble());
        System.out.println(p.toString());
    }
}
