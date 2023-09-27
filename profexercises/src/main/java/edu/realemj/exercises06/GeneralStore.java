package edu.realemj.exercises06;

import java.util.*;
import edu.realemj.exercises03.Supplies;
public class GeneralStore {

    public void enterStore(Supplies supplies, Scanner input) {
        printWelcome();

        int cnt = 0;
        boolean knownItem = false;

        do {
            printSelection();
            String request = askForSelection(input);
            cnt = getCount(request);
            String item = getItem(request);
            knownItem = isInStock(item);
            if(knownItem) {
                processSupplies(supplies, cnt, item);
            }
            else {
                printOutOfStock(item);
            }
            System.out.println(supplies);
        } while(cnt != 0 && knownItem);

        printGoodbye();
    }

    public void printWelcome() {
        System.out.println("********************************");
        System.out.println("* WELCOME TO THE GENERAL STORE *");
        System.out.println("********************************");
    }

    public void printSelection() {
        System.out.println("********************************");
        System.out.println(" - food");
        System.out.println("********************************");
    }

    public void printOutOfStock(String item) {
        System.out.println("********************************");
        System.out.println("I'm so sorry, but we don't have " + item + ". :'(");
        System.out.println("********************************");
    }
    public void printGoodbye() {
        System.out.println("********************************");
        System.out.println("Have a pleasant day!");
        System.out.println("********************************");
    }

    public String askForSelection(Scanner input) {
        System.out.println("Enter selection (cnt item):");
        String request = input.nextLine();
        return request;
    }

    public int getCount(String s) {
        String c = s.split(" ")[0];
        int cnt = Integer.parseInt(c);
        return cnt;
    }

    public String getItem(String s) {
        String item = s.split(" ")[1];
        return item;
    }

    public boolean isInStock(String item) {
        item = item.toLowerCase();
        return (item.equals("food"));
    }

    public void processSupplies(Supplies supplies,
                                int cnt,
                                String item) {
        double current = 0;
        if(item.equals("food")) {
            current = supplies.getTotalFood();
        }

        current += cnt;
        if(current < 0) {
            System.out.println("You don't have enough " + item + "!");
        }
        else {
            if(item.equals("food")) {
                supplies.setTotalFood(current);
            }
        }
    }
}
