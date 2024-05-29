package org.concurrent.chapter4.monitor;

import java.util.concurrent.atomic.AtomicInteger;

// Further Relaxing encapsulation with Atomic variables
public class BankAccount3 {
    private final AtomicInteger balance;

    public BankAccount3(AtomicInteger balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance.addAndGet(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        while (true) {
            int currentBalance = balance.get();
            if (currentBalance < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            int newBalance = currentBalance - amount;
            if (balance.compareAndSet(currentBalance, newBalance)) {
                break;
            }
        }
    }

    public int getBalance() {
        return balance.get();
    }

}
