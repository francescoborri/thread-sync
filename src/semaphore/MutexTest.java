package semaphore;

import java.util.concurrent.Semaphore;

public class MutexTest {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        System.out.println("Without Locking:");
        MyThread th1 = new MyThread(false, '$', semaphore);
        MyThread th2 = new MyThread(false, '#', semaphore);

        long withoutLockingStart = System.nanoTime();
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        double withoutLockingDuration = (double)(System.nanoTime() - withoutLockingStart) / 1000000;

        System.out.println('\n');

        System.out.println("With Locking:");
        MyThread th3 = new MyThread(true, '$', semaphore);
        MyThread th4 = new MyThread(true, '#', semaphore);

        long withLockingStart = System.nanoTime();
        th3.start();
        th4.start();
        th3.join();
        th4.join();
        double withLockingDuration = (double)(System.nanoTime() - withLockingStart) / 1000000;

        System.out.printf("\n\nDuration without locking: %.2fms\nDuration with locking: %.2fms\n",
                withoutLockingDuration, withLockingDuration);
    }
}
