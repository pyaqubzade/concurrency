package atm;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var account = new BankAccount();

        var atm = new Thread(() -> account.withdraw(700));
        var online = new Thread(() -> account.withdraw(500));

        atm.start();
        online.start();

        atm.join();
        online.join();

        System.out.printf("Final balance: %d%n", account.getBalance());
    }
}
