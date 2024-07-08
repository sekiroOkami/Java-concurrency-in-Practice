package org.concurrent.chapter5.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> synchronizedList = new ArrayList<>();

        // add some elements
        IntStream.range(0, 10).forEach(synchronizedList::add);

        // Start a Thread to modify the list concurrent
        var executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
//           synchronized (synchronizedList) {
               IntStream.range(10, 20)
                       .forEach(i-> {
                           synchronizedList.add(i);
                           try {
                               Thread.sleep(10);
                           } catch (InterruptedException e) {
                               Thread.currentThread().interrupt();
                           }
                       });
//           }
        });

        executor.shutdown();

        // Iterate over the list
        synchronized(synchronizedList) {
            var iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
