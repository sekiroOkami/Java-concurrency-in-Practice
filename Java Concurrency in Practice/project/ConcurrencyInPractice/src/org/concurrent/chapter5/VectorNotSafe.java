package org.concurrent.chapter5;

import net.jcip.annotations.NotThreadSafe;

import java.util.Vector;

@NotThreadSafe
public class VectorNotSafe {
    public static Object getLast(Vector list) {
        int lastIndex = list.size()-1;
        return list.get(lastIndex);
    }

    public static Object deleteLast(Vector list) {
        int lastIndex = list.size()-1;
        return list.remove(lastIndex);
    }
}
