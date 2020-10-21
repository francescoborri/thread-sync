package readwrite;

public class MyThread extends Thread {
    private final char[] operations;
    private final int write;
    private int read;
    private double duration;

    public MyThread(String name, int write, char[] operations) {
        super(name);
        this.operations = operations;
        this.write = write;
        this.read = 0;
    }

    public void run() {
        System.out.printf("[%s] Avvio thread\n", this.getName());
        long startTime = System.nanoTime();
        synchronized (Risorsa.class) {
            for (char operation : operations) {
                switch (operation) {
                    case 'R':
                        this.read = Risorsa.getDato();
                        System.out.printf("[%s] Lettura risorsa: %d\n", this.getName(), this.getRead());
                        break;
                    case 'W':
                        Risorsa.setDato(this.write);
                        System.out.printf("[%s] Scrittura risorsa: %d\n", this.getName(), this.write);
                        break;
                    default:
                        System.out.println("[%s] Nessuna operazione");
                        break;
                }
            }
        }
        long endTime = System.nanoTime();
        this.duration = (double)(endTime - startTime) / 1000000;
        System.out.printf("[%s] Termine thread; durata: %.2fms\n", this.getName(), this.getDuration());
    }

    public int getRead() {
        return read;
    }

    public double getDuration() {
        return duration;
    }
}