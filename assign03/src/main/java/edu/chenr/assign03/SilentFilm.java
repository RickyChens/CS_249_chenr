package edu.chenr.assign03;
import java.util.Scanner;

public class SilentFilm {
    public static Narrator askForNarration(Scanner input){
        System.out.println("Enter boundary character:");
        char boundaryChar = input.nextLine().charAt(0);
        System.out.println("Enter number of lines:");
        int numLines = Integer.parseInt(input.nextLine());
        System.out.println("Enter lines:");
        String [] lines = new String[numLines];
        for (int i = 0; i < numLines; i++){
           lines[i] = input.nextLine();
        }
        return (new Narrator(lines, boundaryChar));
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Narrator n = askForNarration(input);
        System.out.println("Our story begins...");
        System.out.println(n);
    }

}
