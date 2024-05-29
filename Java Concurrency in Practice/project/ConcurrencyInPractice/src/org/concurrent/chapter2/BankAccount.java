package org.concurrent.chapter2;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.ReentrantLock;


@ThreadSafe
public class BankAccount {
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    /**
     * Serialized Access: The use of 'lock.lock()' and 'lock.unlock()' ensures that only one thread can execute the
     * method at a time.
     * Protocol for exclusive Access: The protocol is simple. acquire the lock before accessing the shared 'balance'
     * and release it afterward.
     * State Consistency: by following this locking protocol, we ensure that the shared 'balance' variable remains
     * consistent and is correctly update by multiple threads.
     * @param amount
     */
    public void deposit(int amount) {
        lock.lock(); // Acquire lock
        try {
            balance += amount; // critical section
        } finally {
            lock.unlock(); // Release lock
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount; // critical section
            } else {
                throw new IllegalArgumentException("Insufficient fund!");
            }
        } finally {
            lock.unlock(); // Release lock
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return balance;// critical section
        } finally {
            lock.unlock(); // release lock
        }
    }
}
