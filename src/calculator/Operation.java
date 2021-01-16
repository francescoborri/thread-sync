package calculator;

public enum Operation {
    PLUS((Integer n1, Integer n2) -> Double.valueOf(n1 + n2)),
    MINUS((Integer n1, Integer n2) -> Double.valueOf(n1 - n2)),
    TIMES((Integer n1, Integer n2) -> Double.valueOf(n1 * n2)),
    DIVIDE((Integer n1, Integer n2) -> Double.valueOf((double) n1 / n2));

    private final TwoParameterFunction<Integer, Integer, Double> operation;

    Operation(TwoParameterFunction<Integer, Integer, Double> operation) {
        this.operation = operation;
    }

    public static Operation fromSymbol(char symbol) {
        return switch (symbol) {
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> TIMES;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException();
        };
    }

    public Double apply(Integer n1, Integer n2) {
        return operation.apply(n1, n2);
    }
}
