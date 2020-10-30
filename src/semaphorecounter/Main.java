package semaphorecounter;

import java.util.concurrent.Semaphore;

public class Main {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread(semaphore, 'I');
        MyThread t2 = new MyThread(semaphore, 'I');

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
