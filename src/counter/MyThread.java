package counter;

public class MyThread extends Thread {
    private double duration;

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.printf("[%s] Avvio thread\n", this.getName());
        long startTime = System.nanoTime();
        Counter.count(this.getName());
        long endTime = System.nanoTime();
        this.duration = (double) (endTime - startTime) / 1000000;
        System.out.printf("[%s] Termine thread; durata: %.2fms\n", this.getName(), this.getDuration());
    }

    public double getDuration() {
        return duration;
    }
}