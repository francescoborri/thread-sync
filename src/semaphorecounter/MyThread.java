package semaphorecounter;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private final Semaphore semaphore;

    MyThread(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            if (Counter.getCounter() == 1) for (; Counter.getCounter() < 10; Counter.setCounter(Counter.getCounter() + 1))
                System.out.printf("[%s] Incremento: %d -> %d\n", this.getName(), Counter.getCounter(), Counter.getCounter() + 1);
            else if (Counter.getCounter() == 10) for (; Counter.getCounter() > 1; Counter.setCounter(Counter.getCounter() - 1))
                System.out.printf("[%s] Decremento: %d -> %d\n", this.getName(), Counter.getCounter(), Counter.getCounter() - 1);
            else
                System.out.println("[%s] Errore");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}