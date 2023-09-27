package edu.realemj.exercises07;
import java.util.*;
public class RandomGrader {

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter seed:");
        int seed = input.nextInt();
        Random rand = new Random(seed);

        System.out.println("Enter number of students:");
        int studentCnt = input.nextInt();

        int [] allGrades = createRandomGrades(studentCnt, rand);
        printAllGrades(allGrades);
        Arrays.sort(allGrades);
        System.out.println(Arrays.toString(allGrades));

        System.out.println("SORTED:");
        printAllGrades(allGrades);

        int aveGrade = getAverageGrade(allGrades);
        printGrade("AVERAGE", aveGrade, getLetterGrade(aveGrade));

        int stdGrade = getStdDevGrade(allGrades);
        System.out.println("STD DEV: " + stdGrade);
    }

    public static int [] createRandomGrades(int cnt, Random rand) {
        int [] grades = new int[cnt];
        for(int i = 0; i <  cnt; i++) {
            grades[i] = getRandomGrade(rand);
        }
        return grades;
    }

    public static int getStdDevGrade(int [] grades) {
        int mean = getAverageGrade(grades);
        double sum = 0.0;
        for(int g: grades) {
            g -= mean;
            g *= g;
            sum += g;
        }
        sum /= grades.length;
        return (int)Math.round(Math.sqrt(sum));
    }

    public static void printAllGrades(int [] grades) {
        for(int i = 0; i < grades.length; i++) {
            String letter = getLetterGrade(grades[i]);
            printGrade("Student " + (i+1), grades[i], letter);
        }
    }

    public static int getAverageGrade(int [] grades) {
        double sum = 0.0;
        for(int g: grades) {
            sum += g;
        }
        return (int)Math.round(sum/grades.length);
    }

    public static int getRandomGrade(Random rand) {
        return 50 + (int)(51*rand.nextDouble());
    }

    public static String getLetterGrade(int grade) {
        String letter = "F";
        if(grade >= 90) {
            letter = "A";
        }
        else if(grade >= 80) {
            letter = "B";
        }
        else if(grade >= 70) {
            letter = "C";
        }
        else if(grade >= 60) {
            letter = "D";
        }

        return letter;
    }

    public static void printGrade(String name, int grade, String letter) {
        System.out.println(name + ": " + grade + " (" + letter + ")");
    }
}
