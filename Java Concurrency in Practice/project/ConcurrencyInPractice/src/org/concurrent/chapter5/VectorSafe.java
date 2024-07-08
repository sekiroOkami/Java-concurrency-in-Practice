package org.concurrent.chapter5;

import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

@ThreadSafe
public class VectorSafe {
    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size()-1;
            return list.get(lastIndex);
        }

    }

    public static Object deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size()-1;
            return list.remove(lastIndex);
        }
    }
}
