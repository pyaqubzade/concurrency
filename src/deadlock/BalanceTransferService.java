package deadlock;

import java.math.BigDecimal;

class BalanceTransferService {

    void transfer(Account from, Account to, BigDecimal amount) {

//        var acc1 = from.getAccountNo().hashCode();
//        var acc2 = to.getAccountNo().hashCode();
        Account first;
        Account second;
        if (from.getAccountNo().hashCode() > to.getAccountNo().hashCode()) {
            first = from;
            second = to;
        } else {
            second = from;
            first = to;
        }


        synchronized (first.getLock()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (second.getLock()) {
                if (from.getBalance().compareTo(amount) < 0) {
                    System.out.println("Insufficient balance in account: " + from.getAccountNo());
                }

                from.debit(amount);
                to.credit(amount);
            }
        }
    }
}