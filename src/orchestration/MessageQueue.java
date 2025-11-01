package orchestration;

public class MessageQueue {
    private String message;
    private boolean hasMessage = false;

    public synchronized void put(String msg) {
        while (hasMessage) {
            try {
                wait(); // Wait until the message is consumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        message = msg;
        hasMessage = true;
        System.out.println("Produced: " + msg);
        notify(); // Notify the waiting consumer
    }

    public synchronized String take() {
        while (!hasMessage) {
            try {
                wait(); // Wait until a message is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasMessage = false;
        System.out.println("Consumed: " + message);
        notify(); // Notify the waiting producer
        return message;
    }
}
