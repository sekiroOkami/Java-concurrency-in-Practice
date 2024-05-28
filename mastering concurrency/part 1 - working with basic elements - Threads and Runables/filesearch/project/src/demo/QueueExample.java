package demo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        // Create a Queue
        Queue<String> queue = new LinkedList<>();

        queue.offer("apple");
        queue.offer("Banana");
        queue.offer("Orange");

        System.out.println("Queue: " + queue);

        // Remove and display the st element
        String firstElement = queue.poll();
        System.out.println("Removed Element: " + firstElement);
        System.out.println("Queue after removal: " + queue);

        // Peek the st element
        String peekedElement = queue.peek();
        System.out.println("Peeked Element: " + peekedElement);
        System.out.println("Queue after peek: " + queue);
    }
}
