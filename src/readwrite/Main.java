package readwrite;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1", 1, new char[]{'R'});
        MyThread t2 = new MyThread("t2", 2, new char[]{'R', 'W', 'R', 'W'});
        MyThread t3 = new MyThread("t3", 3, new char[]{'R', 'W', 'R'});
        MyThread t4 = new MyThread("t4", 4, new char[]{'W', 'R'});

        long startTime = System.nanoTime();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.printf("[Main] %s.getRead(): %d\n", t1.getName(), t1.getRead());
        System.out.printf("[Main] %s.getRead(): %d\n", t2.getName(), t2.getRead());
        System.out.printf("[Main] %s.getRead(): %d\n", t3.getName(), t3.getRead());
        System.out.printf("[Main] %s.getRead(): %d\n", t4.getName(), t4.getRead());
        System.out.printf("[Main] Risorsa.getDato(): %d\n", Risorsa.getDato());
        System.out.printf("[Main] Tempo di esecuzione totale dei 4 thread: %.2fms\n", (double)(endTime - startTime) / 1000000);
    }
}
