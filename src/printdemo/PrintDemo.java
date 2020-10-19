package printdemo;

class PrintDemo {
    public void printCount(String threadName) {
        try {
            for (int i = 5; i > 0; i--)
                System.out.println(threadName + " -> " + i);
        } catch (Exception e) {
            System.out.println("Thread interrotto.");
        }
    }
}