package org.concurrent.chapter3;

import net.jcip.annotations.NotThreadSafe;

/**
 * value field is accessed from both get and set without synchronization.
 */
@NotThreadSafe
public class MutableInteger {
    private int value;
    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
