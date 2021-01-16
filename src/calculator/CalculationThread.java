package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculationThread extends Thread {
    private final int n1;
    private final int n2;
    private final Operation operation;

    public CalculationThread(String calculation) {
        super(calculation.trim());

        Scanner scanner = new Scanner(calculation);
        Pattern pattern = Pattern.compile("[+\\-*/]");

        this.n1 = scanner.nextInt();
        if (!scanner.hasNext(pattern))
            throw new IllegalArgumentException();
        this.operation = Operation.fromSymbol(scanner.next(pattern).charAt(0));
        this.n2 = scanner.nextInt();
    }

    @Override
    public void run() {
        double result = operation.apply(n1, n2);
        if (result == (long) result)
            System.out.printf("%s = %d\n", getName(), (long) result);
        else
            System.out.printf("%s = %s\n", getName(), result);
    }
}
