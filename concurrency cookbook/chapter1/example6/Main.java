package chapter1.example6;

import java.util.*;
import java.util.concurrent.*;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        Deque<Event> deque = new ConcurrentLinkedDeque<Event>();
        WriterTask writer = new WriterTask(deque);
        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        for (int i=0; i< Runtime.getRuntime().availableProcessors(); i++) {
            executor.submit(writer);
            
        }
    }
}
