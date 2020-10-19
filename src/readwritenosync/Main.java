package readwritenosync;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        MyThread myThread1 = new MyThread("Thread-1", randomGenerator, new char[]{'R', 'W'});
        MyThread myThread2 = new MyThread("Thread-2", randomGenerator, new char[]{'R', 'W'});
        MyThread last = new MyThread("Last-thread", randomGenerator, new char[]{'R'});

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("[Main] %s: %d\n", myThread1.getName(), myThread1.getCounter());
        System.out.printf("[Main] %s: %d\n", myThread2.getName(), myThread2.getCounter());

        last.start();

        try {
            last.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("[Main] %s: %d\n", last.getName(), last.getCounter());
    }
}
