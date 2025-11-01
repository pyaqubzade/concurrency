package orchestration;

public class Main {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();

        Thread producer = new Thread(() -> {
            String[] messages = { "Hello", "World", "from", "Producer" };
            for (String msg : messages) {
                queue.put(msg);
            }
            queue.put("DONE");
        });

        Thread consumer = new Thread(() -> {
            String msg;
            do {
                msg = queue.take();
            } while (!msg.equals("DONE"));
        });

        producer.start();
        consumer.start();
    }
}
