package runnable;

public class Main {
    public static void main(String[] args) {
        var thread = new Thread(new MyTask()); // NEW state
        thread.getState();
        thread.start(); // RUNNABLE state
        System.out.println("Main thread is finished");
    }
}