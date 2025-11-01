package deadlock;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        final Account arzu = new Account("AZN123", BigDecimal.ONE);
        final Account kanan = new Account("AZN124", BigDecimal.TEN);
        var transferService = new BalanceTransferService();

        Thread thread1 = new Thread(() -> {
            transferService.transfer(kanan, arzu, BigDecimal.ONE);
        });

        Thread thread2 = new Thread(() -> {
            transferService.transfer(arzu, kanan, BigDecimal.ONE);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance of Account My: " + arzu.getBalance() + ". Should be 1");
        System.out.println("Final Balance of Account Yours: " + kanan.getBalance() + ". Should be 10");
    }
}
