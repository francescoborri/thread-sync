package readwritenosync;

public class Risorsa {
    private static int counter;
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Risorsa.counter = counter;
    }
}
