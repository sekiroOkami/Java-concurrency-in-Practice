package chapter1.example1;

import java.io.*;
import java.lang.Thread.State;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s\n",
            Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n",
            Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority: %s\n",
            Thread.MAX_PRIORITY);

        // create 10 Thread object to execute 10 Calculator task

        Thread[] threads;
        Thread.State[] status;
        threads = new Thread[10];
        status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        // Wait for the finalization of the threads. Meanwhile,
        // write the status of those threads in a file

        try (FileWriter file = new FileWriter(".\\chapter1\\data/log.txt");
        PrintWriter pw = new PrintWriter(file);) {

            // Write the status of the threads
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " +
                    threads[i].getState());
                status[i] = threads[i].getState();
            }

            // Start the ten threads
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            // Wait for the finalization of the threads. We save the status of
            // the threads and only write the status if it changes.
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == State.TERMINATED);
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
