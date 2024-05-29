package org.concurrent.chapter4.monitor;

// fully encapsulated Thread-Safe class
public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposite amount must be positive");
        }
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}
