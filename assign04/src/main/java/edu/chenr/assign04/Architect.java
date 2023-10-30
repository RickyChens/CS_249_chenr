package edu.chenr.assign04;

import java.util.*;

public class Architect {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        ScreenBuffer buffer = new ScreenBuffer(7, 30, '.');
        System.out.println(buffer.getDisplayString());
        char cont = 'n';
        do {
            System.out.println("Enter box coordinates (sr sc er ec):");
            int sr = input.nextInt();
            int sc = input.nextInt();
            int er = input.nextInt();
            int ec = input.nextInt();
            System.out.println("Enter drawing character:");
            char drawChar = input.next().charAt(0);
            System.out.println("Is this filled? (y/n)");
            boolean filled = (input.next().charAt(0) == 'y');
            Box b = new Box(sr, sc, er, ec, filled, drawChar);
            b.draw(buffer);
            System.out.println(buffer.getDisplayString());
            System.out.println("Again? (y/n)");
            cont = input.next().charAt(0);
        }while(cont == 'y');
    }
}
