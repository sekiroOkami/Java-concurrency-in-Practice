package org.concurrent.chapter5.iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@NotThreadSafe
public class HiddenIteratorSafe {
    @GuardedBy("This")
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {set.add(i);}
    public synchronized void remove(Integer i) { set.remove(i);}

    // public synchronized void addTenThings() {
    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i< 10; i++) {
            synchronized (this) {
                add(r.nextInt());

                // this statement accesses the 'set' directly without synchronization
                System.out.println("DEBUG:  added then elements to " + set);
            }

        }
    }
}
