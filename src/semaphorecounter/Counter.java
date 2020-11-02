package semaphorecounter;

public class Counter {
    private static int counter = 1;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Counter.counter = counter;
    }
}
