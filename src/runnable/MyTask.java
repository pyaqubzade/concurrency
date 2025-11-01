package runnable;

public class MyTask implements Runnable {

    @Override
    public void run() {
        var threadName = Thread.currentThread().getName();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.printf("Current running thread is %s%n", threadName);
    }
}
