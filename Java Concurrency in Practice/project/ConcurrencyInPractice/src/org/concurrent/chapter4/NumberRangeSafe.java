package org.concurrent.chapter4;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
public class NumberRangeSafe {
    // Invariant : lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);
    private final ReentrantLock lock = new ReentrantLock();

    public void setLower(int i) {
        lock.lock();
        try {
            if (i > upper.get()) {
                throw new IllegalArgumentException(
                        "can’t set lower to " + i + " > upper");
            }
            lower.set(i);
        } finally {
            lock.unlock();
        }
    }

    public void setUpper(int i) {
        lock.lock();
        try {
            if (i < lower.get()) {
                throw new IllegalArgumentException(
                        "can’t set upper to " + i + " < lower");
            }
            upper.set(i);
        } finally {
            lock.unlock();
        }
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
