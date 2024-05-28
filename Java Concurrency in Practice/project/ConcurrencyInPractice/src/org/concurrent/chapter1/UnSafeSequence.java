package org.concurrent.chapter1;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnSafeSequence {
    private int value;
    public int getNext() {
        return value++;
    }
}
