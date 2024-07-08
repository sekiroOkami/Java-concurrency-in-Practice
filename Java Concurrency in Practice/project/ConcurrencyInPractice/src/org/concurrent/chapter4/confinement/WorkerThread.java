package org.concurrent.chapter4.confinement;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;

// Each 'Counter' instance is confined to a single 'WorkerThread'
// No other thread can access or effigy a 'Counter' instance other than the one it is assigned to.
public class WorkerThread implements Callable<Integer> {
    // Each 'WorkerThread' instance has its own 'Counter' instance
    private final Counter counter;

    public WorkerThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
        System.out.println(Thread.currentThread().getName() + " final count: " + counter.getCounter());
        return counter.getCounter();
    }
}
