package counter;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");

        long startTime = System.nanoTime();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.printf("[Main] Tempo di esecuzione totale dei 4 thread: %.2fms\n", (double)(endTime - startTime) / 1000000);
    }
}
