package org.concurrent.chapter4.delegate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDelegate {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        // adding tasks
        taskList.addTask(new Task("Write documentation"));
        taskList.addTask(new Task("Implement feature x"));
        taskList.addTask(new Task("Fix bug Y"));

        // removing a task
        taskList.removeTask(new Task("Fix bug Y"));

        // Listing tasks
        System.out.println("Tasks");
        taskList.getTasks().stream()
                .forEach(System.out::println);

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            executor.submit(() -> taskList.addTask(new Task("Concurrent task")));
            executor.submit(() -> taskList.removeTask(new Task("Implement feature X")));
        } finally {
            executor.shutdown();
            executor.shutdownNow();
        }

        // Listing tasks after concurrent modification
        System.out.println("Tasks after concurrent modification");
        taskList.getTasks().stream()
                .forEach(System.out::println);

    }
}
