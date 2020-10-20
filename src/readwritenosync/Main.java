package readwritenosync;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        MyThread t1 = new MyThread("t1", randomGenerator, new char[]{'R', 'W'});
        MyThread t2 = new MyThread("t2", randomGenerator, new char[]{'R', 'W'});
        MyThread last = new MyThread("last", randomGenerator, new char[]{'R'});

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("[Main] %s: %d\n", t1.getName(), t1.getCounter());
        System.out.printf("[Main] %s: %d\n", t2.getName(), t2.getCounter());

        last.start();

        try {
            last.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("[Main] %s: %d\n", last.getName(), last.getCounter());
    }
}
