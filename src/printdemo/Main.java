package printdemo;

class Main {
    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo T1 = new ThreadDemo("Thread - 1", printDemo);
        ThreadDemo T2 = new ThreadDemo("Thread - 2", printDemo);
        ThreadDemo T3 = new ThreadDemo("Thread - 3", printDemo);

        T1.start();
        T2.start();
        T3.start();

        try {
            T1.join();
            System.out.println("Join " + T1.getName() + ", Alive: " + T1.isAlive());
            T2.join();
            System.out.println("Join " + T2.getName() + ", Alive: " + T2.isAlive());
            T3.join();
            System.out.println("Join " + T3.getName() + ", Alive: " + T3.isAlive());
        } catch (Exception e) {
            System.out.println("Interrotto");
        }
    }
}
