package readwritenosync;

import java.util.Random;

public class MyThread extends Thread {
    private final char[] operations;
    private final int write;
    private int read;

    public MyThread(String name, int write, char[] operations) {
        super(name);
        this.operations = operations;
        this.write = write;
        this.read = 0;
    }

    public MyThread(String name, char[] operations) {
        super(name);
        this.operations = operations;
        this.write = 0;
        this.read = 0;
    }

    public void run() {
        System.out.printf("[%s] Avvio thread\n", this.getName());
        for (char operation : operations) {
            switch (operation) {
                case 'R':
                    read = Risorsa.getDato();
                    System.out.printf("[%s] Lettura risorsa: %d\n", this.getName(), this.getRead());
                    break;
                case 'W':
                    Risorsa.setDato(write);
                    System.out.printf("[%s] Scrittura risorsa: %d\n", this.getName(), write);
                    break;
            }
        }
        System.out.printf("[%s] Termine thread\n", this.getName());
    }

    public int getRead() {
        return read;
    }
}