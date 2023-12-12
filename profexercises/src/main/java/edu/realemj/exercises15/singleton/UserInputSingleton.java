package edu.realemj.exercises15.singleton;
import java.util.*;
public class UserInputSingleton {
    private static UserInputSingleton instance = new UserInputSingleton();

    public static UserInputSingleton getInstance() {
        return instance;
    }

    private Scanner input = new Scanner(System.in);

    private UserInputSingleton() {}

    public Scanner getScanner() {
        return input;
    }
}
