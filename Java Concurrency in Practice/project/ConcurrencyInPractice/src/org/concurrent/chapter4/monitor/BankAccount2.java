package org.concurrent.chapter4.monitor;

import net.jcip.annotations.GuardedBy;

import java.util.concurrent.locks.ReentrantLock;

// Relaxing Encapsulation with ReentrantLock
public class BankAccount2 {
    @GuardedBy("lock")
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount2(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive");
            }
            if (balance >= amount) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
