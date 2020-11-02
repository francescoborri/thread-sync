package semaphorecounter;

import java.util.concurrent.Semaphore;

public class Main {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread("T1", semaphore);
        MyThread t2 = new MyThread("T2", semaphore);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
