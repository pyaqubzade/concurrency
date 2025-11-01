package thread;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var thread = new Thread();
        System.out.println(Thread.currentThread().getName());
        thread.start();
        try {
            thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread is finished");
    }
}