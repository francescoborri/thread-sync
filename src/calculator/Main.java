package calculator;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    private static final char separator = ';';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Write a series of expressions separated by '%c': ", separator);
        String[] calculations = scanner.nextLine().split(String.valueOf(separator));

        ThreadPoolExecutor calculationsPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(calculations.length);
        for (String calculation : calculations)
            calculationsPool.submit(new CalculationThread(calculation));
        calculationsPool.shutdown();
    }
}