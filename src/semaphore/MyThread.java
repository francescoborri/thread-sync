package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread extends Thread {
    private final Semaphore semaphore;
    private final boolean lock;
    private final char c;

    MyThread(boolean lock, char c, Semaphore semaphore) {
        this.semaphore = semaphore;
        this.lock = lock;
        this.c = c;
    }

    public void run() {
        try {
            int random = ThreadLocalRandom.current().nextInt(0, 50 + 1);

            for (int i = 0; i < 10; i++) {
                if (lock)
                    semaphore.acquire();
                try {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(c);
                        Thread.sleep(random);
                    }
                } finally {
                    System.out.print('|');
                    if (lock)
                        semaphore.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}