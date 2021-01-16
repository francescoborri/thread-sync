package calculator;

import java.util.Scanner;

public class Main {
    private static final char separator = ';';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Write a series of expressions separated by '%c': ", separator);
        String[] calculations = scanner.nextLine().split(String.valueOf(separator));

        for (String calculation : calculations)
            new CalculationThread(calculation).start();
    }
}