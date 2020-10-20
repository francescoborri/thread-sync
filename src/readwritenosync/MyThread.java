package readwritenosync;

import java.util.Random;

public class MyThread extends Thread {
    private int counter;
    private final Random random;
    private final char[] operations;

    public MyThread(String name, Random random, char[] operations) {
        super(name);
        this.random = random;
        this.operations = operations;
        this.counter = 0;
    }

    public void run() {
        System.out.printf("[%s] Avvio thread\n", this.getName());
        for (char operation : operations) {
            switch (operation) {
                case 'R':
                    counter = Risorsa.getCounter();
                    System.out.printf("[%s] Lettura risorsa: %d\n", this.getName(), this.getCounter());
                    break;
                case 'W':
                    int temp = random.nextInt(100);
                    Risorsa.setCounter(temp);
                    System.out.printf("[%s] Scrittura risorsa: %d\n", this.getName(), temp);
                    break;
            }
        }
        System.out.printf("[%s] Termine thread\n", this.getName());
    }

    public int getCounter() {
        return counter;
    }
}