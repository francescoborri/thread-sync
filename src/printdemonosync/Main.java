package printdemonosync;

class Main {
    public static void main(String[] args) {
        PrintDemoNoSync printDemoNoSync = new PrintDemoNoSync();

        ThreadDemo T1 = new ThreadDemo("Thread - 1", printDemoNoSync);
        ThreadDemo T2 = new ThreadDemo("Thread - 2", printDemoNoSync);
        ThreadDemo T3 = new ThreadDemo("Thread - 3", printDemoNoSync);

        T1.start();
        T2.start();
        T3.start();

        try {
            T1.getThread().join();
            System.out.println("Join " + T1.getName() + ", Alive: " + T1.getThread().isAlive());
            T2.getThread().join();
            System.out.println("Join " + T2.getName() + ", Alive: " + T2.getThread().isAlive());
            T3.getThread().join();
            System.out.println("Join " + T3.getName() + ", Alive: " + T3.getThread().isAlive());
        } catch (Exception e) {
            System.out.println("Interrotto");
        }
    }
}
