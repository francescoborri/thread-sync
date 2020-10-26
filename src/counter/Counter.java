package counter;

public class Counter {
    private static int counter = 1;

    public static synchronized void count(String threadName) {
        if (counter == 1) for (int i = counter; i < 10; i++)
            System.out.printf("[%s] Incremento di Counter.counter: %d -> %d\n", threadName, counter, ++counter);
        else for (int i = counter; i > 1; i--)
            System.out.printf("[%s] Decremento di Counter.counter: %d -> %d\n", threadName, counter, --counter);
    }
}