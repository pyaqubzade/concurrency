package racecondition;

public class Main {
    public static void main(String[] args) {
        var counter = new Counter();

        var sample = 100_000;

        var thread1 = new Thread(() -> {
            for (int i = 0; i < sample; i++) {
//                System.out.println("Thread 1 is running");
                counter.increment();
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < sample; i++) {
//                System.out.println("Thread 2 is running");
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Final counter value: %d%n", counter.getValue());
    }
}
