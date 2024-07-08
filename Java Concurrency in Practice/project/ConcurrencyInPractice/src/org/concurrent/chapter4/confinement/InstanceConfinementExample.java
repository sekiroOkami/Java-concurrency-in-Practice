package org.concurrent.chapter4.confinement;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InstanceConfinementExample {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        var task1 = new WorkerThread(counter1);
        var task2 = new WorkerThread(counter2);

        var executor = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2 );

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        try {
            System.out.println("Thread 1 counter final value: " + result1.get());
            System.out.println("Thread 2 counter final value: " + result2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
