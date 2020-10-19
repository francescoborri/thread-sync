package printdemonosync;

class ThreadDemo extends Thread {
    private Thread thread;
    private final String name;
    private final PrintDemoNoSync printDemo;

    ThreadDemo(String name, PrintDemoNoSync pd) {
        this.name = name;
        printDemo = pd;
    }

    public void run() {
        printDemo.printCount(name);
        System.out.println(name + " in uscita.");
    }

    public void start() {
        System.out.println("Avvio... " + name);
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }

    public Thread getThread() {
        return thread;
    }
}
