package printdemo;

class ThreadDemo extends Thread {
    private final String name;
    private final PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo pd) {
        this.name = name;
        printDemo = pd;
    }

    public void run() {
        System.out.println("Avvio... " + name);
        synchronized (printDemo) {
            printDemo.printCount(name);
        }
        System.out.println(name + " in uscita.");
    }
}
