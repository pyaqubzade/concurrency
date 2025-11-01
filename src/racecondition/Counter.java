package racecondition;

public class Counter {

    private int value = 0;

    public void increment() {
        try {
            Thread.sleep(10_000);
            // Commission
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            value++;
        }
    }

    public int getValue() {
        return value;
    }
}
