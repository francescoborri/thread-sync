package readwritenosync;

import java.util.Random;

public class MyThread extends Thread {
    private int counter;
    private final Random randomGenerator;
    private final char[] operations;

    public MyThread(String name, Random randomGenerator, char[] operations) {
        super();
        super.setName(name);
        counter = 0;
        this.randomGenerator = randomGenerator;
        this.operations = operations;
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
                    int temp = randomGenerator.nextInt(100);
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
