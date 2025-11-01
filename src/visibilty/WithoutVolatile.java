package visibilty;

public class WithoutVolatile {

    private volatile static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) {
                // busy work
            }
            System.out.println("Worker stopped.");
        });

        worker.start();

        Thread.sleep(1000);
        System.out.println("Requesting stop...");
        running = false;
    }
}
