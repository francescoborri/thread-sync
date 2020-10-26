package semaphore;

import java.util.concurrent.Semaphore;

public class MutexTest {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        System.out.println("Without Locking:");
        MyThread th1 = new MyThread(false, '$', semaphore);
        th1.start();
        MyThread th2 = new MyThread(false, '#', semaphore);
        th2.start();

        th1.join();
        th2.join();
        System.out.println('\n');

        System.out.println("With Locking:");
        MyThread th3 = new MyThread(true, '$', semaphore);
        th3.start();
        MyThread th4 = new MyThread(true, '#', semaphore);
        th4.start();

        th3.join();
        th4.join();
        System.out.println('\n');
    }
}
