package atm;

public class BankAccount {

    private int balance = 1000;

    public void withdraw(int amount) {
        // Simulate processing delay
        try {
            Thread.sleep(10);
        } catch (InterruptedException ignored) {
        }
        synchronized (this) {
            if (balance >= amount) {
                balance -= amount;
            }
        }
    }

    public int getBalance() {
        return balance;
    }
}
