package semaphorecounter;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private final Semaphore semaphore;
    private final char operation;

    MyThread(Semaphore semaphore, char operation) {
        this.semaphore = semaphore;
        this.operation = operation;
    }

    public void run() {
        try {
            semaphore.acquire();
            switch (operation) {
                case 'I':
                    break;
                case 'D':
                    break;
                default:
                    break;
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}