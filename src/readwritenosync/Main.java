package readwritenosync;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1", 1, new char[]{'W', 'W'});
        MyThread t2 = new MyThread("t2", 2, new char[]{'W', 'R'});
        MyThread t3 = new MyThread("t3", 3, new char[]{'R', 'W'});
        MyThread t4 = new MyThread("t4", 4, new char[]{'W', 'R'});

        MyThread last = new MyThread("last", new char[]{'R'});

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("[Main] %s: %d\n", t1.getName(), t1.getRead());
        System.out.printf("[Main] %s: %d\n", t2.getName(), t2.getRead());
        System.out.printf("[Main] %s: %d\n", t3.getName(), t3.getRead());
        System.out.printf("[Main] %s: %d\n", t4.getName(), t4.getRead());


        last.start();

        try {
            last.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("[Main] %s: %d\n", last.getName(), last.getRead());
    }
}
