package org.concurrent.chapter4.confinement;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class Counter {
    private int counter =0;
    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
