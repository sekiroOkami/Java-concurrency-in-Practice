package ch01.recipe01.main;

import ch01.recipe01.task.Calculator;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.MAX_PRIORITY);
        System.out.printf("Maximum Priority: %s\n", Thread.MAX_PRIORITY);

        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];
        for (int i=0; i<10; i++) {
            threads[i] = new Thread(new Calculator());
            if (i%2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread: " + i);
        }

        try (FileWriter writer = new FileWriter(".\\src\\ch01\\recipe01\\result.txt");
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter pw = new PrintWriter(bw)){

            // write status of the threads
            for (int i = 0; i < 10; i++) {
                pw.println("Main: Status of Thread " +i+ " : "+ threads[i].getState());
                status[i] = threads[i].getState();
            }
            // start ten threads
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            // wait for the finalization of the threads. we save the status of the threads and only write the status
            // if it changes.
            boolean finish = false;
            while (!finish) {
                for (int i=0; i<10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i=0; i<10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State[] status) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", status);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
